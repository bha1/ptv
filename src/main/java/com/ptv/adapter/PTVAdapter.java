package com.ptv.adapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.ptv.dto.Deaprtures;
import com.ptv.dto.DirectionResponse;
import com.ptv.dto.PTVResponse;
import com.ptv.dto.RoutesResponse;
import com.ptv.entity.Direction;
import com.ptv.entity.Route;
import com.ptv.infra.PTVConnection;

public class PTVAdapter {

	public static final Integer timeout = 1000;
	public static TimeZone tz = TimeZone.getTimeZone("UTC");
	public static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
	public static final String colon = ":";
	public static final String replaceColonwith = "%3A";
	static {
		df.setTimeZone(tz);
	}
	
	
	public String[] getNextTrams() {
		String[] times = new String[3];
		PTVConnection con = new PTVConnection();
		String nowAsISO = df.format(new Date());
		nowAsISO.replaceAll(colon,replaceColonwith);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		//SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
		// rf.setReadTimeout(timeout);
		// rf.setConnectTimeout(timeout);
		PTVResponse response = null;

		try {
			String url = con.wrapper(
					"/v3/departures/route_type/1/stop/2864/route/1880?direction_id=16&max_results=3&date_utc=" + nowAsISO);
			System.out.println(url);
			response = restTemplate.getForObject(url, PTVResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (response != null)
			for (Deaprtures departure : response.getDepartures()) {
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
				if (departure.getEstimated_departure_utc() != null) {
					// LocalDate estimated = df.parse(departure.getEstimated_departure_utc());
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

		return times;
	}
	
	public ArrayList<Route> getRoutes(){
		PTVConnection con = new PTVConnection();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		//SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
		// rf.setReadTimeout(timeout);
		// rf.setConnectTimeout(timeout);
		RoutesResponse response = null;
		try {
			String url = con.wrapper(
					"/v3/routes?route_types=1&route_types=0");
			System.out.println(url);
			System.out.println();
			response = restTemplate.getForObject(url, RoutesResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Route>(Arrays.asList(response.getRoutes()));
	}
	
	public ArrayList<Direction> getDirection(String route_id){
		PTVConnection con = new PTVConnection();
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
		//SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
		// rf.setReadTimeout(timeout);
		// rf.setConnectTimeout(timeout);
		DirectionResponse response = null;
		try {
			String url = con.wrapper(
					"/v3/directions/route/"+route_id);
			System.out.println(url);
			System.out.println();
			response = restTemplate.getForObject(url, DirectionResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Direction>(Arrays.asList(response.getDirections()));
	}
	
}
