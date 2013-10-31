package com.netapp.supportsite.url.builder;

public class InsufficiantParametersException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//TODO: Implement the exception	& move to exception package
	public InsufficiantParametersException(NGSSupportCase ngsSupportCaseUrlBuilder) {
		super(ngsSupportCaseUrlBuilder.toString()+": mandatory parameters cannot be null!!");
	}

	
}
