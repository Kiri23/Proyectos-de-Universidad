/*
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2015
 * Christian Nogueras Rosado
 */
package edu.uprb.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * IndexedListTest.java
 * This source file contains a class that tests the IndexedList interface
 * and its implementations.
 */
public class ArrayIndexedList<E extends Comparable<E>> implements IndexedList<E> {


	/**
	 *  The contents of this sorted set as an array.
	 */
	private E[] data;

	/**
	 *  The number of elements in this sorted set.
	 */
	private int size;

	/**
	 *  Creates an empty sorted set using the given initial capacity.
	 * @param initCapacity- the init capacity of the array
	 */
	@SuppressWarnings("unchecked")
	public ArrayIndexedList(int initCapacity) {
		data = (E[])new Comparable[initCapacity];
	}

	/**
	 *  Creates an empty sorted set using the default initial capacity.
	 */
	public ArrayIndexedList() {
		this(10);
	}

	/**
	 *  Adds the given element to this sorted set.
	 *  @param elem - the element to be added 
	 */
	public void add(E elem)  {				
		int curr = find(elem);
		
		ensureCapacity();
		curr = -(curr + 1);
		//  start with the end and change the element to a position more to the right 
		for (int dest = size; dest > curr; dest--)
			data[dest] = data[dest - 1];

		// this is the spot where the element should be save 
		data[curr] = elem;
		size++;
	}
	/**
	 * Add a element in the specified index 
	 * @param index - the index in where to be added 
	 * @param element - the element to be added
	 */
	@Override
	public void add(int index, E element) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Error: Invalid index ");
		ensureCapacity();
		for (int dest = size; dest > index; dest--)
			data[dest] = data[dest - 1];

		// this is the spot where the element should be save 
		data[index] = element;
		size++;
		
		
	}

	/**
	 *  Ensures that the internal array has the capacity for adding new elements to the set.
	 */
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if (size == data.length) {
			E[] temp = (E[])new Comparable[size * 2];
			for (int curr = 0; curr < data.length; curr++)
				temp[curr] = data[curr];
			data = temp;
		}
	}

	/**
	 *  Removes the given element from this sorted list.
	 *  @param elem the element to be added
	 */
	public void remove(E elem) {
		int curr = find(elem);
		if (curr < 0)
			throw new NoSuchElementException("Error");    // failure: element not found

		size--;
		// move the element + 1
		for (int dest = curr; dest < size; dest++)
			data[dest] = data[dest + 1];

		data[size] = null;
	}

	/**
	 * remove a element in the given index
	 * @param index - the index where to be removed the element 
	 */
	@Override
	public E remove(int index) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Error: Invalid index ");
		
		E element = data[index];
		size--;
		// move the element + 1
		for (int dest = index; dest < size; dest++)
			data[dest] = data[dest + 1];
		
		data[size] = null;
		return element;
		
	}

	/**
	 *  Returns true if this sorted set contains the given element.
	 *  @param elem - the element to searched for 
	 *  @return  {@code true} if this sorted set contains the given element, {@code false} otherwise.
	 */
	public boolean contains(E elem) {
		return find(elem) >= 0;
	}

	/**
	 *  Returns the index of an element in this sorted set.  
	 *  If not found, returns -(insertion_point + 1).
	 * @param elem - the element to be searched 
	 * @return the index of an element in this sorted set.  
	 *  If not found, returns -(insertion_point + 1).
	 */
	private int find(E elem) {
		int low = 0;
		int high = size - 1;

		while (low <= high) {
			int middle = (low + high) / 2;

			if (elem.compareTo(data[middle]) < 0)
				high = middle - 1;
			else if (elem.compareTo(data[middle]) > 0)
				low = middle + 1;
			else
				return middle;   // found
		}
		return -(low + 1);       // not found
	}

	/** 
	 * Clears the contents of this sorted set.
	 */
	public void clear() {
		for (int curr = 0; curr < size; curr++)
			data[curr] = null;
		size = 0;
	}

	/**
	 * boolean expression to verify is the list is empty
	 * @return a boolean expression {@code true} if the list is empty 
	 * ,{@code false} otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 *  Returns the number of elements in this sorted set.
	 *  @return the number of element
	 */
	public int size() {
		return size;
	}



	/**
	 *  Replace the elements
	 *  @param index - the index where to be replaced 
	 *  @param element - the element for replace
	 */
	@Override
	public void set(int index, E element) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Error: Invalid index");
		ensureCapacity();
		data[index] = element ;		
	}



	/**
	 *  return the element specified in the index 
	 *  @param index - the index to get the element
	 *  @return the element of the sorted set 
	 */
	@Override
	public E get(int index) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Error: Invalid index");
		return data[index];
	}

    /**
     * return the index of the element 
     * @param element - the element to be searche in the sorted set 
     * @return the index of the element if it was found otherwise return -1
     */
	@Override
	public int indexOf(E element) {
		for (int curr = 0; curr <size ; curr++) {
			if ( element.compareTo(element) == 0)
				return curr;
		}
		return -1;
		
	}



	/**
	 *  Returns a string representation of this sorted set.
	 *  @return a string representation of this sorted set
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for (int curr = 0; curr < size; curr++) {
			str.append(data[curr]);
			if (curr < size - 1)
				str.append(", ");
		}
		return str.append("]").toString();
	}

	/**
	 *  Returns an iterator over the elements in this sorted set.
	 *  @return an iterator over the elements in this sorted set.
	 */
	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}

	/**
	 *  This class implements an iterator for an array.
	 *
	 */
	private class ArrayIterator implements Iterator<E> {

		/** 
		 * The index of the current element in this iteration.
		 */
		private int curr = 0;

		/**
		 *  Returns true if this iterator has more elements.
		 */
		@Override
		public boolean hasNext() {
			return curr < size;
		}

		/**
		 *  Returns the next element in this iteration.
		 */
		@Override
		public E next() {
			E elem = data[curr];
			curr++;
			return elem;
		}

	}



}
