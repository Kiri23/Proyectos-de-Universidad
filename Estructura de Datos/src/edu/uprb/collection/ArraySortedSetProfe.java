/*
 * Source file: ArraySortedSet.java
 * This class implements the Sorted Set interface using an array.
 */

package edu.uprb.collection;

import java.util.Iterator;

public class ArraySortedSetProfe<E extends Comparable<E>> implements SortedSet<E> {
	
	// The contents of this sorted set as an array.
	private E[] data;
	
	// The number of elements in this sorted set.
	private int size;
		
	// Creates an empty sorted set using the given initial capacity.
	@SuppressWarnings("unchecked")
	public ArraySortedSetProfe(int initCapacity) {
		data = (E[])new Comparable[initCapacity];
	}

	// Creates an empty sorted set using the default initial capacity.
	public ArraySortedSetProfe() {
		this(10);
	}
	
	// Adds the given element to this sorted set.
	public boolean add(E elem)  {				
		int curr = find(elem);
		if (curr >= 0)
			return false;  // failure: duplicate element so significa que el find dbe devolver siempre un numero negativo que significa que no se encontro
		
		ensureCapacity();
		// pq curr es negativo -(curr + 1) es la psocion donde le toca 
		curr = -(curr + 1);
		// empieza en el final y cambia el elemento a una posicion mas derecha 
		for (int dest = size; dest > curr; dest--)
			data[dest] = data[dest - 1];
		
		// este es el spot donde se quiere guardar el elemento
		data[curr] = elem;
		size++;
		return true;      // success
	}
	
	// Ensures that the internal array has the capacity for adding
	// new elements to the set.
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if (size == data.length) {
			E[] temp = (E[])new Comparable[size * 2];
			for (int curr = 0; curr < data.length; curr++)
				temp[curr] = data[curr];
			data = temp;
		}
	}
	
	// Removes the given element from this sorted list.
	public boolean remove(E elem) {
		int curr = find(elem);
		if (curr < 0)
			return false;    // failure: element not found
		
		size--;
		// menea los elementos + 1
		for (int dest = curr; dest < size; dest++)
			data[dest] = data[dest + 1];
				
		data[size] = null;
		return true;         // success
	}
	
	// Returns true if this sorted set contains the given element.
	public boolean contains(E elem) {
		return find(elem) >= 0;
	}
	
	// Returns the index of an element in this sorted set. 
	// If not found, returns -(insertion_point + 1).
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
	
	// Clears the contents of this sorted set.
	public void clear() {
		for (int curr = 0; curr < size; curr++)
			data[curr] = null;
		size = 0;
	}
	
	// Returns true if this sorted set contains no elements.
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Returns the number of elements in this sorted set.
	public int size() {
		return size;
	}
	
	// Returns a string representation of this sorted set.
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

	// Returns an iterator over the elements in this sorted set.
	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}
	
	// This class implements an iterator for an array.
	private class ArrayIterator implements Iterator<E> {
		
		// The index of the current element in this iteration.
		private int curr = 0;

		// Returns true if this iterator has more elements.
		@Override
		public boolean hasNext() {
			return curr < size;
		}

		// Returns the next element in this iteration.
		@Override
		public E next() {
			E elem = data[curr];
			curr++;
			return elem;
		}
	
	}
	
}