package com.bytemeagain.thread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.bytemeagain.thread.CallableProcess;
import com.bytemeagain.thread.RunnableProcess;

public class ThreadProcessExecutor {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//Fixed thread pool
		//ExecutorService exe= Executors.newFixedThreadPool(10);
		
		//Cached thread pool
		//ExecutorService exe= Executors.newCachedThreadPool();
		
		//Single thread is created
		ExecutorService exe= Executors.newSingleThreadExecutor();
		
		
		List<Future<String>> futureList = new ArrayList<Future<String>>();	

		//Start all the threads to execute the runnable process
		for(int i=0;i<10;i++){

			//Some simple round robin algorithm to allocate it to either runnable or callable
			if(i%2==0){
				exe.execute(new RunnableProcess());
			}else{
				Future<String> temp = exe.submit(new CallableProcess());
				futureList.add(temp);
				//This one piece of code will stop running further till the callable thread is executed
				//System.out.println(temp.get());
			}
			
		}

		Thread.sleep(10000);
		System.out.println(">>>>>>>>>>>>>> Attempting to shutdown the executor");	
		exe.shutdown();

		if(exe.isShutdown()){
			System.out.println(">>>>>>>>>>>>> Executor has been shutdown!!!");
		}
		
		

	}

}
