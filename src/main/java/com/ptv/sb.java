package com.ptv;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class sb {
public static void main(String[] args) {
	String str = "2017-10-09T22:35:00Z";
    TimeZone tz = TimeZone.getTimeZone("UTC");
    Instant inst = Instant.parse("2017-10-09T22:35:00Z");
    Date dz = Date.from(inst);
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
    df.setTimeZone(tz);
    try {
		Date d = df.parse(str.replaceFirst("Z", "+000"));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
