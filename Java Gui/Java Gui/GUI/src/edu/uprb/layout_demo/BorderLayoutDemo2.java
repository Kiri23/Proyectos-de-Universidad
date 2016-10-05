/*
 * Source file: BorderLayoutDemo2.java
 * This class represents a frame that uses the border layout manager for its
 * content pane.
 */

package edu.uprb.layout_demo;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BorderLayoutDemo2 extends JFrame {

	// The components and their containing panel.
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton;
	private JButton fourthButton;
	private JButton fifthButton;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.
	public BorderLayoutDemo2() {
		setTitle("Border Layout Demo 2");
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
		
		// Create subpanels for each button.
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		// Add each button to its corresponding subpanel.
		panel1.add(firstButton);
		panel2.add(secondButton);
		panel3.add(thirdButton);
		panel4.add(fourthButton);
		panel5.add(fifthButton);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		// lo que crece es el panel ey el panel contien el button pero el button no crece pq lo que crece es el panel 
		mainPanel.add(panel1, BorderLayout.NORTH);  // this includes firstButton // lo que crece es el panel 
		mainPanel.add(panel2, BorderLayout.SOUTH);  // this includes secondButton
		mainPanel.add(panel3, BorderLayout.EAST);   // this includes thirdButton
		mainPanel.add(panel4, BorderLayout.WEST);   // this includes fourthButton
		mainPanel.add(panel5, BorderLayout.CENTER); // this includes fifthButton
	}

	// Instantiates the frame.
	public static void main(String[] args) {
		BorderLayoutDemo2 demo = new BorderLayoutDemo2();
		demo.setVisible(true);
	}
	
}