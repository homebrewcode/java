package org.hbs.java.collection;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetPractice {

	public static void main(String[] args) {
		// HashSet does not retain order
		// Set<String> set1 = new HashSet<String>();

		// LinkedHashSet retains insertion order
		Set<String> set1 = new LinkedHashSet<String>();

		// TreeSet retains natural ordering
		// Set<String> set1 = new TreeSet<String>();

		if (set1.isEmpty()) {
			System.out.println("set is empty at the start of the program!");
		}

		set1.add("2");
		set1.add("1");
		set1.add("3");

		// Adding duplicate values
		set1.add("3");

		System.out.println(set1);

		// /////////////// Iteration
		for (String string : set1) {
			System.out.println(string);
		}

		///////////////// Does set contains a given item ??
		// Sets are optimized to find a particular item quickly
		if (set1.contains("two")) {
			System.out.println("Contains two");
		}

		if (set1.contains("2")) {
			System.out.println("Contains 2");
		}

	}

}
