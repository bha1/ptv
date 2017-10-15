package com.ptv.entity;

import java.util.ArrayList;
import java.util.List;

public interface IRouteDAO {
    List<Route> getAllRoutes();
    Route getRouteById(String routeId);
    void addRoute(Route route);
    void updateRoute(Route route);
    void deleteRoute(RouteId routeId);
	void addRouteAll(ArrayList<Route> routeList);
	void deleteAllRoutes();
	void deleteRoute(Route routeId);
	Route getRouteByrouteId(String route_id);
	Route getRouteByRouteNumber(String route_number);
}
