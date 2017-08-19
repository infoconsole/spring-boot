package com.leone.chapter1;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import java.util.UUID;
@Service
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		applicationContext.setId(UUID.randomUUID().toString().toUpperCase().replace("-", ""));
		System.out.println(applicationContext.getId());
	}
}
