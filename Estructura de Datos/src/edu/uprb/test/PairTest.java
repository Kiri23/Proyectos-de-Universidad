/*
 * University of Puerto Rico at Bayamón
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2015
 * Prof. Antonio F. Huertas
 */

package edu.uprb.test;

import edu.uprb.collection.Pair;

/**
 * This class is a test application for generic pairs.
 * @author Antonio F. Huertas <antonio.huertas@upr.edu>
 * @version 1.0, 04/06/2015
 */
public class PairTest {
	
	/**
	 * Serves as the entry point for this application.
	 * @param args Not applicable: The command-line arguments
	 */
	public static void main(String[] args) {
		Pair<Integer> p1 = new Pair<>(10, 20);
		Pair<Integer> p2 = new Pair<>(6, 3);
		
		System.out.println("Two pairs have been created...");
		System.out.println("This is p1: " + p1);
		System.out.println("This is p2: " + p2);
		System.out.println("Are p1 and p2 equal? " + p1.equals(p2));
		System.out.println();
		
		p2.setFirst(10);
		p2.setSecond(20);
		
		System.out.println("Now, the components of p2 are " + 
				p2.getFirst() + " and " + p2.getSecond());
		System.out.println("This is p1: " + p1);
		System.out.println("This is p2: " + p2);
		System.out.println("Are p1 and p2 equal? " + p1.equals(p2));
		System.out.println();
		
		Pair<String> p3 = new Pair<>("one", "two");
		Pair<String> p4 = new Pair<>("four", "five");
		System.out.println("This is p3: " + p3);
		System.out.println("This is p4: " + p4);
		System.out.println("Are p3 and p2 equal? " + p3.equals(p4));
		System.out.println();
		
		System.out.println("End of tests.");
		System.exit(0);
	}

}