package com.bytemeagain.thread.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.bytemeagain.thread.CallableProcess;
import com.bytemeagain.thread.RunnableProcess;

public class ThreadProcessScheduledExecutor {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
				
		//Single thread is created
		ScheduledExecutorService scheduledExe= Executors.newScheduledThreadPool(10);
			
		
		List<Future<String>> futureList = new ArrayList<Future<String>>();	

		//Start all the threads to execute the runnable process
		for(int i=0;i<10;i++){

			//Some simple round robin algorithm to allocate it to either runnable or callable
			if(i%2==0){
				scheduledExe.schedule(new RunnableProcess(),1,TimeUnit.SECONDS);
			}else{
				Future<String> temp = scheduledExe.schedule(new CallableProcess(),10,TimeUnit.SECONDS);
				futureList.add(temp);
				//This one piece of code will stop running further till the callable thread is executed
				//System.out.println(temp.get());
			}
			
		}

		System.out.println(">>>>>>>>>>>>>> Attempting to shutdown the executor");	
		scheduledExe.shutdown();

		if(scheduledExe.isShutdown()){
			System.out.println(">>>>>>>>>>>>> Executor has been shutdown!!!");
		}
		
		

	}

}
