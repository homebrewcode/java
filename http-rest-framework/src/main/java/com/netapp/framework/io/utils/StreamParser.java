package com.netapp.framework.io.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * TBD
 * 
 * @author hshashid
 */
public class StreamParser {
	
	//Amazing!! This rocks :)

	public static void main(String args[]) throws IOException, InterruptedException{
		InputStream is = new FileInputStream(new File("src/test/resources/Input.xml"));
		int ch = 0;
		ByteArrayOutputStream lastLineStream = new ByteArrayOutputStream();

		while((ch = is.read())!=-1){
			lastLineStream.write(ch);
			if ((ch == '\n') || (ch == '\r')) {
				System.out.println(bytesStreamArrayToString(lastLineStream));
				lastLineStream.reset();
			}
			
		}	
		System.out.println(bytesStreamArrayToString(lastLineStream));
		
	}

	private static String bytesStreamArrayToString(
			ByteArrayOutputStream lastLineStream) {
		byte[] lastLineByteArray = lastLineStream.toByteArray();
		String lastLine = new String(lastLineByteArray);
		
		return lastLine;
	}
	
	
	
}
