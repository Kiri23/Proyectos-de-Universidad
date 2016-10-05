/*
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2015
 * Christian Nogueras Rosado
 */
package edu.uprb.datastructure;


public class IntBinarySearchTree  {
	/** 
	 * The reference to the root node of this tree 
	 */
	private Node root;

	/**
	 * Add an element to this tree
	 * @param elem - the element to be added
	 */
	public void add(int elem ){
		root = add(elem, root);

	}


	private Node add(int elem, Node root){
		if(root == null){
			// nodo left que son los menores y nodo right que son los mayores nullo en los else de abajo es que se anaden.
			root = new Node(elem,null,null);
		}
		else {
			
			if ( elem == root.data)
				; // do nothing , duplicate 
			// si aqui el elem que se entra es menor que 0 o mayor que el numero anterior que se entro entonces se entra al root especificado
			else if (elem < root.data)
				root.left = add(elem,root.left);
			else   // si no es menor tiene que ser mayor y se entra al nodo que le recomienda 
				root.right = add(elem,root.right);
		}
		// devuelve el nodo 
		return root;
	}

	/** 
	 * search is the tree contain a element 
	 * @param element - the element to be verify in the tree
	 * @return a boolean expression {@code true} if the tree contains 
	 * the element, {@code false} otherwise
	 */
	public boolean contains(int elem){
		// este root es el mismo root que esta arriba el que se anade en los add
		return contains(elem,root);

	}

	private boolean contains (int elem , Node curr){
		// que significa que no se ha creado nigun nodo todavia so que la lista esta vacia / devuelve false 
		if(curr == null){
			return false;
		}
		else {
			// si el elemento es igual al nodo padre devuelve true
			if ( elem == curr.data)
				return true;
			// si el elemento es menor que el nodo padre vuelve y llama al metodo pero esta vez con el nodo de curr.left y vuelve a chequair en el if de arriba si elemento es igual curr.left
			else if (elem < curr.data)
				return contains (elem,curr.left);
			else 
				// si es mayor haz lo mismo pero con el metodo curr.right 
				return contains(elem,curr.right);
		}

	}

	/**
	 *  return the numbers of elements 
	 * @return the number of element
	 */
	public int size(){
		// root es el nodo padre 
		return size(root);
	}

	private int size(Node curr){
		// si el nodo padre esta vacio es nullo pues no hay ningun elemento devuelve 0 
		if (curr == null)
			return 0;
		else  // else por lo menos obligado tiene que haber uno el nodo padre y despues sigue contando hasta que el curr.left sea null , cuando acabe con curr.left , empieza a sumar 1 hasta ue curr.right sea nullo loq eue hace esto es sumar siempre hasta que el metodo devuelva 0 
			return 1 + size(curr.left) + size(curr.right); // pre order "I think " 
	}

	/** 
	 * return the sum of elements in this tree
	 * @return the sums of elements in this tree
	 */
	public int sum (){
		return sum(root);
	}

	private int sum(Node curr){
		if (curr == null)
			return 0;
		else // estp es lo mismo pero con el curr.data , en ves de sumarle uno todo el tiempo le suma siempre el valor de curr.data(curr.data puede ser curr.left y curr.right, como se llamen en los metodos respectivamente)
			return curr.data + sum(curr.left) + sum(curr.right); // pre order "I think " 

	}
	/**
	 * return the maximum element in this tree
	 * @return the maximum element in this tree
	 */
	public int maximum(){
		return maximum(root);
	}
	
	private int maximum(Node curr){
		// curr.data puede ser nullo //escrachea cuando curr.data es nullo 
		// curr.data en este momento es el elemento del nodo padre
		int maxValue = curr.data;
		// si curr.right es null significa que no hay otro numero que sea mayor 
		if (curr.right == null){
			return curr.data;
		}else { // ese si no es nullo compara el mayor del nodo padre con el mayor del nodo curr que en el momento que se llame el metodo 
			maxValue = Math.max(maxValue, maximum(curr.right));
		}
		return maxValue;
	}
	
	/**
	 * return the minimum element in this tree 
	 * @return  the minmum element in this tree
	 */
	public int minimum(){
		return minimum(root);
	}

	private int minimum(Node curr){
		int minValue = curr.data;
		if (curr.left == null){
			return curr.data;
		}else {
			minValue = Math.min(minValue, minimum(curr.left));
		}
		return minValue;
	}

    /**
     * Return the height of a tree 
     * @return the height of a tree
     */
	public int maxDepth(){
		return maxDepth(root);
	}
	private int maxDepth(Node node) {
		if (node == null) 
			return 0;
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right)); 
	}

	/**
	 * Delete a tree node 
	 * @param data - the data you want to remove
	 */
	public void deleteTreeNode(int data){
		root = deleteTreeNode(root ,data);
	}

	private Node deleteTreeNode(Node root, int data) {
		// curr es el nodo padre 
		Node cur = root;
		if(cur == null){
			return cur;
		}
		// si yo quiero eliminar el 10 y curr.data es 15 entra al if 
		if(cur.data > data){            
			// cur.left = deleteNodo pero esta vez el nodo es cur.left,con la misma data
			cur.left = deleteTreeNode(cur.left, data);
		// si data es mayor entonces elimina el nodo pero esta vez con el nodo cur.right y la misma data	
		}else if(cur.data < data){
			// cur.right es el nodo que va devolver el metodo delete
			cur.right = deleteTreeNode(cur.right, data);
		}else{          
			if(cur.left == null && cur.right == null){
				cur = null;
			}else if(cur.right == null){
				// cur es el nodo padre y se le asigna el cur.left 
				cur = cur.left;
			}else if(cur.left == null){
				cur = cur.right;
			}else{
				// se encuentra right.left != null cur.right = cur.left mientras cur.left != null
				// esto va a devolver el nodo mas menor de lo mayores .
				Node temp  = findMinFromRight(cur.right);
				//curr.data es el nodo padre y guardar el numero menor 
				cur.data = temp.data;
				// cur.right cur-nodo padre 
				cur.right = deleteTreeNode(cur.right, temp.data);
			}
		}
		return cur;
	}

	private Node findMinFromRight(Node node) {
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	
	/**
	 * Return a string representation of this sorted set
	 */
	@Override 
	public String toString(){
		StringBuilder str = new StringBuilder("[");
		treeToString(str,root);			
		return str.append("]").toString();
	}

	private void treeToString ( StringBuilder str, Node curr) {
		// si el nodo padre no es nullo 
		if ( curr != null ){
			// llama al metodo pero con curr.left// entonces viene y vuelve y dice si curr.left.no es  
			treeToString(str, curr.left);
			// left.left no es nullo str.append la coma 
			if(curr.left != null)
				str.append(", ");
			// str.append la data
			str.append(curr.data);
			// left.right no es nullo append la coma 
			if(curr.right != null)
				str.append(", ");
			// vuelve y haz la llamada pero con curr.right 
			treeToString(str,curr.right);

		}

	}

	/**
	 * this private class represent a list node
	 *
	 */
	private static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}


}
