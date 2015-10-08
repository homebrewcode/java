package org.hbs.java.exceptions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsFromMain {

	public static void main(String args[]) throws IOException {
		File file = new File("src/main/resources/test.txt");
		FileReader fr = new FileReader(file);
		
		fr.close();
		
		System.out.println("Finished!");
	}
}
