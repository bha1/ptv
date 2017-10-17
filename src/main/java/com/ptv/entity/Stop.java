package com.ptv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STOPS")
public class Stop implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3915965429675478143L;

	@Column(name="STATION_TYPE")
    private String station_type;

	@Column(name="STATION_DESCRIPTION")
	private String station_description;

	@Id
	@Column(name="ROUTE_TYPE")
	private Integer route_type;

	@Column(name="STOP_NAME")
	private String stop_name;
	
	@Column(name="STOP_NAME")
	private String stop_nnumber;
	
	@Id
	@Column(name="STOP_ID")
	private Integer stop_id;
	
	@Column(name="STOP_LATITUDE")
	private Long stop_latitude;
	
	@Column(name="STOP_LONGITUDE")
	private Long stop_longitude;
	
	@Column(name="STOP_LOCATION")
	private String stop_location;
	
	@Column(name="STOP_AMENITIES")
	private String stop_amenities;
	
	@Column(name="STOP_ACCESSIBILITY")
	private String stop_accessibility;

	public String getStation_type() {
		return station_type;
	}

	public void setStation_type(String station_type) {
		this.station_type = station_type;
	}

	public String getStation_description() {
		return station_description;
	}

	public void setStation_description(String station_description) {
		this.station_description = station_description;
	}

	public Integer getRoute_type() {
		return route_type;
	}

	public void setRoute_type(Integer route_type) {
		this.route_type = route_type;
	}

	public String getStop_name() {
		return stop_name;
	}

	public void setStop_name(String stop_name) {
		this.stop_name = stop_name;
	}

	public String getStop_nnumber() {
		return stop_nnumber;
	}

	public void setStop_nnumber(String stop_nnumber) {
		this.stop_nnumber = stop_nnumber;
	}

	public Integer getStop_id() {
		return stop_id;
	}

	public void setStop_id(Integer stop_id) {
		this.stop_id = stop_id;
	}

	public Long getStop_latitude() {
		return stop_latitude;
	}

	public void setStop_latitude(Long stop_latitude) {
		this.stop_latitude = stop_latitude;
	}

	public Long getStop_longitude() {
		return stop_longitude;
	}

	public void setStop_longitude(Long stop_longitude) {
		this.stop_longitude = stop_longitude;
	}

	public String getStop_location() {
		return stop_location;
	}

	public void setStop_location(String stop_location) {
		this.stop_location = stop_location;
	}

	public String getStop_amenities() {
		return stop_amenities;
	}

	public void setStop_amenities(String stop_amenities) {
		this.stop_amenities = stop_amenities;
	}

	public String getStop_accessibility() {
		return stop_accessibility;
	}

	public void setStop_accessibility(String stop_accessibility) {
		this.stop_accessibility = stop_accessibility;
	}
	
}
