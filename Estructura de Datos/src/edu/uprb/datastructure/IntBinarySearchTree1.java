package edu.uprb.datastructure;


// size / 
// aqui se ultilza altura-deep. para saber los niveles
// pero el size cuenta todos los nodods que hay 

public class IntBinarySearchTree1  {
	// en una clase de nodo list yo tenei una referencia a headd 
	// en un tre tengo que teenr referemcia al root - 
	// no hay constructor pq un arbol vacio es que root sea nullo 
	private Node root;

	/* aqui solamente hay un sitio de donde se puede anadir 
	 * anade al principio.
	 * solamente hay un lugar donde anadirlo pq solamente puede haber un root pq 
	 * solamente puede haber un padre 
	 */

	public void add(int elem ){
		root = add(elem, root);

	}


	private Node add(int elem, Node root){
		if(root == null){
			/* curr es el nodo padre (root)
			 * si no se ha creado todavia creado con el elemento 
			 * y nodo left = null, y el nodo right = null;   
			 */
			root = new Node(elem,null,null);
		}
		else {
			/* else si el nodo padre.elemento es igual al elemento  
			 */
			if ( elem == root.data)
				; // do nothing 
			else if (elem < root.data)
				root.left = add(elem,root.left);
			else //if (elem > curr.data)
				root.right = add(elem,root.right);
		}
		return root;
	}

	public boolean contains(int elem){
		return contains(elem,root);

	}

	private boolean contains (int elem , Node curr){
		if(curr == null){
			return false;
		}
		else {
			if ( elem == curr.data)
				return true;
			else if (elem < curr.data)
				return contains (elem,curr.left);
			else //if (elem > curr.data)
				return contains(elem,curr.right);
		}

	}

	// retrn the numbers of elements 
	public int size(){
		return size(root);
	}

	private int size(Node curr){
		if (curr == null)
			return 0;
		else 
			return 1 + size(curr.left) + size(curr.right); // pre order "I think " 
	}

	public int sum (){
		return sum(root);
	}

	private int sum(Node curr){
		if (curr == null)
			return 0;
		else 
			return curr.data + sum(curr.left) + sum(curr.right); // pre order "I think " 

	}

	public int maximum(){
		return maximum(root);
	}

	/*	private int maximum(Node curr){

		int element = root.data;
		if(curr == null){
			System.out.println(element + " element when curr is null " + "\n");
			return element;
		} else if (curr.data > element){
			System.out.println(curr.data + " this is curr.data "+ element + " element" );
			maximum(curr.right);
			return element = curr.data;
		}else {
			System.out.println("\n" +curr.data + " this is curr data is > " + element + " this is element ");
			return maximum(curr.right);
		}

	} */

	/* private int maximum(Node curr){

		int maximum = root.data;
		System.out.println( "\n"+ maximum + " this is the maximum of root ");
		int position = 1;
		if(position == size()){
			System.out.println("\n"+ maximum +" this is maximum when position is == size" );
			System.out.println("\n" +position + " ," + size() + " position y size ");
			return maximum;
		}
		if(curr != null){
			if(curr.right != null){
				if(curr.right.data > maximum){
					 maximum = curr.right.data;
					System.out.println(maximum + " this is maximum " +position +" this is the position");
				}
			}
			position ++;
			System.out.println(position + " this is position ");
			return maximum(curr.right);
		}
		System.out.println("\n"+ maximum +" this is maximum " + position + " this is position ");
		return maximum;
	} */

	private int maximum(Node curr){
		int maxValue = curr.data;
		if (curr.right == null){
			return curr.data;
		}else {
			maxValue = Math.max(maxValue, maximum(curr.right));
		}
		return maxValue;
	}

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


	public int maxDepth(){
		return maxDepth(root);
	}
	private int maxDepth(Node node) {
		if (node == null) 
			return 0;
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right)); 
	}

	public void deleteTreeNode(int data){
		root = deleteTreeNode(root ,data);
	}

	private Node deleteTreeNode(Node root, int data) {
		Node cur = root;
		if(cur == null){
			return cur;
		}
		if(cur.data > data){            
			cur.left = deleteTreeNode(cur.left, data);
		}else if(cur.data < data){
			cur.right = deleteTreeNode(cur.right, data);
		}else{          
			if(cur.left == null && cur.right == null){
				cur = null;
			}else if(cur.right == null){
				cur = cur.left;
			}else if(cur.left == null){
				cur = cur.right;
			}else{
				Node temp  = findMinFromRight(cur.right);
				cur.data = temp.data;
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

	/*	public void showRoot(){
	 *		Node root = this.root;
	 *		System.out.println();
	 *		System.out.println("------------------");
	 *		System.out.println(root.data + " this is the root Node ");
	 *		while(root !=null || root.left !=null || root.right !=null) {
	 *			if(root.left != null)
	 * 				System.out.println(root.left.data + " this is root left less que el root  ");
	 *			if(root.right != null)
	 *				System.out.println(root.right.data + " this is root right greater que el root padre " );
	 *			System.out.println("-------------------");
	 *		}
	 */	

	@Override 
	public String toString(){
		StringBuilder str = new StringBuilder("[");
		treeToString(str,root);			
		return str.append("]").toString();
	}

	private void treeToString ( StringBuilder str, Node curr){
		if ( curr != null ){
			treeToString(str, curr.left);
			if(curr.left != null)
				str.append(", ");
			str.append(curr.data);
			if(curr.right != null)
				str.append(", ");
			treeToString(str,curr.right);

		}

	}

	// clase privada State class for tree Node 
	/* un nodo puede tener dos nodos 
	 * El nodo padre - solamente puede haber un padre, el Nodo padre(root)
	 * solamente puede tener dos hijos que son los nodos left y el nodo right 
	 * el nodo left siempre va a tener el menor , el nodo right siempre e=va a tener el mayor 
	 * con referenci al nodo padre. 
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
