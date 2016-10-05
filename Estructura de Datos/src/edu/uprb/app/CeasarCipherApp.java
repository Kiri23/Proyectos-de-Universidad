/*
 * CeasarCipherApp.java
 * This application demonstrates the use of queues to encrypt and decrypt
 * messages using the Caesar cipher with a repeating set of key values.
 */

package edu.uprb.app;

import edu.uprb.collection.*;

public class CeasarCipherApp {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		String message = "Data Structures";
		String encoded = "", decoded = "";
		int[] key = {3, 1, 7, 4, 2, 5};
		
		Queve<Integer> encodeKeyQueue = new LinkQueve<Integer>();
		Queve<Integer> decodeKeyQueue = new LinkQueve<Integer>();
		
		// Display original message
		System.out.println("Original message: " + message);
		
		// Load key queues
		for (int index = 0; index < key.length; index++) {
			encodeKeyQueue.enqueue(key[index]);
			decodeKeyQueue.enqueue(key[index]);
		}
		
		// Encode message by right shifting each character by the amount
		// given by the corresponding key value
		for (int index = 0; index < message.length(); index++) {
			int keyValue = encodeKeyQueue.dequeue();
			encoded += (char) ((int)message.charAt(index) + keyValue);
			encodeKeyQueue.enqueue(keyValue);
		}
		System.out.println("Encoded message: " + encoded);
		
		// Decode message by left shifting each character by the amount
		// given by the corresponding key value
		for (int index = 0; index < encoded.length(); index++) {
			int keyValue = decodeKeyQueue.dequeue();
			decoded += (char) ((int)encoded.charAt(index) - keyValue);
			decodeKeyQueue.enqueue(keyValue);
		}
		System.out.println("Decoded message: " + decoded);
		System.out.println();
		System.out.println("Thanks for using this program.");
	}

}