package com.ptv.entity;

import java.io.Serializable;

public class RouteId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5176940530547000239L;

	private String route_type;
	private String route_id;
 
	public RouteId() {
 
	}
 
	public RouteId(String route_type, String route_id) {
		this.route_type = route_type;
		this.route_id = route_id;
	}

	public String getRoute_type() {
		return route_type;
	}

	public String getRoute_id() {
		return route_id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((route_type == null) ? 0 : route_type.hashCode());
		result = prime * result + ((route_id == null) ? 0 : route_id.hashCode());
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RouteId other = (RouteId) obj;
		if (route_type == null) {
			if (other.route_type != null)
				return false;
		} else if (!route_type.equals(other.route_type))
			return false;
		if (route_id != other.route_id)
			return false;
		return true;
	}

 
}
