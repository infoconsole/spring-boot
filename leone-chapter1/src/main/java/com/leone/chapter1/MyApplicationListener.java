package com.leone.chapter1;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("我接收到了信息！！！");
		System.out.println(event.getClass().getName());
	}
}
