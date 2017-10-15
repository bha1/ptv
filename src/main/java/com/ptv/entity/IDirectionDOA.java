package com.ptv.entity;

import java.util.ArrayList;

public interface IDirectionDOA {

	Direction getDirectionByRouteId(String route_id);

	void addDirectionAll(ArrayList<Direction> directionList);

}
