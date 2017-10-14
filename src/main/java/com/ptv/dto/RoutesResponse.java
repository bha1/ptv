package com.ptv.dto;

import com.ptv.entity.Route;

public class RoutesResponse extends BaseResponse {
private Route[] routes;

public Route[] getRoutes() {
	return routes;
}

public void setRoutes(Route[] routes) {
	this.routes = routes;
}

}
