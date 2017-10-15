package com.ptv.service;

import com.ptv.entity.Direction;
import com.ptv.entity.Route;

public interface IPTVService {

	void listRoutes();

	String beginInit();

	Route getRouteByNumber(String route_name);

	Direction[] getDirectionsByRouteId(String route_id);

}
