package com.ptv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROUTES")
public class Route implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2136217337391863754L;
	
	@Id
	@Column(name="ROUTE_TYPE")
	private String routeType;
	
	@Id
	@Column(name="ROUTE_ID")
	private String routeId;
	
	@Column(name="ROUTE_NAME")
	private String routeName;
	
	@Column(name="ROUTE_NUMBER")
	private String routeNumber;

	public String getRouteType() {
		return routeType;
	}

	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getRouteNumber() {
		return routeNumber;
	}

	public void setRouteNumber(String routeNumber) {
		this.routeNumber = routeNumber;
	}
	
	
	

}
