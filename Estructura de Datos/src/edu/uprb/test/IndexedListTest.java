/*
 * IndexedListTest.java

 * This source file contains a class that tests the IndexedList interface
 * and its implementations.
 */

package edu.uprb.test;

import edu.uprb.collection.*;;

public class IndexedListTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		ArrayIndexedList<String> lst = new ArrayIndexedList<>();
		
		System.out.println("After creating a new list...");
		print(lst);
		System.out.println();
		
		lst.add("cat");
		lst.add("tree");
		lst.add("house");
		lst.add("woman");
		lst.add("man");
		lst.add("student");
		lst.add("marn");
		
		System.out.println("After adding some elements...");
		print(lst);
		System.out.println();
		
		lst.add(1, "dog");
		lst.add(3, "maen");
		lst.add(5, "boat");
		
		System.out.println("After inserting some elements at " +
				" indices 1, 3 and 5...");
		print(lst);
		System.out.println();
		
		System.out.println("The first element is " + lst.get(0));
		System.out.println("The last element is " + lst.get(lst.size() - 1));
		System.out.println("Does it contains a man? " + lst.contains("man"));
		//System.out.println("The index of cat is " + lst.indexOf("cat"));
		System.out.println();
		
		System.out.println("Traversing the list...");
		for (String element : lst)
			System.out.println(element);
		System.out.println();
		
		lst.set(5, "ship");
		
		System.out.println("After setting the element at 5 to a new value...");
		print(lst);
		System.out.println();
		
		System.out.println("Removing the first element: " + lst.remove(0));
		System.out.println("Removing the first occurrence of man...");
		lst.remove("man");
		
		System.out.println("After removing some elements...");
		print(lst);
		System.out.println();
		
		System.out.println("The first element is " + lst.get(0));
		System.out.println("The last element is " + lst.get(lst.size() - 1));
		System.out.println("Does it contains a manr? " + lst.contains("manr"));
		//System.out.println("The index of man is " + lst.indexOf("man"));
		System.out.println();
		
		lst.clear();
		System.out.println("After clearing the list...");
		print(lst);
		System.out.println();
//		
//		System.out.println("Trying to get the first element...");
//		try {
//			System.out.println("The first element is " + lst.get(0));
//		}
//		catch (IndexOutOfBoundsException ex) {
//			System.out.println("Error: " + ex.getMessage());
//		}
		
	}
	
	// Prints the data, size and empty status of this list.
	public static <E> void print(IndexedList<E> lst) {
		System.out.println("This is the list: " + lst);
		System.out.println("Its size is " + lst.size());
		System.out.println("Is it empty? " + lst.isEmpty());
	}

}