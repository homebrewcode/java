package com.netapp.supportsite.http.client;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import com.netapp.framework.http.client.HttpClient;
import com.netapp.framework.url.builder.UrlBuilder;

public class XmlHttpClient extends HttpClient {
	
	private String requestType = "GET";
	
	public XmlHttpClient(UrlBuilder urlBuilder, String requestType){
		super(urlBuilder);
		this.requestType = requestType;
	}
	
	//Method to sanitize url
	@Override
	protected String sanitizeURL(String url) {
		if(url!=null){
			url = url.replace("|", ",");
			url = url.replaceAll(",", "%7C");
		}else{
			url = null;
		}
		return url;
	}

	//Method to sanitize unicode characters
	@Override
	protected InputStream sanitizeStream(InputStream in) throws IOException{
		BufferedInputStream bis = new BufferedInputStream(in);
		OutputStream output = new ByteArrayOutputStream();

		//Sanitize input stream
		int ch;
		while ((ch = bis.read()) != -1) {

			if ((ch == 0x9) || (ch == 0xA) || (ch == 0xD)
					|| ((ch >= 0x20) && (ch <= 0xD7FF))
					|| ((ch >= 0xE000) && (ch <= 0xFFFD))
					|| ((ch >= 0x10000) && (ch <= 0x10FFFF))) {

				output.write((int) ch);
			}

		}

		InputStream decodedInput = new ByteArrayInputStream(
				((ByteArrayOutputStream) output).toByteArray());

		return decodedInput;
	}


	@Override
	protected String requestMethod() {
		return this.requestType;
	}


	@Override
	protected void configureConnection(HttpURLConnection conn) {
		// TODO Auto-generated method stub		
	}
	

}
