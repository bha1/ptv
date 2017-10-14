package com.ptv;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/healthcheck")
public class HealthCheck {


	@RequestMapping(path = "/a",method = RequestMethod.GET)
	public String check() {
		int timeout = 1000;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
        SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate
                .getRequestFactory();
        rf.setReadTimeout(timeout);
        rf.setConnectTimeout(timeout);
        String quote = null;
        try {
			Thread.sleep(300000);
			quote = restTemplate.getForObject("https://fathomless-sands-76170.herokuapp.com/healthcheck/b", String.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("time out in health a");
		}
        System.out.println(quote+"->a");
		return quote;
	}
	
	@RequestMapping(path = "/b",method = RequestMethod.GET)
	public String checkb() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
        SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate
                .getRequestFactory();
        rf.setReadTimeout(1000);
        rf.setConnectTimeout(1000);
        String quote = null;
        try {
 			Thread.sleep(300000);
 			quote = restTemplate.getForObject("https://fathomless-sands-76170.herokuapp.com/healthcheck/a", String.class);
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			System.err.println("time out in health b");
 		}
        System.out.println(quote+"->b");
        return quote;
	}
	
}
