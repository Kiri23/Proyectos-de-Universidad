package edu.uprb.test;
import java.util.Random;


/*
 * Source file: IntBinarySearchTreeTest.java
 * This class is a test application for the binary search tree of integers.
 */

import edu.uprb.datastructure.IntBinarySearchTree;

public class IntBinarySearchTreeTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		final int NUM_ELEMS = 10;

		Random gen = new Random();
		IntBinarySearchTree tree = new IntBinarySearchTree();
		System.out.println("Creating a binary search tree with " + 
				NUM_ELEMS + " random elements...");
		for (int idx = 0; idx < NUM_ELEMS; idx++){
			tree.add(gen.nextInt(NUM_ELEMS));
		}

		/*	for (Object element : tree)
			System.out.println(element.toString() );
		System.out.println();
		 */
		
		System.out.println();

		System.out.println("This is the tree...");
		System.out.println(tree);
		System.out.println("Its size is " + tree.size());
		System.out.println("The sum of its elements is " + tree.sum());
		System.out.println(" The maximum is "+tree.maximum());
		System.out.println(" the minimum is " + tree.minimum() );
		System.out.println(" The depth of this tree is "+ tree.maxDepth());
		tree.deleteTreeNode(0);
		System.out.println(" removing the number 0 ");
		System.out.println(tree);
		System.out.println(" the minimun now is "+ tree.minimum());
		System.out.println();

		System.out.println("A random element is searched...");
		int elem = gen.nextInt(NUM_ELEMS);
		if (tree.contains(elem))
			System.out.println(elem + " was found");
		else
			System.out.println(elem + " was not found");
		System.out.println();

		System.out.println("End of tests.");
		System.exit(0);	
	}
}