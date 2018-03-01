package com.leone.chapter2;

import com.leone.chapter2.web.TestProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TestProperties.class)
public class Chapter2Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter2Application.class, args);
	}

}
