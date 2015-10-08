package org.hbs.java.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListPractice {

	/**
	 * Notes
	 * 
	 * 1. If you want to add / remove the items at the end of the list use the
	 * ArrayList
	 * 2. If you want to add / remove items from any where in the list
	 * use LinkedList
	 * 
	 * ArrayLists manage arrays internally
	 * [0][1][2][3][4][5] ....
	 * 
	 * 
	 * LinkedList consists of elements where each element
	 * has a reference to the previous and next element
	 * [0] ->[1] ->[2] ->[3] ->[4] ....
	 * 
	 * 
	 * When to use ArrayList and when to use LinkedList
	 * 	Normally use ArrayList, but if there are random adds 
	 * & remove/deletes then use LinkedLists
	 * 
	 *	LinkedLists are slower for random access of elements
	 * 
	 */
	public static void main(String args[]) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();

		doTiminigs("ArrayList", arrayList);
		//arrayList = null;
		doTiminigs("LinkedList", linkedList);

	}

	private static void doTiminigs(String type, List<Integer> list) {
		// System.out.println("List type: " + type);

		// Populate the list
		for (int i = 0; i < 1E5; i++) {
			list.add(i);
		}

		long start = System.currentTimeMillis();

		// Add items at the end of list
		/*
		for (int i = 0; i < 1E5; i++) {
			list.add(i);
		}
		*/
		// Add items at the beginning of the list
		///*
		for (int i = 0; i < 1E5; i++) {
			list.add(0, i);
		}
		//*/

		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start) + " ms for " + type);

	}

}
