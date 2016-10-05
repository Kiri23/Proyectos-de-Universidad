package edu.uprb.collection;

public class LinkStack<E> implements Stack<E> {
	
	private Node<E> top;
	private int size;
	// no hay que crear un constructor pq ya java me lo probee y 
	/// crea los valores a null y a 0.
	

	@Override
	public void push(E elem) {
		top = new Node< >(elem,top); // top al principio es nullo, pero si jno es nullo pues sigue anadienedo a la direcion de top; 
		// no hay que escribir la <E> pq ya en Node estan Definido el <E> y en new Node tampoco pq se infiere por el top es <E>
		size ++;
	}

	@Override
	public E pop() {
		if(isEmpty()) // se deve hacer de firentes fformas verifcando diferentes condiciones,size=0,top==null.size()==0 y isEmpty()
			throw new EmptyCollectionException("empty stack");
		// coger la direcion de data en una variable temporera para quer el garbage collector no se la lleve 
		// y borra el .next para el proximo elemento y el grabaGE Collector se lo lleva y asi elimino un Nodo
		// el unboxing se encarga de desovolver el objeto a la clase Primitiva(Wrapper,Class)
		E elem = top.data; 
		top = top.next;
		size --;
		return elem;
	}

	@Override
	public E peek() {
		if(top == null)
			return top.data;
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}

	@Override
	public int size() {
		
		return size;
	}
	
	// ella no pone le toString automaticamente pq ya el toString esta definido en el 
	// la clase Object
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder("[");		
		for (Node<E> curr = top; curr != null; curr = curr.next) {
			str.append(curr.data);
			if(curr.next != null)
				str.append(",");
		}
		return str.append("]").toString();
		
	}
	
	
	private static class Node<T>{
		public T data;
		public Node<T> next;
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		
	}
	
	
	
	
	
	

}
