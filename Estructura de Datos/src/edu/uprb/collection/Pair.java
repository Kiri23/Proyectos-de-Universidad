package edu.uprb.collection;

public class Pair<T> {
	private T first;
	private T second;
	
	public Pair(T first, T second) {
		super();
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals (Object obj){
		if (this == obj)
			return true;
		if(!(obj instanceof Pair))
			return false;
		
		Pair other = (Pair)obj;
		return this.first.equals(other.first) &&
				this.second.equals(other.second);
		
		
	}
	
	// ordenados no es lo mismo que sorted - ordenados es que no estan sorted ordenados de menor a mayor
	@Override
	public String toString() {
		return "Pair (" + first + "," + second + ")";
	}
	
	
	
	
	
	

}