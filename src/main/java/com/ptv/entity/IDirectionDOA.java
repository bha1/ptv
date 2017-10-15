package com.ptv.entity;

import java.util.ArrayList;

public interface IDirectionDOA {

	ArrayList<Direction> getDirectionsByRouteId(String route_id);

	void addDirectionAll(ArrayList<Direction> directionList);

}
