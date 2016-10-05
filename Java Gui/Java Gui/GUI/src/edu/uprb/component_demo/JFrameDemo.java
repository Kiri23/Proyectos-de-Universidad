/*
 * Source file: JFrameDemo.java
 * This class represents a simple frame (window).
 */

package edu.uprb.component_demo;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JFrameDemo extends JFrame {

	// Creates an empty frame (window).
	public JFrameDemo() {
		setTitle("JFrame Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // es equivalente a system.exit(0)
		setSize(350, 250);      // width, height
		setLocation(400, 400);  // x, y //setLocationRelativeto(null)la coloca en el centro 
	}
	
	// Instantiates the frame.
	public static void main(String[] args) {
		JFrameDemo demo = new JFrameDemo();
		demo.setVisible(true);
	}
}