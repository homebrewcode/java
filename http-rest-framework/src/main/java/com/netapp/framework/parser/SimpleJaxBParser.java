package com.netapp.framework.parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;


public abstract class SimpleJaxBParser<K> implements Parser<K>{
	private static final String DEFAULT_ENCODING ="UTF-8";
	private Unmarshaller jaxbUnmarshaller;

	public SimpleJaxBParser(Class... classesToBeBound) throws JAXBException {		
		JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);		 
		jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	}

	public K parseData(InputStream is) throws IOException, JAXBException {
		is = interceptor(is,DEFAULT_ENCODING);
		return (K) jaxbUnmarshaller.unmarshal(is);
	}
	
	public K parseData(InputStream is, String encoding) throws IOException, JAXBException {
		is = interceptor(is, encoding);
		return (K) jaxbUnmarshaller.unmarshal(is);
	}

	//Method for filtering the stream
	private InputStream interceptor(InputStream is,String encoding) throws IOException {

		//TODO: Needs improvisation! This will blow up memory since we are storing it in a string!!
		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer, encoding);
		
		//Filter out the unwanted tags and create a well-formed XML
		String str=filterString(writer.toString());		
		
		//Write a string back to the stream
		InputStream modIs = new ByteArrayInputStream(str.getBytes());
		
		return modIs;
	}

	protected abstract String filterString(String string);
	
}
