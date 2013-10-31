package com.netapp.framework.parser;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * SAXParser converts stream of XML data to a java object 
 * using SAX Parser 
 * </p>
 * 
 * @author <a href="mailto:hshashid@netapp.com">hshashid</a>
 * 
 * @param <K> The type of java object that is expected from the Parser
 */
public interface SAXParser<K>{	
	
	/**
	 * Method to parse the XML stream of input data using SAX parser 
	 * 
	 * @param is InputStream of XML data
	 * @param filterList List of required fields/tags in the XML
	 * @param appendRequired The boolean value indicate if an XML field/tag 
	 * when repeated more than once should be captured or not
	 * @return java object created from the XML input
	 * @throws Exception
	 */
	public K parseData(InputStream is, List<String> filterList, boolean appendRequired) throws Exception;
}
