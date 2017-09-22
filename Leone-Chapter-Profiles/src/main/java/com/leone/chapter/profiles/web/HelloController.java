package com.leone.chapter.profiles.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//@Value("${profiles.load.name}")
	@Value("${random.uuid}")
	private String name;

    @RequestMapping("/hello")
    public String index() {
		return "Hello World--" + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}