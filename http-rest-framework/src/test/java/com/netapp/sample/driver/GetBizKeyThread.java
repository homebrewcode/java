package com.netapp.sample.driver;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.netapp.supportsite.http.client.XmlHttpClient;
import com.netapp.supportsite.parser.SolrParser;
import com.netapp.supportsite.url.builder.SolrURLBuilder;

public class GetBizKeyThread implements Callable<String> {

	private String asupId;
	public GetBizKeyThread(String asupId){
		this.asupId = asupId;
	}
	
	public String call() throws Exception {
		String bizKey = getBizKey(asupId);
		return bizKey;
	}
	
	
	private String getBizKey(String asupId) throws IOException{

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

}