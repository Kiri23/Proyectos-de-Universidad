/*
 * Source file: BorderLayoutDemo.java
 * This class represents a frame that uses the border layout manager for its
 * content pane.
 */

package edu.uprb.layout_demo;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
// BorderLayouts es sencillamente lo mismo que eclise que tiene North,Sourth,East,West,Center 
public class BorderLayoutDemo extends JFrame {

	// The components and their containing panel.
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton;
	private JButton fourthButton;
	private JButton fifthButton;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.
	public BorderLayoutDemo() {
		setTitle("Border Layout Demo");
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
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(firstButton, BorderLayout.NORTH);
		mainPanel.add(secondButton, BorderLayout.SOUTH);
		mainPanel.add(thirdButton, BorderLayout.EAST);
		mainPanel.add(fourthButton, BorderLayout.WEST);
		mainPanel.add(fifthButton, BorderLayout.CENTER);
	}
	
	// Instantiates the frame.
	public static void main(String[] args) {
		BorderLayoutDemo demo = new BorderLayoutDemo();
		demo.setVisible(true);
	}

}