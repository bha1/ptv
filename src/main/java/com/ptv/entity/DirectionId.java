package com.ptv.entity;

import java.io.Serializable;

public class DirectionId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2494287144775709034L;

	private String direction_id;

    private String route_id;

    private String route_type;

	public String getDirection_id() {
		return direction_id;
	}

	public String getRoute_id() {
		return route_id;
	}

	public String getRoute_type() {
		return route_type;
	}
    
    
}
