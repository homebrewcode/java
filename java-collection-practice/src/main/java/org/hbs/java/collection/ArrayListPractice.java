package org.hbs.java.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice {

	/**
	 * Notes
	 * 
	 * 1. ArrayList is light weight since the elements are indexed and it
	 * implements an array internally 
	 * 2. Implements an array that is expandable
	 * 3. Remove from the end of the list is fast 
	 * 4. Remove from the front of
	 * the list is really really slow since it has to copy the rest of the
	 * elements to the front of the array
	 *
	 * If you want to use the elements at random use LinkedList
	 * 
	 */

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// Adding
		numbers.add(10);
		numbers.add(100);
		numbers.add(40);
		numbers.add(500);

		// Retrieving
		System.out.println(numbers.get(0));

		// Iterating using index
		System.out.println("\nIteration 1");
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}

		// Removing items (careful)
		// This is pretty fast since it is @ the end of the array
		// and also its just decrementing the index of the array
		numbers.remove(numbers.size() - 1);

		// This is VERY slow
		// First item since it has to copy all the preceding items to the front
		// of the array
		numbers.remove(0);

		// Iterating using iterator
		System.out.println("\nIteration 2");
		for (Integer integer : numbers) {
			System.out.println(integer);
		}

		// List interface...
		List<String> values = new ArrayList<String>();
		values.add("Hello");
		System.out.println(values);

	}

}
