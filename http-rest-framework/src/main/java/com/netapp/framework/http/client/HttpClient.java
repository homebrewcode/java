package com.netapp.framework.http.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.netapp.framework.url.builder.UrlBuilder;

public abstract class HttpClient {

	private static final String EXCEPTION_MESSAGE="UrlBuilder cannot be null!";
	private UrlBuilder urlBuilder;
	
	public HttpClient(UrlBuilder urlBuilder){
		this.urlBuilder = urlBuilder;
	}
	
	private int timeOut=5000;

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public InputStream getDataFromWire() throws IOException{
		validateUrlBuilder(urlBuilder);
		String urlString = sanitizeURL(urlBuilder.buildUrl());

		if(urlString==null){
			return null;
		}

		URL url = new URL(urlBuilder.buildUrl());
		HttpURLConnection conn;
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(requestMethod());
		conn.setReadTimeout(getTimeOut());

		configureConnection(conn);
		
		if(conn.getResponseCode()!=200){
			throw new RuntimeException("Failed: HTTP error code : "+ conn.getResponseMessage());
		}

		return sanitizeStream(conn.getInputStream());
	}

	private void validateUrlBuilder(UrlBuilder urlBuilder) throws IOException {
		if(urlBuilder==null){
			throw new IOException(EXCEPTION_MESSAGE);
		}
	}

	protected abstract String requestMethod();	
	protected abstract String sanitizeURL(String url);
	protected abstract InputStream sanitizeStream(InputStream in) throws IOException;
	protected abstract void configureConnection(HttpURLConnection conn);

}

