package com.bytemeagain.thread;

import java.util.concurrent.Callable;

public class CallableProcess implements Callable<String>{

	public String call() throws Exception {
		//Do some work for random amount of time
		try {
			long temp = (long) (Math.random()*10000);
			Thread.sleep(temp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Processing the callable thread: "+Thread.currentThread().getName());
		return "Hello, thread!!";
	}

}
