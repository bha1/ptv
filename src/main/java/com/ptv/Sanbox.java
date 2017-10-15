package com.ptv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptv.adapter.PTVAdapter;
import com.ptv.entity.RouteRepository;
import com.ptv.google.dto.GoogleResponse;
import com.ptv.service.IPTVService;
import com.ptv.service.PTVService;

@RestController
@RequestMapping(path="/getnext")
public class Sanbox {
	
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
	public GoogleResponse postNextThree(@RequestBody Object body) {
		System.out.println(body.toString());
		System.out.println("some test");
		//PTVService service = new PTVService();
		service.listRoutes();
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
	
	@RequestMapping(path="/init",method=RequestMethod.GET)
	public String beginInit() {
		return service.beginInit();
	}
}
