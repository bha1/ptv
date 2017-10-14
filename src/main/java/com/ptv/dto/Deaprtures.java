package com.ptv.dto;

import java.util.Date;

public class Deaprtures {
	public Integer stop_id;
    public Integer route_id;
    public Integer run_id;
    public Integer direction_id;
    public Integer[] disruption_ids;
    public String scheduled_departure_utc;//": "2017-10-09T22:59:00Z",
    public String estimated_departure_utc;//": null,
    public boolean at_platform;
    public Integer platform_number;//": null,
    public String flags; //": ""
	public Integer getStop_id() {
		return stop_id;
	}
	public void setStop_id(Integer stop_id) {
		this.stop_id = stop_id;
	}
	public Integer getRoute_id() {
		return route_id;
	}
	public void setRoute_id(Integer route_id) {
		this.route_id = route_id;
	}
	public Integer getRun_id() {
		return run_id;
	}
	public void setRun_id(Integer run_id) {
		this.run_id = run_id;
	}
	public Integer getDirection_id() {
		return direction_id;
	}
	public void setDirection_id(Integer direction_id) {
		this.direction_id = direction_id;
	}
	public Integer[] getDisruption_ids() {
		return disruption_ids;
	}
	public void setDisruption_ids(Integer[] disruption_ids) {
		this.disruption_ids = disruption_ids;
	}
	public String getScheduled_departure_utc() {
		return scheduled_departure_utc;
	}
	public void setScheduled_departure_utc(String scheduled_departure_utc) {
		this.scheduled_departure_utc = scheduled_departure_utc;
	}
	public String getEstimated_departure_utc() {
		return estimated_departure_utc;
	}
	public void setEstimated_departure_utc(String estimated_departure_utc) {
		this.estimated_departure_utc = estimated_departure_utc;
	}
	public boolean isAt_platform() {
		return at_platform;
	}
	public void setAt_platform(boolean at_platform) {
		this.at_platform = at_platform;
	}
	public Integer getPlatform_number() {
		return platform_number;
	}
	public void setPlatform_number(Integer platform_number) {
		this.platform_number = platform_number;
	}
	public String getFlags() {
		return flags;
	}
	public void setFlags(String flags) {
		this.flags = flags;
	}
    	
//    TimeZone tz = TimeZone.getTimeZone("UTC");
//    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
//    df.setTimeZone(tz);
//    String nowAsISO = df.format(new Date());
}
