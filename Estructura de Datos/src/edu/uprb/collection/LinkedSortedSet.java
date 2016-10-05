/*
 * LinkedSortedSet.java
 * This class represents an sorted set implemented using a linked list.
 */

package edu.uprb.collection;

import java.util.Iterator;

// comparable Interface que cada objeto E extienda el metodo compareTo() 
// luego la clase extiende la interfaz SortedSet<E>
public class LinkedSortedSet<E extends Comparable<E>> implements SortedSet<E> {

	// The reference to the the head node of this set.
	// Referencia al primer nodo
	private Node<E> head;

	// The number of elements in this set.
	// los numeros de nodo
	private int size;

	// Adds the given element to this sorted set.
	public boolean add(E elem) {
		Node<E> prev = null,curr = head;

		// se tiene que copiar el codigo pq java no puede devolver dos node 
		// encontrar donde lo voy a insertar 
		while(curr!=null && elem.compareTo(curr.data) > 0){
			prev = curr;
			curr = curr.next;

		} 

		//esto es para poder anadir es lo opuesto del metodo abajo
		// que cosas tengo que verificar para poder  anadir que curr no sea null 
		// y que el elemento no se pueda ser igual 
		if (curr != null && elem.equals(curr.data)){
			return false ;     // element found no se puede anadir pq no puede haber duplicado 
		}

		if ( curr == head ) // adding  first element 
			head = new Node<> (elem,head);
		else 
			prev.next = new Node<>(elem,curr); //adding iiner of last elements 
		// anadirse en donde le toca o al final 
		size ++;

		return true;
	}

	// Removes the given element from this sorted set.
	public boolean remove(E elem) {
		Node<E> prev = null,curr = head;

		// recorre la lista y // curr.data es menor que el elem para que sea > 0
		// esto es lo mismo busco el elemnto en la lista para saber cual voy a eliminar 
		// pero cuando salgas del null si curr==null o si el elemento npo es igual al ultimo elemento 
		// de la lista de nodo pues entonce no se encontro el elem para remove
		while(curr!=null && elem.compareTo(curr.data) > 0){
			//			System.out.println(elem + " "+ curr.data);
			prev = curr;
			curr = curr.next;

		}

		// si el curr es null// o que el elemento que quiero eliminar no esta en la lista
		if (curr == null || ! elem.equals(curr.data)){ 
			return false; // failire or elemento not found

		}
		// si llegue aqui entonces ya encontre el elemento que quiero borrar
		// ya si llegue aqui puedo eliminar pq en el while se puede anadir 
		// si ele eelmento buscado // pudiera salir del loop si curr es null o ele elemento no es 
		// igual a curr.data // si llegue abajo es pq curr ,no es null o el elemento es igual a curr.data
		// puede ser que remuevo al primero o que no remuevo al primero 
		if ( curr == head ) // removin first element 
			head = head.next; // si curr que es el ultimo nodo es igual head(primer nodo)//elimina el primer nodo y deja que el garbage collectro se lo lleve
		else 
			prev.next = curr.next; // prev contiene la direcion posterior al cual se quiere eliminar y curr contiene el dato que se quiere elimiar y dejo que le garbage collector se lleve a curr. por eso se pone curr.next
		size ++;

		return true;

	}

	// Returns true if this sorted set contains the given element.
	public boolean contains(E elem) {
		for (Node<E> curr = head; curr != null; curr = curr.next) { // recorre la lista verifica si ele elemnto es igual 
			if (curr.data.equals(elem))
				return true;
		}
		return false;
	}

	// Clears the contents of this sorted set.
	public void clear() {
		// con had == null elimina toda la lista pq el garbage collector se lleva los nodo referenciados a head
		head = null;
		size = 0;
	}

	// Returns true if this sorted set contains no elements.
	public boolean isEmpty() {
		return head == null;
	}

	// Returns the number of elements in this sorted set.
	public int size() {
		return size;
	}

	// Returns a string representation of this sorted set.
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for (Node<E> curr = head; curr != null; curr = curr.next) {
			str.append(curr.data);
			if (curr.next != null)
				str.append(", ");
		}
		return str.append("]").toString();
	}

	// Returns an iterator over the elements in this sorted set.
	@Override
	public Iterator<E> iterator() {
		return new LinkedIterator();
	}

	// This class Implemented the iterators Interface 
	// esta clase no es estatcica pq necesita acceso a los campos de la clase exterior 
	private class LinkedIterator implements Iterator<E>{

		private Node<E> curr = head;

		@Override
		public boolean hasNext() {
			return curr!=null;

		}

		@Override
		public E next() {
			E elem = curr.data;
			curr = curr.next;
			return elem;
		}


	}

	// This class defines a linked list node.
	//  Esta clase es statica pq no necesita accesar los campos de la clase exterior 
	// era para proteger la clase privada 
	private static class Node<T> {
		public T data;
		public Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

	}

}

