/*
===== * TreeSortedSet.java

 * This class represents an sorted set implemented using a binary search
 * tree (BST).
 */

package edu.uprb.datastructure;

import java.util.Iterator;


import edu.uprb.collection.LinkQueve;
import edu.uprb.collection.Queve;
import edu.uprb.collection.SortedSet;

public class TreeSortedSet<E extends Comparable<E>> implements SortedSet<E> {

	// The reference to the the root node of this sorted set.
	private Node<E> root;

	// The number of elements in this sorted set.
	private int size;

	// Adds the given element to this sorted set.
	public boolean add(E elem) {
		int oldSize = size;
		root = add(elem, root);
		// para saber si se pudo anadir o no esa es la condicion boleana 
		return oldSize != size;
	}

	private Node<E> add(E elem, Node<E> curr) {
		if (curr == null) {
			curr = new Node<E>(elem);
			size++;
		}
		else if (elem.equals(curr.data))
			;  // do nothing, duplicate
		// que elem sea menor que el curr.data 
		else if (elem.compareTo(curr.data) < 0)
			curr.left = add(elem, curr.left);
		else
			// el elemento es mayor se une a curr.right 
			curr.right = add(elem, curr.right);

		return curr;
	}

	// Removes the given element from this sorted set.
	public boolean remove(E element) {
		int oldSize = size;
		root = remove(element, root);
		return oldSize != size;
	}

	private Node<E> remove(E elem, Node<E> curr) {
		if (curr == null)
			;  // do nothing, not found
		else if (elem.equals(curr.data))
			curr = removeNode(curr);
		// si el elemento es menor 
		else if (elem.compareTo(curr.data) < 0)
			// curr.left = remove (elem,curr.left)
			curr.left = remove(elem, curr.left);
		else
			// curr.left = remove(elem,curr.right )
			curr.left = remove(elem, curr.right);

		return curr;
	}

	private Node<E> removeNode(Node<E> curr) {
		if (curr.left == null)  // si tengo hijo por la derecha 
			curr = curr.right;
		else if (curr.right == null)  // si tengo hijo por la derecha 
			curr = curr.left;
		else {
			Node<E> succ = getInorderSuccessor(curr);
			curr.data = succ.data;
			curr.right = remove(curr.data, curr.right);
			size--;
		}
		return curr;
	}

	private Node<E> getInorderSuccessor(Node<E> curr)  {
		Node<E> succ = curr.right;

		while (succ.left != null)  // el que esta mas a la izuierda 
			succ = succ.left;

		return succ;
	}

	// Returns true if this sorted set contains the given element.
	public boolean contains(E elem) {
		return contains(elem, root);
	}

	private boolean contains(E elem, Node<E> curr) {
		// si es curr es nullo devuelve false pq no hay ningua lista 
		if (curr == null)
			return false;
		// si los eleemntos son iguales con el que se esta comparando devuelve true 
		else if (elem.equals(curr.data))
			return true;
		// else si el elemento es menor verifica en el nodo de curr.left 
		else if (elem.compareTo(curr.data) < 0)
			return contains(elem, curr.left);
		else
			// verifica en el nodo del curr.right 
			return contains(elem, curr.right);
	}

	// Clears the contents of this sorted set.
	public void clear() {
		// el root es null 
		root = null;
		size = 0;
	}

	// Returns true if this sorted set contains no elements.
	// verificar si root es nullo 
	public boolean isEmpty() {
		return root == null;
	}

	// Returns the number of elements in this sorted set.
	//devuelve el size de la lista 
	public int size() {
		return size;
	}

	// Returns a string representation of this sorted set.
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		treeToString(root, str);
		return str.append("]").toString();		
	}

	private void treeToString(Node<E> curr, StringBuilder str) {
		if (curr != null) {
			treeToString(curr.left, str);
			if (curr.left != null) 
				str.append(", ");
			str.append(curr.data);
			if (curr.right != null)
				str.append(", ");
			treeToString(curr.right, str);
		}
	}

	// Returns an iterator over the elements in this sorted set.
	@Override
	public Iterator<E> iterator() {
		return new TreeIterator();
	}
	
	// This class implements an iterator for a binary search tree.
	private class TreeIterator implements Iterator<E> {
		
		// The queue used for iterate over a tree.
		private Queve<E> que = new LinkQueve<>();
		
		// Creates an iterator for a binary search tree.
		public TreeIterator() {
			inorder(root);
		}
		
		private void inorder(Node<E> curr) {
			if (curr != null) {
				inorder(curr.left);
				que.enqueue(curr.data);
				inorder(curr.right);
			}
		}

		// Returns true if this iterator has more elements.
		@Override
		public boolean hasNext() {
			return ! que.isEmpty();
		}

		// Returns the next element in this iteration.
		@Override
		public E next() {
			E elem = que.dequeue();
			return elem;
		}
		
	}

	// This class defines a binary tree node.
	private static class Node<T> {
		public T data;
		public Node<T> left, right;

		public Node(T data) {
			this.data = data;
		}

	}

}