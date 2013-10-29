package com.netapp.supportsite.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

import com.netapp.framework.parser.Parser;

public class ParseToString implements Parser<String>{

	public String parseData(InputStream is) throws IOException {
		StringWriter writer = new StringWriter();
		IOUtils.copy(is, writer, "UTF-8");
		String str = writer.toString();
		return str;
	}

}
