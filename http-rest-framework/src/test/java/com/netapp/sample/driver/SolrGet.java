package com.netapp.sample.driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang3.time.StopWatch;
import org.xml.sax.SAXException;

import com.netapp.supportsite.http.client.XmlHttpClient;
import com.netapp.supportsite.parser.SolrParser;
import com.netapp.supportsite.url.builder.SolrURLBuilder;


public class SolrGet {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//Read input from file
		BufferedReader br = new BufferedReader(new FileReader("src/test/resources/asup_id_list.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/test/resources/hitList.txt")));
		BufferedWriter bwM = new BufferedWriter(new FileWriter(new File("src/test/resources/missedList.txt")));
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		int count=0;
		try{
			
			String asupId;
			while ((asupId = br.readLine()) != null) {
				count++;
				String bizKey = getBizKey(asupId.trim());
				if(bizKey == null){
					System.out.println("Skipping: "+asupId);
					bwM.write(asupId+"\n");
					bw.write(" "+""+"\n");
					continue;
				}
				bw.write(bizKey+"\n");
				System.out.println(count+".) Processed: "+asupId);
				System.out.println(count+".) BizKey: "+bizKey);
				System.out.println("--------------------------------");
			}
		}finally{
			br.close();
			bw.flush();
			bw.close();
			bwM.flush();
			bwM.close();
			stopWatch.split();
			printTime(stopWatch.getSplitTime());
			stopWatch.stop();
		}
		
		


		/*SimpleSaxHandler saxHandler = new SimpleSaxHandler(filterList,false);
		saxParser.parse(is, saxHandler);
		 */

		//Write output to a file



	}


	private static String getBizKey(String asupId) throws IOException{

		//Populate domain object
		SolrURLBuilder solrURLBuilder = new SolrURLBuilder(asupId);

		/*//Print URL
		System.out.println(solrURLBuilder.buildUrl());*/

		//Create XML HTTP Client
		XmlHttpClient xmlHttpClient = new XmlHttpClient(solrURLBuilder, "GET");
		//Time out defaults to 5s, however it can be overridden
		xmlHttpClient.setTimeOut(10000);
		InputStream is = xmlHttpClient.getDataFromWire();


		//Convert the InputStream to String and dump it on the console
		/*ParseToString pToS = new ParseToString();

		System.out.println(pToS.parseData(is));*/

		SolrParser solrParser = null;
		List<String> filterList = new ArrayList<String>();
		filterList.add("biz_key");
		try {
			solrParser = new SolrParser();
			Map<String, String> resultMap = solrParser.parseData(is, filterList, false);

			return resultMap.get("biz_key");
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}
	

	private static void printTime(long ms){
		System.out.println("-------------- TIME --------------");
		System.out.println("Seconds: "+ (ms/1000)%60);
		System.out.println("Minutes: "+ (ms/(1000*60))%60);
		System.out.println("Hours:   "+ (ms/(1000*60*60))%24);
	}


}
