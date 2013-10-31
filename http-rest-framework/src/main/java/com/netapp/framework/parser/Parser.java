package com.netapp.framework.parser;

import java.io.InputStream;

/**
 * Parser converts a raw stream of input data to a java object
 * 
 * @author <a href="mailto:hshashid@netapp.com">hshashid</a>
 * 
 * @param <K> The type of java object that is expected from the Parser
 */
public interface Parser<K> {
	
	/**
	 * Method to parse data from the raw stream to java object
	 *  
	 * @param is Raw data stream
	 * @return Parsed data in form of a java object <K>
	 * @throws Exception
	 */
	public K parseData(InputStream is) throws Exception;
}
