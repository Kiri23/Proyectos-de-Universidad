/*
 * JCF_StackDemo.java
 * This application demonstrates the Stack class from the Java
 * Collections Framework.
 */

package edu.uprb.demo;

import java.util.Stack;

import java.util.EmptyStackException;

public class JCF_StackDemo {

	// Starts the execution of this application.
	public static void main(String[] args) {
		System.out.println("Creating an empty stack...");
		Stack<String> stk = new Stack<>();
		System.out.println("type: " + stk.getClass().getSimpleName());
		printStack(stk);

		System.out.println("Adding some items...");
		stk.push("one");
		stk.push("two");
		stk.push("three");
		stk.push("four");
		stk.push("five");
		stk.push("six");
		stk.push("seven");
		stk.push("eight");
		stk.push("nine");
		stk.push("ten");
		printStack(stk);
		
		System.out.println("Viewing the top item...");
		System.out.println("top item: " + stk.peek());
		System.out.println();

		System.out.println("Removing the top item...");
		String item = stk.pop();
		System.out.println("removed item: " + item);
		printStack(stk);

		System.out.println("Clearing the stack...");
		while (! stk.isEmpty())
			stk.pop();
		printStack(stk);

		System.out.println("Removing the top item from an empty stack...");
		try {
			item = stk.pop();
			System.out.println("removed item: " + item);
			printStack(stk);
		}
		catch (EmptyStackException ex) {
			System.out.println("cannot remove: empty stack");
			System.out.println();
		}

		System.out.println("End of tests.");
		System.exit(0);
	}

	// Prints the state of a stack.
	private static void printStack(Stack<String> stk) {
		System.out.println("elements: " + stk);
		System.out.println("empty: " + stk.isEmpty());
		System.out.println("size: " + stk.size());
		System.out.println();
	}

}