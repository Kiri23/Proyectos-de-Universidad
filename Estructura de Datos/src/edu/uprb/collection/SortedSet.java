/*
 * SortedSet.java
 * A sorted set is a collection where elements are kept in order but
 * duplicate elements are not allowed.
 */

package edu.uprb.collection;

public interface SortedSet<E> extends Iterable<E> {
	
	// Adds the given element to this sorted set.
	// Returns true if the element was successfully added.
	public boolean add(E elem);
	
	// Removes the given element from this sorted list.
	// Returns true if the element was successfully removed.
	public boolean remove(E elem);
	
	// Returns true if this sorted set contains the given element.
	public boolean contains(E elem);
	
	// Clears the contents of this sorted set.
	public void clear();
	
	// Returns true if this sorted set contains no elements.
	public boolean isEmpty();
	
	// Returns the number of elements in this sorted set.
	public int size();
	
	// Returns a string representation of this sorted set.
	public String toString();
	
}
