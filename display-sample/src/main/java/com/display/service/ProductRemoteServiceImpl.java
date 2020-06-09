package com.display.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProductRemoteServiceImpl implements ProductRemoteService {

	private static final String URL = "http://localhost:8082/products/";

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Hystrix 기본 콜백시간은 1초
	 * commandKey는 해당 키에만 circuit breaker가 적용된다
	 */
	@Override
	@HystrixCommand(commandKey = "ExtDep1", fallbackMethod = "getProductInfoFallback")
	public String getProductInfo(String productId) {
		return this.restTemplate.getForObject(URL+productId, String.class);
	}

	public String getProductInfoFallback(String productId, Throwable t) {
		System.out.println("Error : " + t.getMessage());
		return "[this product is sold out]";
	}

}
