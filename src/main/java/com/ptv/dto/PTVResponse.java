package com.ptv.dto;

public class PTVResponse {
	private Deaprtures[] departures;
	private BaseResponse stops;
	private BaseResponse routes;
	private BaseResponse runs;
	private BaseResponse directions;
	private BaseResponse disruptions;
	private BaseResponse status;
	public Deaprtures[] getDepartures() {
		return departures;
	}
	public void setDepartures(Deaprtures[] departures) {
		this.departures = departures;
	}
	public BaseResponse getStops() {
		return stops;
	}
	public void setStops(BaseResponse stops) {
		this.stops = stops;
	}
	public BaseResponse getRoutes() {
		return routes;
	}
	public void setRoutes(BaseResponse routes) {
		this.routes = routes;
	}
	public BaseResponse getRuns() {
		return runs;
	}
	public void setRuns(BaseResponse runs) {
		this.runs = runs;
	}
	public BaseResponse getDirections() {
		return directions;
	}
	public void setDirections(BaseResponse directions) {
		this.directions = directions;
	}
	public BaseResponse getDisruptions() {
		return disruptions;
	}
	public void setDisruptions(BaseResponse disruptions) {
		this.disruptions = disruptions;
	}
	public BaseResponse getStatus() {
		return status;
	}
	public void setStatus(BaseResponse status) {
		this.status = status;
	}
}
