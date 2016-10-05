/*
 * Source file: ArraySortedSet.java
 * This class implements the Sorted Set interface using an array.
 */

package edu.uprb.collection;

import java.util.Iterator;


// El Comparable implementa el metodo CompareTo.
public class ArraySortedSet<E extends Comparable<E>> implements SortedSet<E> {

	// The contents of this sorted set as an array.
	private E[] data;

	// The number of elements in this sorted set.
	private int size;

	// Creates an empty sorted set using the given initial capacity.
	@SuppressWarnings("unchecked")
	public ArraySortedSet(int initCapacity) {
		// hya que no se puede 
		data = (E[])new Comparable[initCapacity];
		// size se inicializa en 0 
	}

	// Creates an empty sorted set using the default initial capacity.
	public ArraySortedSet() {
		this(10);
	}

	// Adds the given element to this sorted set.
	public boolean add(E elem)  {
		int curr = findIndex(elem);
		
		if (curr >= 0)
			return false;  // failure not found 
		 ensureCapacity();
		 curr = -(curr + 1);
		 
		 System.out.println(curr + " curr");
		 for (int dest = size; dest > curr; dest--){
			 data[dest] = data[dest -1];
			 System.out.println("FIRST ");
		 }
		 data[curr] = elem;
		 size ++;
		 System.out.println(size);
		 return true;                        // succes 
		
		 
		 
		 
	}

	// Ensures that the internal array has the capacity for adding
	// new elements to the set.
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if (size == data.length){
			E[]  temp = (E[]) new Comparable[2 * size];
			for (int curr = 0; curr < data.length; curr++ ){
				temp[curr] = data[curr];
			}
			data = temp;
		}
		
	}

	// Removes the given element from this sorted list.
	public boolean remove(E elem) {
		int curr = findIndex(elem);

		if (curr < 0)
			return false; // failure Not Found
		
		size --;
		for ( int dest = curr; dest < size; dest ++){
			data[dest] = data[dest + 1];
		}
		data [size] = null;
		return true;  // succes 
	}

	// Returns true if this sorted set contains the given element.
	public boolean contains(E elem) {
		return findIndex(elem) >=0;
	}

	// Returns the index of an element in this sorted set. 
	// If not found, returns -(insertion_point + 1).
	// a el cliente no le importa si el tiene acceso a los indices pero los metodos publicos si necesitan saber 
	// el indice para anadir,rexcorrer,remover etc pero el cliente no tiene acceso al indice,pq el size es privado
	private int findIndex(E elem) {
		int low = 0;
		int high = size - 1;

		while ( low < high){
			int middle = (low + high) / 2;

			// se tiene que usar el compare to pq el tipo de dato no necesariasmente tiene que ser primitvo (numero)
			// para eso se extieneded el Comparable
			if ( elem.compareTo(data[middle]) < 0){
				high = middle -1 ;
			}
			if ( elem.compareTo(data[middle]) > 0){
				low = middle + 1;				
			}
			else 
				return middle;
		}
		// el Low dice donde lo insertes 
		return -(low + 1);
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
			System.out.println(size());
			if (curr < size - 1)
				str.append(", ");
		}
		return str.append("]").toString();
	}

	// Returns an iterator over the elements in this sorted set.
	// 
	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator();
	}

	//This class implements the Iterator Interface
	private class ArrayIterator implements Iterator<E>{

		private int curr = 0;

		@Override
		public boolean hasNext() {
			return curr < size;

		}

		@Override
		public E next() {
			E elem = data[curr];
			curr ++;
			return elem;


		}


	}
















}