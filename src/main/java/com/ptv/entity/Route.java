package com.ptv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="ROUTES")
@IdClass(RouteId.class)
public class Route implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2136217337391863754L;
	
	@Id
	@Column(name="ROUTE_TYPE")
	private String route_type;
	
	@Id
	@Column(name="ROUTE_ID")
	private String route_id;
	
	@Column(name="ROUTE_NAME")
	private String route_name;
	
	@Column(name="ROUTE_NUMBER")
	private String route_number;

	public String getRoute_type() {
		return route_type;
	}

	public void setRoute_type(String route_type) {
		this.route_type = route_type;
	}

	public String getRoute_id() {
		return route_id;
	}

	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}

	public String getRoute_name() {
		return route_name;
	}

	public void setRoute_name(String route_name) {
		this.route_name = route_name;
	}

	public String getRoute_number() {
		return route_number;
	}

	public void setRoute_number(String route_number) {
		this.route_number = route_number;
	}

	

}
