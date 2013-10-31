package com.netapp.sample.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.netapp.supportsite.parser.NgsSupportJaxBParser;


public class TestNgsSupportCaseJaxBParsingFileInput {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//Get XML from input source
		InputStream is = new FileInputStream(new File("src/test/resources/Input.xml"));		
	
		//JAXB Parsing
		NgsSupportJaxBParser jaxBParser = new NgsSupportJaxBParser();
		System.out.println(jaxBParser.parseData(is,"UTF-8"));
	}

}
