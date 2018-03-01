package com.leone.chapter2.web;

public class ThreadTest {
	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getId());


		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(Thread.currentThread().getId() + "    this is i" + i);

				}
				try {
					Thread.sleep(5000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("this is step 1");
		thread.run();
		System.out.println("this is step 2");
		thread.run();
		System.out.println("this is step 3");

	}


}
