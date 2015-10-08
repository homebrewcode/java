package org.hbs.java.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {

	/**
	 * Maps in java
	 * 
	 * 1. Maps are key value pairs
	 * 2. hashCode() & equals() method need to be implemented if you have custom
	 * objects being used as a HashMap key
	 * 3. HashMap does not maintain order
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Integer, String> hashMap
			= new HashMap<Integer, String>();
		
		hashMap.put(5, "Five");
		hashMap.put(8, "Eight");
		hashMap.put(6, "Six");
		hashMap.put(4, "Four");
		hashMap.put(2, "Two");
		
		//hashMap.put(6, "Hello");
		String text = hashMap.get(6);
		System.out.println(text);
		
		for(Map.Entry<Integer, String> entry : hashMap.entrySet()){
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key+": "+value);
		}
		
	}
}
