package com.product.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping(path = "{productId}")
    public String getProductInfo(@PathVariable String productId) {
    	//fallback 에러를 확인하기 위해 에러를 내보았습니다.
    	//1. 억지로 에러를 던져보자
//    	throw new RuntimeException("I/O Exception");
    	//2. sleep을 줘서 응답시간을 지연 시켜보자
//    	try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	System.out.println("called product id :: " + productId);
        return "[product id = " + productId + " at " + System.currentTimeMillis() + "]";
    }
}
