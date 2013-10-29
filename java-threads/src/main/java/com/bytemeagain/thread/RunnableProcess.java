package com.bytemeagain.thread;


public class RunnableProcess implements Runnable{

	public void run() {
		
		//Do some work for random amount of time
		try {
			long temp = (long) (Math.random()*10000);
			Thread.sleep(temp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Processing the runnable thread: "+Thread.currentThread().getName());
	
	}
	
}
