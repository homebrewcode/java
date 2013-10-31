package com.netapp.framework.parser;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <p>
 *  SimpleSaxHandler is one of the implementations of DefaultHandler which 
 *  is used to handle the XML stream of data to convert it into a 
 *  Map<XMLTag,XMLTagValue>
 * </p>
 *  @author <a href="mailto:hshashid@netapp.com">hshashid</a>
 *
 */
public class SimpleSaxHandler extends DefaultHandler{

	private static final String DELIM = ";";
	private List<String> requiredTagList;
	private boolean appendRequired;
	private Map<String,String> parsedData;
	private String currentElement;
	private boolean filterData;
	private Stack<String> xmlObjectTree;

	public SimpleSaxHandler(){
		super();
		//If nothing is set then everything in the XML is loaded to the parsedData
		//and the data is not appended
		filterData = false;
		parsedData = new LinkedHashMap<String, String>();
		xmlObjectTree = new Stack<String>();
	}


	public SimpleSaxHandler(List<String> requiredTagList, boolean appendRequired){
		this.requiredTagList = requiredTagList;
		this.appendRequired = appendRequired;

		if(requiredTagList==null || requiredTagList.isEmpty()){
			filterData = false;
		}else{
			filterData = true;
		}

		parsedData = new LinkedHashMap<String, String>();
		xmlObjectTree = new Stack<String>();		
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		xmlObjectTree.push(qName);
		resetCurrentElement();
	}

	@Override
	public void endElement(String uri, String localName, String qName)
	throws SAXException {
		
		//If data needs filtering and the element is not present in the requiredList
		if(filterData && !containsElementInFilterList(qName)){
			return;
		}else{
			//For all other cases
			//Check for appending
			if(parsedData.containsKey(qName) && appendRequired){
				parsedData.put(qName, getAppendData(parsedData.get(qName),currentElement));
			}else{
				parsedData.put(qName, currentElement);
			}
		}

	}

	@Override
	public void characters(char[] inputCharacterBuffer, int start, int length)
	throws SAXException {
		this.currentElement=this.currentElement+new String(inputCharacterBuffer,start,length);
		xmlObjectTree.pop();
	}

	private boolean containsElementInFilterList(String localName) {
		return requiredTagList.contains(localName);
	}

	private String getAppendData(String oldData, String dataToBeAppended){
		return oldData+DELIM+dataToBeAppended;		
	}

	private void resetCurrentElement() {
		this.currentElement="";		
	}

	public Map<String,String> getParsedData(){
		return parsedData;
	}


}
