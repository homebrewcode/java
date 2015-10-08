package org.hbs.java.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorPractice {

	/**
	 * If you need to remove an element from the list while you are iterating
	 * then you need to use an iterator.
	 * 
	 * Foreach uses an iterator internally
	 * 
	 * ListIterator allows you to add items to the list while iterating through
	 * it
	 * 
	 * If your class implements iterable interface then you can use the for loop
	 * to iterate
	 * 
	 */
	public static void main(String[] args) {
		List<String> animals = new LinkedList<String>();

		animals.add("fox");
		animals.add("cat");
		animals.add("dog");
		animals.add("rabbit");

		Iterator<String> it = animals.iterator();
		while (it.hasNext()) {
			String value = it.next();
			System.out.println(value);

			if (value.equals("fox")) {
				it.remove();
			}

		}

		System.out.println("=================================");

		for (String string : animals) {
			System.out.println(string);
			animals.remove(2);
		}

	}

}
