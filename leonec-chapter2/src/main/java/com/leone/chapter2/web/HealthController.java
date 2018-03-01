package com.leone.chapter2.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@RequestMapping("/health")
	public String index() {
		return "{\"message\":\"OK\"}";
	}

}
