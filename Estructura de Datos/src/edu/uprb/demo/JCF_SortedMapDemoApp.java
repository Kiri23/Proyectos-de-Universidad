/*
 * JCF_SortedMapDemoApp.java
 * This application demonstrates how to use sorted maps from the
 * Java Collections Framework (JCF).
 */

package edu.uprb.demo;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class JCF_SortedMapDemoApp {
	
	// This method is the application's entry point.
	public static void main(String[] args) {
		System.out.println("Creating an empty map...");
		SortedMap<String, String> map = new TreeMap<>();
		System.out.println("type: " + map.getClass().getSimpleName());
		printSortedMap(map);
		
		System.out.println("Adding some items...");
		map.put("dog", "motora");
		map.put("house", "casa");
		map.put("dog", "perro");
		map.put("car", "carro");
		map.put("man", "hombre");
		map.put("woman", "mujer");
		map.put("tree", "árbol");
		map.put("bicycle", "bicicleta");
		map.put("snake", "serpiente");
		map.put("dolphin", "delfín");
		printSortedMap(map);
		
		System.out.println("The items, one per line...");
		for (Map.Entry<String, String> entry : map.entrySet())
			System.out.println(entry.getKey() + "=>" + entry.getValue());
		
		System.out.println("Searching for dog...");
		if (map.containsKey("dog"))
			System.out.println("dog found");
		else
			System.out.println("dog not found");
		System.out.println();
		
		System.out.println("Changing the value for dog...");
		map.put("dog", "canino");
		
		System.out.println("Removing dog fron the set...");
		map.remove("dog");
		printSortedMap(map);
		
		System.out.println("Searching for dog...");
		if (map.containsKey("dog"))
			System.out.println("dog found");
		else
			System.out.println("dog not found");
		System.out.println();
		
		System.out.println("Clearing the set...");
		map.clear();
		printSortedMap(map);
		
		if (map.remove("dog") != null)
			System.out.println("dog removed");
		else
			System.out.println("cannot remove: dog not found");
	}
	
	// Prints the state of a sorted map.
	private static void printSortedMap(SortedMap<String, String> map) {
		System.out.println("elements: " + map);
		System.out.println("empty: " + map.isEmpty());
		System.out.println("size: " + map.size());
		System.out.println();
	}

}