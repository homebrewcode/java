package org.hbs.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class StringLenghtComparator implements Comparator<String>{
	public int compare(String s1, String s2) {
		
		if(s1.length() == s2.length()){
			return 0;
		}else if(s1.length() > s2.length()){
			return 1;
		}else {
			return -1;
		}
		
	}
}

class AlphabeticalComparator implements Comparator<String>{
	public int compare(String s1, String s2) {
		return s1.compareTo(s2);
	}
}


class ReverseAlphabeticalComparator implements Comparator<String>{
	public int compare(String s1, String s2) {
		return -(s1.compareTo(s2));
	}
}


/**
 * Driver code
 * 
 *
 */
public class ComparatorPractice {

	public static void main(String[] args) {

		//////////////////////// Sorting strings ////////////////////////
		List<String> animals = new ArrayList<String>();

		animals.add("tiger");
		animals.add("lion");
		animals.add("cat");
		animals.add("snake");
		animals.add("mongoose");
		animals.add("elephant");
		
		//Collections.sort(animals, new StringLenghtComparator());
		//Collections.sort(animals, new AlphabeticalComparator());
		Collections.sort(animals, new ReverseAlphabeticalComparator());
		
		for (String string : animals) {
			System.out.println(string);
		}
		
		System.out.println("-------------------");
		////////////////////////Sorting numbers ////////////////////////
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(40);
		numbers.add(3);
		numbers.add(0);
		numbers.add(7);
		numbers.add(9);
		numbers.add(8);
		
		Collections.sort(numbers, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return -o1.compareTo(o2);
			}
		});
		
		for (Integer integer : numbers) {
			System.out.println(integer);
		}
		
		
		////////////////////////Sorting objects ////////////////////////
		System.out.println("-------------------");
		List<Person> people = new ArrayList<Person>();
		people.add(new Person(1, "Joe"));
		people.add(new Person(2, "Sue"));
		people.add(new Person(4, "Clare"));
		people.add(new Person(3, "Bob"));
		
		Collections.sort(people, new Comparator<Person>(){

			public int compare(Person p1, Person p2) {
				/*
				if(p1.getId() > p2.getId()){
					return 1;
					
				}else if(p1.getId() < p2.getId()){
					return -1;
				}
				return 0;
				*/
				return p1.getName().compareTo(p2.getName());
				
			}
			
		});
		
		for (Person person : people) {
			System.out.println(person);
		}

	}

}

class Person{
	private int id;
	private String name;
	
	public Person(int id, String name){
		this.id = id;
		this.name = name;
	
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
}