package org.hbs.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

class NewPerson implements Comparable<NewPerson>  {
	private String name;

	public NewPerson(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	public int compareTo(NewPerson o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewPerson other = (NewPerson) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}



public class NaturalOrderingUsingComparatorPractice {

	public static void main(String[] args) {
		List<NewPerson> list = new ArrayList<NewPerson>();
		SortedSet<NewPerson> set = new TreeSet<NewPerson>();
		
		addElement(list);
		addElement(set);
		
		Collections.sort(list);
		
		showElement(list);
		System.out.println("----------");
		showElement(set);
	}
	
	
	private static void addElement(Collection<NewPerson> col){
		col.add(new NewPerson("Joe"));
		col.add(new NewPerson("Sue"));
		col.add(new NewPerson("Juliet"));
		col.add(new NewPerson("Clare"));
	}

	private static void showElement(Collection<NewPerson> col){
		for (NewPerson string : col) {
			System.out.println(string);
		}
	}

	
}
