package com.bytemeagain.thread.executor;

import com.bytemeagain.thread.ThreadProcessor;

public class ThreadProcessorOld2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i=0;i<10;i++){
			Thread thread = new ThreadProcessor();
			thread.setName("ShashiRunning-"+i);
			thread.start();
		}
		
		System.out.println("All threads in progress..");
		
	}

}
