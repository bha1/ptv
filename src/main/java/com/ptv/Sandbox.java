package com.ptv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptv.adapter.PTVAdapter;
import com.ptv.entity.Direction;
import com.ptv.entity.RouteRepository;
import com.ptv.google.dto.GoogleRequest;
import com.ptv.google.dto.GoogleResponse;
import com.ptv.service.IPTVService;
import com.ptv.service.PTVService;

@RestController
@RequestMapping(path="/getnext")
public class Sandbox {
	
	@Autowired
	IPTVService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public GoogleResponse getNextThree() {
		PTVAdapter adapter = new PTVAdapter();
		String[] times = adapter.getNextTrams();
		GoogleResponse response = new GoogleResponse();
		StringBuilder builder = new StringBuilder();
		builder.append("next tram is in, ");
		builder.append(times[2]);
		builder.append(" minutes");
		response.setDisplayText(builder.toString());
		response.setSource("PTV");
		response.setSpeech(builder.toString());
		return response;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public GoogleResponse postNextThree(@RequestBody GoogleRequest body) {
		System.out.println(body.getResult().getMetadata().getIntentId());
		System.out.println(body.getResult().getMetadata().getIntentId());
		System.out.println("some test");
		//PTVService service = new PTVService();
		Direction[] direction = null;
		if("f87fc4ff-806a-48d9-9d6d-58b40b0a41b9".equals(body.getResult().getMetadata().getIntentId())) {
			direction = service.getDirectionsByRouteId(service.getRouteByNumber(body.getResult().getParameters().getRoute_number()).getRoute_id());
		}
		service.listRoutes();
		PTVAdapter adapter = new PTVAdapter();
		//String[] times = adapter.getNextTrams();
		GoogleResponse response = new GoogleResponse();
		StringBuilder builder = new StringBuilder();
		String[] times = {"a","b","c"};
		builder.append("trams available in these directions ");
		for (int i = 0; i < direction.length; i++) {
			builder.append(direction[i].getDirection_name());
			builder.append(", ");
		}
		builder.append(" choose one.");
		response.setDisplayText(builder.toString());
		response.setSource("PTV");
		response.setSpeech(builder.toString());
		return response;
	}
	
	@RequestMapping(path="/init",method=RequestMethod.GET)
	public String beginInit() {
		return service.beginInit();
	}
}
