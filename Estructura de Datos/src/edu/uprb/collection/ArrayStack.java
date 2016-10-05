package edu.uprb.collection;

public class ArrayStack<E> implements Stack<E> {
	
	private E[] data; // araray de tipo E
	private int top;  // determina el valor que esta enn tope // si les=suma 1 se le puede saber el size del Stack
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int initCapacity){ // no se escribe la E 
		if(initCapacity < 0)
			throw new IllegalArgumentException("negative initial capacity");
		data = (E[])new Object[initCapacity]; // los arrays en java  no se pueden crear de forma directa- esta es la solucion correcta hasta ahora
		top = -1; // para que el size sea 0 al principio
		
	}
	 public ArrayStack() {
		this(10);// crear un stack con capacidad de 10 inciial 
	}
	
	
	@Override
	public void push(E elem) {
		if(top + 1 == data.length) // es lo mismo a una llamada a size
			expandCapacity();      // si el array esta lleno tengo que expandirlo como lo hace un ArrayList
		// esto sigue hasta que top + 1 == size
		data[++ top] = elem;
		
	}
	
	public void expandCapacity(){
		E[] temp = (E[]) new Object [size() * 2]; // has un array del doble del size que el de data
		for (int curr = top; curr >= 0; curr--){
			temp[curr] = data[curr]; // copia las referencia del array de data 
		}
		data = temp; // cambia las direcion de data a Temp que va a tener el nuevo array del doble de size
		
	}
	@Override
	public E pop() {
		if (isEmpty())
			throw new EmptyCollectionException("Empty Stack");
		E elem = data[top];
		data[top--]= null;
		return elem;
	}

	@Override
	public E peek() {
		if(isEmpty())
			throw new EmptyCollectionException("Empty Stack");
		
		return data[top];
		
		
	}

	@Override
	public boolean isEmpty() {
		return top ==-1;
	}

	@Override
	public int size() {
		return top + 1;
	}
	@Override 
	public String toString(){
		StringBuilder str = new StringBuilder("[");
		
		// pq quiero que aparesca los datos del ultimo al primero 
		// "[c,b,a]"
		for (int curr = top; curr >= 0; curr--) {
			str.append(data[curr]);
			if(curr!=0)
				str.append(",");
		}
		
		return str.append("]").toString();
	}
	
	
	
	
	
	
	
	

}
