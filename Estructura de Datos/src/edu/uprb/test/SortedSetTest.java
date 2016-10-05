/*
 * SortedSetTest.java
 * This is a test application for sorted sets.
 */

package edu.uprb.test;

import edu.uprb.collection.*;
import edu.uprb.datastructure.TreeSortedSet;

public class SortedSetTest {

	// This method is the application's entry point.
	public static void main(String[] args) {
		System.out.println("Creating an empty set...");
		SortedSet<String> set = new LinkedSortedSet<>();
		System.out.println("type: " + set.getClass().getSimpleName());
		printSortedSet(set);

		System.out.println("Adding some items...");
		set.add("motorcycle");
		set.add("house");
		set.add("dog");
		set.add("car");
		set.add("man");
		set.add("woman");
		set.add("tree");
		set.add("bicycle");
		set.add("snake");
		set.add("dolphin");
		printSortedSet(set);

		System.out.println("The items, one per line and uppercase...");
		for (String elem : set)
			System.out.println(elem.toUpperCase());
		System.out.println();

		System.out.println("Searching for motorcycle...");
		if (set.contains("motorcycle"))
			System.out.println("motorcycle found");
		else
			System.out.println("motorcycle not found");
		System.out.println();

		System.out.println("Adding another motorcycle...");
		boolean added = set.add("motorcycle");

		if (added)
			System.out.println("motorcycle added");
		else
			System.out.println("cannot add: duplicate item");
		System.out.println();

		System.out.println("Removing motorcycle fron the set...");
		set.remove("motorcycle");
		printSortedSet(set);
		
		
		
		System.out.println("Clearing the set...");
		set.clear();
		printSortedSet(set);

		System.out.println("Removing motorcycle from an empty set...");
		boolean removed = set.remove("motorcycle");

		if (removed)
			System.out.println("motorcycle removed");
		else
			System.out.println("cannot remove: motorcycle not found");
	}

	// Prints the state of a sorted set.
	private static void printSortedSet(SortedSet<String> set) {
		System.out.println("elements: " + set);
		System.out.println("empty: " + set.isEmpty());
		System.out.println("size: " + set.size());
		System.out.println();
	}

}