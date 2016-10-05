/*
 * Source file: FlowLayoutDemo.java
 * This class represents a frame that uses the flow layout manager for its
 * content pane.
 */

package edu.uprb.layout_demo;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FlowLayoutDemo extends JFrame {
	
	// The components and their containing panel.
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton;
	private JButton fourthButton;
	private JButton fifthButton;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.
	public FlowLayoutDemo() {
		setTitle("Flow Layout Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 150);      // width, height
		setLocation(400, 400);  // x, y
		
		buildMainPanel();
		add(mainPanel);
	}
	
	// Builds the main panel and its components.
	private void buildMainPanel() {
		firstButton = new JButton("First");
		secondButton = new JButton("Second");
		thirdButton = new JButton("Third");
		fourthButton = new JButton("Fourth");
		fifthButton = new JButton("Fifth");
		
		mainPanel = new JPanel();
		// este el layouts por default se puede tambien and=dir en el constructor 
		mainPanel.setLayout(new FlowLayout()); // not needed, default for panels// este 
		mainPanel.add(firstButton);
		mainPanel.add(secondButton);
		mainPanel.add(thirdButton);
		mainPanel.add(fourthButton);
		mainPanel.add(fifthButton);
	}
	
	// Instantiates the frame.
	public static void main(String[] args) {
		FlowLayoutDemo demo = new FlowLayoutDemo();
		demo.setVisible(true);
	}

}