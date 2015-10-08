package org.hbs.java.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryCatchPractice {

	public static void main(String[] args) {
		File file = new File("src/main/resources/test.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		System.out.println("Finished!");

	}

}
