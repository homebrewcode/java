package com.netapp.framework.parser;

import java.io.InputStream;
import java.util.List;


public interface SAXParser<K>{	
	public K parseData(InputStream is, List<String> filterList, boolean appendRequired) throws Exception;
}
