package edu.uprb.collection;


public class LinkQueve<E> implements Queve<E> {

	private Node<E> front,rear;
	private int size;

	// no hay que crear un constructor pq cando se crea un objeto se crea con todo a nullo y size a 00 
	// que es lo qie se va ahacer en el construtor 

	@Override
	public void enqueue(E elem) {
		if ( front == null)
			front = rear = new Node<>(elem,null);
		else 
			rear = rear.next = new Node<>(elem,null);
		
		size++;
		
	}

	@Override
	public E dequeue() {
		if (isEmpty())
			throw new EmptyCollectionException("Empty queve");
		E elem = front.data;
		front = front.next;
		if (front == null)
			rear = null;
		size --;
		return elem;

	}

	@Override
	public E peek() {
		if (isEmpty())
			throw new EmptyCollectionException("Empty Queve");
		return front.data;
	}

	@Override
	public boolean isEmpty() {
		return size==0 ;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}



	// ella no pone le toString automaticamente pq ya el toString esta definido en el 
	// la clase Object
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder("[");		
		for (Node<E> curr = front; curr != null; curr = curr.next) {
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
