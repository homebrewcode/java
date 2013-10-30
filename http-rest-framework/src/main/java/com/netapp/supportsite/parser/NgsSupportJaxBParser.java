package com.netapp.supportsite.parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;

import com.netapp.framework.parser.Parser;
import com.netapp.supportsite.domain.MTGetIObjDetails;


public class NgsSupportJaxBParser implements Parser<MTGetIObjDetails>{
	
	private static final String FILTER_REGEX="</?n0:MT_GetIObjDetails.*?\"?>";
	private static final String XML_REGEX="<\\?xml.*?\\?>\\n";
	private static final String PARENT_OPENING_TAG="<MT_GetIObjDetails>";
	private static final String PARENT_CLOSING_TAG="</MT_GetIObjDetails>";
	
	private Unmarshaller jaxbUnmarshaller;

	public NgsSupportJaxBParser() throws JAXBException {		
		JAXBContext jaxbContext = JAXBContext.newInstance(MTGetIObjDetails.class);		 
		jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	}

	public MTGetIObjDetails parseData(InputStream is) throws IOException, JAXBException {
		return (MTGetIObjDetails) jaxbUnmarshaller.unmarshal(interceptor(is));
	}

	private InputStream interceptor(InputStream is) throws IOException {

		//TODO: Needs improvisation! This will blow up memory since we are storing it in a string!!
		
		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer, "UTF-8");
		
		//Filter out the unwanted tags and create a well-formed XML
		String str=writer.toString();		
		str = writer.toString().replaceAll(XML_REGEX, "");
		str = PARENT_OPENING_TAG+str.replaceAll(FILTER_REGEX, "")+PARENT_CLOSING_TAG;
		
		//Write a string back to the stream
		InputStream modIs = new ByteArrayInputStream(str.getBytes());
		
		return modIs;
	}

	
}
