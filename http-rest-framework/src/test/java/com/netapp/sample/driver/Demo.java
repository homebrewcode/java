package com.netapp.sample.driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo {
	private static final String FILTER_REGEX="</?n0:MT_GetIObjDetails.*?\"?>";
	private static final String XML_REGEX="<\\?xml.*?\\?>";
	private static final String PARENT_OPENING_TAG="<MT_GetIObjDetails>";
	private static final String PARENT_CLOSING_TAG="</MT_GetIObjDetails>";
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		
		
		
		
		try {
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("Input.xml"));
 
			while ((sCurrentLine = br.readLine()) != null) {
				if(sCurrentLine.toString().matches(XML_REGEX)){
					sCurrentLine = sCurrentLine.replaceAll(XML_REGEX, "");
				}else if(sCurrentLine.toString().matches(FILTER_REGEX)){
					sCurrentLine = PARENT_OPENING_TAG+sCurrentLine.replaceAll(FILTER_REGEX, "")+PARENT_CLOSING_TAG;
				}
				
				System.out.println(sCurrentLine);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
