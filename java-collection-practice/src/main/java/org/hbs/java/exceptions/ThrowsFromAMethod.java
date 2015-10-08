package org.hbs.java.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsFromAMethod {

	public static void main(String[] args) {
		try {
			openFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void openFile() throws IOException {
		File file = new File("test.txt");
		FileReader fr = new FileReader(file);
		
		fr.close();
	}

}
