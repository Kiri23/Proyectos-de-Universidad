package edu.uprb.collection;

public class EmptyCollectionException extends RuntimeException {
	
	// Creates an exception with no detail message.
	public EmptyCollectionException() {
		super();
	}

	// Creates an exception with the given detail message.
	public EmptyCollectionException(String msg) {
		super(msg);
	}
	
	
}
