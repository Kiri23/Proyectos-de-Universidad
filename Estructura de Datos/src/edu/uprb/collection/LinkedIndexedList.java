/*
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2015
 * Christian Nogueras Rosado
 */

package edu.uprb.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIndexedList<E extends Comparable<E>> implements IndexedList<E>{

	/**
	 *  The reference to the the head node of this set.
	 */
	private Node<E> head;

	/**
	 *  The number of elements in this set.
	 */
	private int size;

	/**
	 * Add one Element 
	 * @param element - the element to add 
	 * @author Christian Nogueras
	 */
	@Override
	public void add(E element) {
		if(head == null) {
			head = new Node<E>(element,null);
		}else {
			// si head no es nullo 
			Node<E> curr = head;
			while(curr.next != null){
				curr = curr.next; // entonces ponlo hasta el final 
			}
			// curr.next es null //entonces ahy pones el elemento 
			curr.next = new Node<E>(element,null);
		}
		size++;
	}
	
	/**
	 * Remove element
	 * @param element - the element to remove 
	 * @author Christian Nogueras
	 */
	@Override
	public void remove(E element) {
		Node<E> prev = null,curr = head;
		// y el elemento para comparar no sea igual sigue en la cola pq quiero buscar el elemento que quiera eliminar
		while(curr!=null && element.compareTo(curr.data) != 0){
			prev = curr;
			curr = curr.next;
		}
		// si no se encontro tira una excepcion 
		if (curr == null || ! element.equals(curr.data)){
			throw new NoSuchElementException("The element was not found");  // element not found 
		}
		// si se encontro al principio mueve a head a head.next 
		if ( curr == head ) // removing first element 
			head = head.next; 
		else 
			// si se encontro en el medio o otro lugar prev.next contiene el elemento previo al que se encontro .next es el lugar que se quiere eleiminar por 
			// eso se pone curr.next para que el gabage s=collector se lleve a curr.
			prev.next = curr.next; 
		// elimina el size 
		size --;

	}
	/** Add a element in the specified index
	 * @param index - the index on where to add the element 
	 * @param element - the element to add
	 * @author Christian Nogueras
	 */
	@Override
	public void add(int index, E element) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Error: Invalid index ");
		Node<E> curr = head;
		int position = 0;
		while (position < index){
			curr = curr.next;
			position ++;	
		}
		curr.data = element;
	}

	/**
	 * Remove a element in the specified index
	 * @param index - the index of the element to remove 
	 * @return the element remove
	 * @author Christian Nogueras
	 */
	@Override
	public E remove(int index) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Error: Invalid index ");
		Node<E> curr = head;
		int position = 0;
		while (position < index){
			curr = curr.next;
			position ++;	
		}

		head=curr.next;
		size--;
		return curr.data;
	}

	/** 
	 * set a element in the specified index 
	 * @param index - the index to set the element 
	 * @param element - the element to set 
	 * @author Christian Nogueras
	 */
	@Override
	public void set(int index, E element) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Error: Invalid index ");
		Node<E> curr = head;
		int position = 0;
		while(position < index){
			curr = curr.next;
			position ++;
		}
		curr.data = element;

	}

	/**
	 * Get a element in the specified index
	 * @param index - Index in the list to get the element
	 * @return The element in the index specified
	 * @author Christian Nogueras
	 */
	@Override
	public E get(int index) {
		if(index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Error: Invalid index ");
		Node<E> curr = head;
		int position = 0;
		while (position < index){
			curr = curr.next;
			position ++;	
		}
		return curr.data;
	}

	/** 
	 * Return the index of a element
	 * @param element - the element to be searched
	 * @return the index of the element 
	 * @author Christian Nogueras
	 */
	@Override
	public int indexOf(E element) {
		Node<E> curr = head;
		int position = 0;
		while(element.compareTo(curr.data) != 0 && position<=size ){
			curr = curr.next;
			position ++;
		}
		if ( position > size ){
			throw new NoSuchElementException("The element was not found");  // element found 
		}
		return position;

	}

	/** 
	 * search is the list contain a element 
	 * @param element - the element to be verify in the list
	 * @author Christian Nogueras
	 * @return a boolean expression {@code true} if the list contains 
	 * the element, {@code false} otherwise
	 */
	@Override
	public boolean contains(E element) {
		Node<E> curr = head;
		while(curr!=null && element.compareTo(curr.data) != 0){
			curr = curr.next;
		}
		if (curr == null || ! element.equals(curr.data)){
			return false;
		}

		return true;
	}
 
	/** 
	 * clear the list 
	 * @author Christian Nogueras
	 */
	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	/**
	 * return the size of the list
	 * @author Christian Nogueras
	 * @return the size of the list 
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * boolean expression to verify is the list is empty
	 * @author Christian Nogueras
	 * @return a boolean expression {@code true} if the list is empty 
	 * ,{@code false} otherwise
	 */
	@Override
	public boolean isEmpty() {
		return size==0;
	}

	/** 
	 * presentation of the list in String 
	 * @author Christian Nogueras
	 */
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder("[");
		for ( Node<E> curr = head; curr != null; curr = curr.next) { 
			str.append(curr.data); 
			if (curr.next !=null)
				str.append(",");
		}
		return str.append("]").toString(); 
	}

	 /**
	  * Returns an iterator over the elements in this sorted set.
	  * @author Christian Nogueras
	  */
	@Override
	public Iterator<E> iterator() {
		return new LinkedIterator();
	}

	// This class Implemented the iterators Interface 
	private class LinkedIterator implements Iterator<E>{

		private Node<E> curr = head;

		@Override
		public boolean hasNext() {
			return curr!=null ;
		}

		@Override
		public E next() {
			E elem = curr.data;
			curr = curr.next;

			return elem;
		}
	}

	/**
	 *  This class defines a linked list node.
	 * @author Christian Nogueras
	 * @param <T> - Type of the class
	 */
	private static class Node<T> {
		public T data;
		public Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

	}

}

