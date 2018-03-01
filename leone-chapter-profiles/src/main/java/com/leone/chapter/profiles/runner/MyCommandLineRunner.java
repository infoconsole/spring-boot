package com.leone.chapter.profiles.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;


@Service
public class MyCommandLineRunner implements CommandLineRunner, Ordered {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("this MyCommandLineRunner is " + args[0]);
	}


	@Override
	public int getOrder() {
		return 5;
	}
}
