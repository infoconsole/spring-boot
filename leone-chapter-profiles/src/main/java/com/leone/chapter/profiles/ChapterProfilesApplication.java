package com.leone.chapter.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class ChapterProfilesApplication {

	public static void main(String[] args) {
		//使用javaConfig
		SpringApplication.run(ChapterProfilesApplication.class, args);
		//使用package
//		Package aPackage =Package.getPackage("com.leone.chapter.profiles");
//		SpringApplication.run(aPackage, args);
		//使用Resource
//		SpringApplication.run(new ClassPathResource("applicationContext.xml"), args);

		//使用String
//		SpringApplication.run("classpath:/applicationContext.xml", args);
	}

}
