package com.display.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.display.service.ProductRemoteService;

@RestController
@RequestMapping(path = "/displays")
public class DisplayController {

	@Autowired
	private ProductRemoteService productRemoteService;

	@GetMapping(path = "/{displayId}")
    public String getDisplayDetail(@PathVariable String displayId) {
        String productInfo = getProductInfo();
        return String.format("[display id = %s at %s %s ]", displayId, System.currentTimeMillis(), productInfo);
    }

	private String getProductInfo() {
		return productRemoteService.getProductInfo("12345");
	}
}