package com.leone.chapter.profiles.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

@Service
public class MyApplicationRunner implements ApplicationRunner, Ordered {
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("this MyApplicationRunner is " + args.getSourceArgs()[0]);
	}


	@Override
	public int getOrder() {
		return 6;
	}
}
