package edu.uprb.collection;

public class ArrayQueue<E> implements Queve<E> {
	
	private E[] data;
	private int front,rear;
	private int size; 
	
	// aqui hay que  crear constructores pq sino data lo pone en null 
	// y rear en 0 que no es lo que quiero
	
	 public ArrayQueue(int initCapacity) {
		if (initCapacity < 0)
			throw new IllegalArgumentException("negative capacity");
		data = (E[])new Object[initCapacity];
		rear = data.length - 1;
		// size == 0
		
	}
	
	 public ArrayQueue() {
		this(10);
	}
	
	@Override
	public void enqueue(E elem) {
		if ( size == data.length)
			expandCapacity();
		rear = (rear + 1) % data.length;  // pq el rear empieza en el ultimo y si le suma 1 se empieza en 1 
		data[rear] = elem;
		size++;
		
	}
	
	public void expandCapacity(){   // tiempo armotizado
		E[] temp = (E[]) new Object[size * 2];
		for ( int ctr = 0; ctr < size; ctr++)
			temp[ctr] = data[(front + ctr) % data.length];
		data = temp;
		front = 0;
		rear = size -1; 
		
		
		
	}

	@Override
	public E dequeue() {
		if (isEmpty())
			throw new EmptyCollectionException("Empty queue");
		E elem = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
	    size --;
		return elem;
		
	}

	@Override
	public E peek() {
		if (isEmpty())
			throw new EmptyCollectionException("Empty queue");
		return data[front];
	}

	@Override
	public boolean isEmpty() {
		return size == 0; // se necesita size pq front y near 
		// siempre va a estra uno al lado del otro y no se sabe si es que va a estar lleno 
		// o si va a estar vacio
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder("[");
		for ( int ctr = 0; ctr < size; ctr++){ 
			str.append(data[front + ctr % data.length]);
			if(ctr < size -1)
				str.append(",");
		}
		
		return str.append("]").toString();
	}

}
