package com.netapp.sample.driver;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.netapp.supportsite.http.client.XmlHttpClient;
import com.netapp.supportsite.parser.ParseToString;
import com.netapp.supportsite.url.builder.NGSSupportCase;


public class TestNgsSupportCaseGet {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//Populate domain object
		NGSSupportCase nsgSupportCase = new NGSSupportCase();
		nsgSupportCase.setHostName("vmwsoaapp13-dev.corp.netapp.com:9102");
		nsgSupportCase.setServiceName("NGS_SupportCase");
		nsgSupportCase.setQueryServiceName("GetSerailizedProduct");
		nsgSupportCase.setLoginUserId("1220783");
		nsgSupportCase.setLoginUserName("00BEA9EB4B1");
		nsgSupportCase.setStatus("E0001");
		nsgSupportCase.setProductId("14228894");		
		List<String> customerIdList = new ArrayList<String>();
		customerIdList.add("1003013");
		customerIdList.add("1008857");
		customerIdList.add("1029200");
		customerIdList.add("1340278");
		customerIdList.add("1464067");
		customerIdList.add("2058636");		
		nsgSupportCase.setCustomerIdList(customerIdList);

		//Print URL
		System.out.println(nsgSupportCase.buildUrl());
		
		//Create XML HTTP Client
		XmlHttpClient xmlHttpClient = new XmlHttpClient(nsgSupportCase, "GET");
		//Time out defaults to 5s, however it can be overridden
		xmlHttpClient.setTimeOut(10000);
		InputStream is = xmlHttpClient.getDataFromWire();
		
		
		//Convert the InputStream to String and dump it on the console
		ParseToString pToS = new ParseToString();
		
		System.out.println(pToS.parseData(is));
		
		
		
		
		
		
	}

}
