package edu.uprb.collection;

//	Queve una colecion lienal en el cual los ellementos se anaden y si se remueven por extremos 
// opuestos (Font,rear)
public interface Queve<E> {
	
	// Adds the given element at the rear of this queue.
	void enqueue(E elem);

	// Removes and returns the front element of this queue.
	// Throws EmptyQueueException if this queue is empty.
	E dequeue();

	// Returns the front element of this queue.
	// Throws EmptyQueueException if this queue is empty.
	E peek();

	// Returns true if this queue contains no elements.
	boolean isEmpty();

	// Returns the number of elements in this queue.
	int size();

	// Returns a string representation of this queue.
	String toString();



}
