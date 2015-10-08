package org.hbs.java.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ComplexDataTypesPractice {
	
	public static String[] vehicles = {
		"ambulance" , "helicopter" , "lifeboat"
	};
	
	
	public static String[][] drivers ={
		{"Fred","Sue","Pete"},
		{"Sue", "Rich","Bob","Fred"},
		{"Pete","Mary","Bob","Bob"}
		
	};

	public static void main(String args[]) {
		Map<String, Set<String>> personnel = new HashMap<String, Set<String>>();

		for (int i = 0; i < vehicles.length; i++) {
			String vehicle = vehicles[i];
			String[] driversList = drivers[i];

			Set<String> driverSet = new LinkedHashSet<String>(
					Arrays.asList(driversList));
			
			personnel.put(vehicle, driverSet);

		}
		
		System.out.println(personnel);
		for (String string : personnel.keySet()) {
			System.out.println("Vehicle: "+string);
			System.out.println("Drivers: "+personnel.get(string));
		}
		
		
		
	}
}
