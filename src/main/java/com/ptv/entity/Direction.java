package com.ptv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="DIRECTIONS")
@IdClass(DirectionId.class)
public class Direction implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -7664009263807406116L;
	@Id
	@Column(name="DIRECTION_ID")
	private String direction_id;

	@Column(name="DIRECTION_NAME")
    private String direction_name;
	@Id
	@Column(name="ROUTE_ID")
    private String route_id;
	@Id
	@Column(name="ROUTE_TYPE")
    private String route_type;
	
	public String getDirection_id() {
		return direction_id;
	}
	public void setDirection_id(String direction_id) {
		this.direction_id = direction_id;
	}
	public String getDirection_name() {
		return direction_name;
	}
	public void setDirection_name(String direction_name) {
		this.direction_name = direction_name;
	}
	public String getRoute_id() {
		return route_id;
	}
	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}
	public String getRoute_type() {
		return route_type;
	}
	public void setRoute_type(String route_type) {
		this.route_type = route_type;
	}
	
	
}
