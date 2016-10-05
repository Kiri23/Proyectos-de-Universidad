/*
 * Source file: GridLayoutDemo2.java
 * This class represents a frame that uses the grid layout manager for its
 * content pane.
 */

package edu.uprb.layout_demo;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GridLayoutDemo2 extends JFrame {

	// The components and their containing panel.
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton;
	private JButton fourthButton;
	private JButton fifthButton;
	private JButton sixthButton;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.
	public GridLayoutDemo2() {
		setTitle("Grid Layout Demo 2");
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
		sixthButton = new JButton("Sixth");
		
		// Create subpanels for each button.
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		// Add each button to its corresponding subpanel.
		panel1.add(firstButton);
		panel2.add(secondButton);
		panel3.add(thirdButton);
		panel4.add(fourthButton);
		panel5.add(fifthButton);
		panel6.add(sixthButton);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2, 3)); // rows, columns
		mainPanel.add(panel1);   // dificil paneles 
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(panel5);
		mainPanel.add(panel6);
	}
	
	// Instantiates the frame.
	public static void main(String[] args) {
		GridLayoutDemo2 demo = new GridLayoutDemo2();
		demo.setVisible(true);
	}
	
}