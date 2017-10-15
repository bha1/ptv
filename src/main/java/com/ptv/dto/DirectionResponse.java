package com.ptv.dto;

import com.ptv.entity.Direction;

public class DirectionResponse extends BaseResponse {
	private Direction[] directions;

	public Direction[] getDirections() {
		return directions;
	}

	public void setDirections(Direction[] directions) {
		this.directions = directions;
	}
	
}
