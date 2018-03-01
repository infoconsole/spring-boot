package com.leone.chapter2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private TestProperties testProperties;

	@RequestMapping("/hello")
	public String index() {
		return "Hello World" + testProperties.getName() + "--" + testProperties.getMark().getDmark();
	}

}