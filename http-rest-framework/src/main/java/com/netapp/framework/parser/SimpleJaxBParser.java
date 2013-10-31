package com.netapp.framework.parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.IOUtils;

/**
 * SimpleJaxBParser converts stream of XML data to a java object
 * using DOM parser <br/>
 * <br/>
 * Defaults<br/>
 * Input Stream Encoding 	: UTF-8 <br/>
 * 
 * @author <a href="mailto:hshashid@netapp.com">hshashid</a>
 *
 * @param <K> The type of java object that is expected from the Parser
 */
public abstract class SimpleJaxBParser<K> implements Parser<K>{
	private static final String DEFAULT_ENCODING ="UTF-8";
	private Unmarshaller jaxbUnmarshaller;
	private static final String INPUT_STREAM_NULL = "InputStream cannot be NULL!";
	private static final String INPUT_STREAM_EMPTY = "InputStream cannot be empty!";

	public SimpleJaxBParser(Class<K> classesToBeBound) throws JAXBException {		
		JAXBContext jaxbContext = JAXBContext.newInstance(classesToBeBound);		 
		jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	}

	
	/**
	 * Method to parse data from the XML stream to java object using DOM Parser.<br/>
	 * Uses UTF-8 as the default input stream
	 * 
	 * @param is XML steam of data 
	 * @return java object created from the XML input
	 * @throws IOException
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public K parseData(InputStream is) throws IOException, JAXBException {
		try{
			validateStream(is);
			is = interceptor(is,DEFAULT_ENCODING);
			return (K) jaxbUnmarshaller.unmarshal(is);
		}finally{
			if(is!=null){
				is.close();
			}
		}
	}

	/**
	 * 
	 * @param is XML steam of data
	 * @param encoding Character encoding of the input stream expected
	 * @return java object created from the XML input
	 * @throws IOException
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public K parseData(InputStream is, String encoding) throws IOException, JAXBException {
		try{
			validateStream(is);
			is = interceptor(is, encoding);
			return (K) jaxbUnmarshaller.unmarshal(is);
		}finally{
			if(is!=null){
				is.close();
			}
		}
	}

	/**
	 * Method to intercept the InputStream and do clean up of junk characters before parsing it using DOM parser
	 *  
	 * @param is XML steam of data 
	 * @param encoding Character encoding of the input stream expected
	 * @return Filtered InputStream
	 * @throws IOException
	 */
	private InputStream interceptor(InputStream is,String encoding) throws IOException {

		//TODO: Needs improvisation! This will blow up memory since we are storing it in a string!!
		//Implement an algorithm to read it line by line so it does not blow up the memory
		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer, encoding);

		//Filter out the unwanted tags and create a well-formed XML
		String str=filterStream(writer.toString());		

		//Write a string back to the stream
		InputStream modIs = new ByteArrayInputStream(str.getBytes());

		return modIs;
	}

	/**
	 * Method to pre-validate the stream before consuming the data 
	 * 
	 * @param is InputStream of data fed to the parser
	 * @throws IOException
	 */
	private void validateStream(InputStream is) throws IOException{
		if(is==null){
			throw new IOException(INPUT_STREAM_NULL);
		}
		if(is.available()==0){
			throw new IOException(INPUT_STREAM_EMPTY);
		}
	}

	/**
	 * Method used by interceptor() to ease the process of filtering out unwanted junk characters
	 * 
	 * @param string Input raw string from the stream
	 * @return Filtered string
	 */
	protected abstract String filterStream(String string);


}
