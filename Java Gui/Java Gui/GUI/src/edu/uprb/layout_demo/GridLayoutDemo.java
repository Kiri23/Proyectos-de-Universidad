/*
 * Source file: GridLayoutDemo.java
 * This class represents a frame that uses the grid layout manager for its
 * content pane.
 */

package edu.uprb.layout_demo;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
// es como un arrayBidimensional filas ,columnas 
public class GridLayoutDemo extends JFrame {

	// The components and their containing panel.
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton;
	private JButton fourthButton;
	private JButton fifthButton;
	private JButton sixthButton;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.
	public GridLayoutDemo() {
		setTitle("Grid Layout Demo");
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
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2, 3)); // rows, columns 2 elementos pro cada fila y 3 elementos por cada columnas  
		mainPanel.add(firstButton);
		mainPanel.add(secondButton);
		mainPanel.add(thirdButton);
		mainPanel.add(fourthButton);
		mainPanel.add(fifthButton);
		mainPanel.add(sixthButton);
	}
	
	// Instantiates the frame.
	public static void main(String[] args) {
		GridLayoutDemo demo = new GridLayoutDemo();
		demo.setVisible(true);
	}
}