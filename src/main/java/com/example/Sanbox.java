package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ptv.adapter.PTVAdapter;

@RestController
@RequestMapping(path="/getnext")
public class Sanbox {
	@RequestMapping(method=RequestMethod.GET)
	public String[] betNextThree() {
		PTVAdapter adapter = new PTVAdapter();
		String[] times = adapter.getNextTrams();
		return times;
	}
}
