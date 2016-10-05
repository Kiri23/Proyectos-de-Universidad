package edu.uprb.collection;

public interface Stack<E> {

	// Adds the given element at the top of this stack.
	// anade un elemnto de tipo E
	void push(E elem);

	// Removes and returns the top element of this stack.
	// Throws EmptyStackException if this stack is empty.
	E pop();

	// Returns the top element of this stack.
	// Throws EmptyStackException if this stack is empty.
	E peek();

	// Returns true if this stack contains no elements.
	boolean isEmpty();

	// Returns the number of elements in this stack.
	int size();

	// Returns a string representation of this stack.
	String toString();


}
