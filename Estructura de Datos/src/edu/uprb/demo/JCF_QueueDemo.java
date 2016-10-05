/*
 * JCF_QueueDemo.java
 * This application demonstrates the Queue interface from the Java
 * Collections Framework.  This interface is implemented by the
 * LinkedList class
 */

package edu.uprb.demo;

import java.util.LinkedList;								

import java.util.NoSuchElementException;
import java.util.Queue;

public class JCF_QueueDemo {

	// Starts the execution of this application.
	public static void main(String[] args) {
		System.out.println("Creating an empty queue...");
		Queue<String> que = new LinkedList<>();
		System.out.println("type: " + que.getClass().getSimpleName());
		printQueue(que);

		System.out.println("Adding some items...");
		que.add("one");
		que.add("two");
		que.add("three");
		que.add("four");
		que.add("five");
		que.add("six");
		que.add("seven");
		que.add("eight");
		que.add("nine");
		que.add("ten");
		printQueue(que);
		
		System.out.println("Viewing the front item...");
		System.out.println("front item: " + que.peek());
		System.out.println();

		System.out.println("Removing the front item...");
		String item = que.remove();
		System.out.println("removed item: " + item);
		printQueue(que);

		System.out.println("Clearing the queue...");
		while (! que.isEmpty())
			que.remove();
		printQueue(que);

		System.out.println("Removing the front item from an empty queue...");
		try {
			item = que.remove();
			System.out.println("removed item: " + item);
			printQueue(que);
		}
		catch (NoSuchElementException ex) {
			System.out.println("cannot remove: empty queue");
			System.out.println();
		}

		System.out.println("End of tests.");
		System.exit(0);
	}

	// Prints the state of a queue.
	private static void printQueue(Queue<String> que) {
		System.out.println("elements: " + que);
		System.out.println("empty: " + que.isEmpty());
		System.out.println("size: " + que.size());
		System.out.println();
	}

}