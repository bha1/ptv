package com.ptv.adapter;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.Deaprtures;
import com.example.PTVResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptv.infra.PTVConnection;

public class PTVAdapter {
	public String[] getNextTrams() {
		String[] times = new String[3];
		 HttpClient httpClient = new DefaultHttpClient();
		    try {
		    	PTVConnection con = new PTVConnection();
		      TimeZone tz = TimeZone.getTimeZone("UTC");
		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
		      df.setTimeZone(tz);
		      String nowAsISO = df.format(new Date());
		      nowAsISO.replaceAll(":", "%3A");
		    	String url = con.wrapper("/v3/departures/route_type/1/stop/2864/route/1880?direction_id=16&max_results=3&date_utc="+nowAsISO);
		    	System.out.println(url);
		      HttpGet httpGetRequest = new HttpGet(url);
		      HttpResponse httpResponse = httpClient.execute(httpGetRequest);

		      System.out.println("----------------------------------------");
		      System.out.println(httpResponse.getStatusLine());
		      System.out.println("----------------------------------------");

		      HttpEntity entity = httpResponse.getEntity();
		      PTVResponse dep = new PTVResponse();
//		      TimeZone tz = TimeZone.getTimeZone("UTC");
//		      DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'z'"); // Quoted "Z" to indicate UTC, no timezone offset
//		      df.setTimeZone(tz);
		      byte[] buffer = new byte[1024];
		      if (entity != null) {
		        InputStream inputStream = entity.getContent();
		        try {
		        	StringBuilder builder = new StringBuilder();
		          int bytesRead = 0;
		          BufferedInputStream bis = new BufferedInputStream(inputStream);
		          while ((bytesRead = bis.read(buffer)) != -1) {
		            String chunk = new String(buffer, 0, bytesRead);
		            System.out.println(chunk);
		            builder.append(chunk);
		          }
		          ObjectMapper mapper = new ObjectMapper();
		        //  final DateTimeFormatter sdf = new DateTimeFormatter("EEE, MMM d, yyyy hh:mm:ss a z");
		          dep = mapper.readValue(builder.toString(), PTVResponse.class);
		          ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		          for(Deaprtures departure : dep.getDepartures()) {
		        	//  CharSequence dt = departure.getScheduled_departure_utc();
		        	//  ZonedDateTime scheduled = ZonedDateTime.parse(dt, sdf);
		        	//  LocalDate scheduled = LocalDate.parse(departure.getScheduled_departure_utc(), df);
		        	  Date now = new Date();
		        	  Instant inst = Instant.parse(departure.getScheduled_departure_utc());
		        	  Date sDate = Date.from(inst);
		        	  Date eDate = new Date();
		        	  long diff;
		        	  long diffMinutes = -99;
	        		  diff = sDate.getTime() - now.getTime();
	        		  diffMinutes = diff / (60 * 1000);
		        	  times[0] = df.format(new Date());
		        	  times[1] = departure.getScheduled_departure_utc();
		        	  if(departure.getEstimated_departure_utc()!= null) {
		        		//  LocalDate estimated = df.parse(departure.getEstimated_departure_utc());
		        		  inst = Instant.parse(departure.getEstimated_departure_utc());
		        		  eDate = Date.from(inst);
		        		  times[0] = departure.getScheduled_departure_utc();
		        		  times[1] = departure.getEstimated_departure_utc();
		        		  diff = eDate.getTime() - now.getTime();
		        		  diffMinutes = diff / (60 * 1000);
		        	  }
		        	  times[2] = String.valueOf(diffMinutes);
		        	  break;
		          }
		          
		        } catch (Exception e) {
		          e.printStackTrace();
		        } finally {
		          try { inputStream.close(); } catch (Exception ignore) {}
		        }
		      }    } catch (Exception e) {
		          e.printStackTrace();
		      } finally {
		        httpClient.getConnectionManager().shutdown();
		      }
		    
		return times;
	}
}
