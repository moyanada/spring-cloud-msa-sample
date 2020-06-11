package com.display.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


//@FeignClient(name = "product", url = "http://localhost:8082/")
//@FeignClient(name = "product") //URL만 지워주면 eureka를 사용하게 됨 feign = hystrix + ribbon + eureka
@FeignClient(name = "product", fallbackFactory = FeignProductRemoteServiceFallbackFactory.class) //feign에서의 fallback설정은 class로한다
public interface FeignProductRemoteService {
    @RequestMapping(path = "/products/{productId}")
    String getProductInfo(@PathVariable("productId") String productId);
}