package com.netapp.supportsite.parser;

import javax.xml.bind.JAXBException;

import com.netapp.framework.parser.SimpleJaxBParser;
import com.netapp.supportsite.domain.MTGetIObjDetails;


public class NgsSupportJaxBParser extends SimpleJaxBParser<MTGetIObjDetails>{
	
	private static final String FILTER_REGEX="</?n0:MT_GetIObjDetails.*?\"?>";
	private static final String XML_REGEX="<\\?xml.*?\\?>.*?";
	private static final String PARENT_OPENING_TAG="<MT_GetIObjDetails>";
	private static final String PARENT_CLOSING_TAG="</MT_GetIObjDetails>";
	private static final String NEW_LINE_CHARACTERS="[\\n\\r]";
	
	
	public NgsSupportJaxBParser() throws JAXBException {
		super(MTGetIObjDetails.class);
	}

	@Override
	protected String filterStream(String string) {
		//To flatten the string!!
		string = string.replaceAll(NEW_LINE_CHARACTERS, "");
		
		//To filter out the xml version and encoding tag!!
		string = string.replaceAll(XML_REGEX, "");
		
		//To clean up the MT_GetIObjDetails tag!!
		string = PARENT_OPENING_TAG+string.replaceAll(FILTER_REGEX, "")+PARENT_CLOSING_TAG;
		
		return string;
	}
	
	
}
