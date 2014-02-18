package com.netapp.sample.driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang3.time.StopWatch;


public class SolrGetParallel {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//Read input from file
		BufferedReader br = new BufferedReader(new FileReader("src/test/resources/asup_id_list.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/test/resources/hitList.txt")));
		BufferedWriter bwM = new BufferedWriter(new FileWriter(new File("src/test/resources/missedList.txt")));
		
		ExecutorService exeService = Executors.newFixedThreadPool(20);
		
		Map<String,Future<String>> asupMapping = new LinkedHashMap<String, Future<String>>(); 
		int count=0;
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		try{
			String asupId;
			
			//Spawn all the threads.. get the biz_keys
			while ((asupId = br.readLine()) != null) {
				Future<String> futureBizKey = exeService.submit(new GetBizKeyThread(asupId));
				asupMapping.put(asupId, futureBizKey);
				/*String bizKey = getBizKey(asupId.trim());
				if(bizKey == null){
					System.out.println("Skipping: "+asupId);
					bwM.write(asupId+"\n");
					bw.write(" "+""+"\n");
					continue;
				}
				bw.write(bizKey+"\n");*/
				System.out.println((count++)+".) "+"Processed: "+asupId);
				/*System.out.println("Received bizKey: "+futureBizKey.get());*/
			}
			
			count=0;
			for(Entry<String, Future<String>> asupIdInstance: asupMapping.entrySet()){
				count++;
				asupId = asupIdInstance.getKey();
				String bizKey = asupIdInstance.getValue().get();
				System.out.println(count+".) ASUP ID: "+asupId);
				System.out.println(count+".) BIZ KEY: "+bizKey);
				System.out.println("--------------------------------");
				
				//Write to file
				if(bizKey == null){
					System.out.println("Skipping: "+asupId);
					bwM.write(asupId+"\n");
					bw.write(" "+""+"\n");
					continue;
				}
				bw.write(bizKey+"\n");
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally{
			br.close();
			bw.flush();
			bw.close();
			bwM.flush();
			bwM.close();
			exeService.shutdown();
			stopWatch.split();
			printTime(stopWatch.getSplitTime());
			stopWatch.stop();
		}
		


	}


	private static void printTime(long ms){
		System.out.println("-------------- TIME --------------");
		System.out.println("Seconds: "+ (ms/1000)%60);
		System.out.println("Minutes: "+ (ms/(1000*60))%60);
		System.out.println("Hours:   "+ (ms/(1000*60*60))%24);
	}

}
