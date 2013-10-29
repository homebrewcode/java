package com.bytemeagain.thread;

public class ThreadProcessor extends Thread{

	@Override
	public void run() {

		//while(true){
		
		//Do some work for random amount of time
		try {
			long temp = (long) (Math.random()*10000);
			Thread.sleep(temp);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Processing the OLD-THREAD: "+Thread.currentThread().getName());
		
		//}


	}


}
