package edu.uprb.test;

import edu.uprb.collection.EmptyCollectionException;
import edu.uprb.collection.LinkQueve;
import edu.uprb.collection.Queve;

public class queveTest {
	// Starts the execution of this application.
	public static void main(String[] args) {
		
		System.out.println("Creating an empty queue...");
		Queve<String> que = new LinkQueve<>();
		System.out.println("type: " + que.getClass().getSimpleName());
		printQueue(que);

		System.out.println("Adding some items...");
		que.enqueue("one");
		que.enqueue("two");
		que.enqueue("three");
		que.enqueue("four");
		que.enqueue("five");
		que.enqueue("six");
		que.enqueue("seven");
		que.enqueue("eight");
		que.enqueue("nine");
		que.enqueue("ten");
		printQueue(que);

		System.out.println("Viewing the front item...");
		System.out.println("front item: " + que.peek());
		System.out.println();

		System.out.println("Removing the front item...");
		String item = que.dequeue();
		System.out.println("removed item: " + item);
		printQueue(que);

		System.out.println("Clearing the queue...");
		while (! que.isEmpty())
			que.dequeue();
		printQueue(que);

		System.out.println("Removing the front item from an empty queue...");
		try {
			item = que.dequeue();
			System.out.println("removed item: " + item);
			printQueue(que);
		}
		catch (EmptyCollectionException ex) {
			System.out.println("cannot remove: " + ex.getMessage());
			System.out.println();
		}

		System.out.println("End of tests.");
		System.exit(0);
	}

	// Prints the state of a queue.
	private static void printQueue(Queve<String> que) {
		System.out.println("elements: " + que);
		System.out.println("empty: " + que.isEmpty());
		System.out.println("size: " + que.size());
		System.out.println();
	}


}
