package com.netapp.supportsite.parser;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.netapp.framework.parser.SimpleSaxHandler;


public class NgsSupportParser implements com.netapp.framework.parser.SAXParser<Map<String,String>>{
	private SAXParser saxParser;

	public NgsSupportParser() throws ParserConfigurationException, SAXException{		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		saxParser = factory.newSAXParser();
	}

	public Map<String, String> parseData(InputStream is,
			List<String> filterList, boolean appendRequired) throws Exception {
		try{
			SimpleSaxHandler saxHandler = new SimpleSaxHandler(filterList,appendRequired);
			saxParser.parse(is, saxHandler);
			return saxHandler.getParsedData();
		}finally{
			if(is!=null){
				is.close();
			}
		}
	}

}
