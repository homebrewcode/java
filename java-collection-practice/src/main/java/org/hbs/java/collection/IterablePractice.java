package org.hbs.java.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class IterablePractice {

	/**
	 * Which collection to use given a scenario
	 * 
	 * 1. Do you want a list, set or a map
	 * List - list of objects
	 * Set  - list of non duplicate objects
	 * Map	- key - value
	 * 
	 * List
	 * Store lists of objects
	 * Duplicates are allowed
	 * Objects remain in order
	 * Elements are indexed using an integer
	 * cf. shopping list
	 * Checking for particular item in list is slow
	 * Looking an item up by index is fast
	 * Iterating through the list is fast
	 * Note: you can sort lists if you want to
	 * 
	 * Set
	 * Stores unique values
	 * Great for removing duplicates
	 * Not indexed, unline liests
	 * Very fast to check if a particular object exists
	 * IF you want to use your own object, you must implement hashCode() & equals()
	 * 
	 * Map
	 * Key value pairs
	 * look up tables
	 * Retrieving a value by key is fast
	 * Iterating over maps is very slow
	 * Maps not really optimised for iteration
	 * If you want to use your own objects as key, you must implement hashCode() & equals()
	 *  
	 * 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		/////////////////// List ///////////////////
		//If you only add or remove items at hte end of list, use ArrayList
		
		List<String> arrayList = new ArrayList<String>();
		//If you want to add or remove anywhere else then use LinkedList
		List<String> linkedList = new LinkedList<String>();
		
		/////////////////// Set ///////////////////
		//If you want to use your own objects in any set then they must implement hashCode() & equals()
		
		//Order is unimportant and OK if it changes?
		//HashSet is not ordered
		Set<String> hashSet =new HashSet<String>();
		//Sorted in natual order -- Custom objects must implement Comparable interface
		//Tree structure to sort the objects
		Set<String> treeSet = new TreeSet<String>();
		//Sorted in insertion order
		Set<String> linkedHashSet = new LinkedHashSet<String>();
		
		/////////////////// Map ///////////////////
		//Not ordered and order may change
		Map<String,Integer> hashMap = new HashMap<String, Integer>();
		//Keys are sorted in natural order
		Map<String,Integer> treeMap = new TreeMap<String, Integer>();
		//Keys remain in the insertion order
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		
		//There are also the SortedSet & SortedMap interfaces???
		
	}
}
