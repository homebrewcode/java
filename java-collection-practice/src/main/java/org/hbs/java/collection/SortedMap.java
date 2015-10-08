package org.hbs.java.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortedMap {

	/**
	 * Notes
	 * 
	 * 
	 */
	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();

		// Insert ordering
		Map<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();
		
		//Sorted naturally by key
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		

		testMap(hashMap);
		testMap(linkedHashMap);
		testMap(treeMap);
		
	}
	
	
	public static void testMap(Map<Integer, String> map){
		
		System.out.println(map.getClass());
		
		map.put(9, "Nine");
		map.put(0, "Zero");
		map.put(8, "Eight");
		map.put(3, "Three");
		map.put(7, "Seven");
		map.put(6, "Six");
		
		for (Integer key : map.keySet()) {
			System.out.println(key +":"+ map.get(key));
		}
		
		System.out.println("========================");
		
	}

}
