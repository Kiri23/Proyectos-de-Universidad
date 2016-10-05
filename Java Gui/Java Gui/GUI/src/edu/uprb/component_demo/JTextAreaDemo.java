/*
 * Source file: JTextAreaDemo.java
 * This class represents a frame that contains a text area.
 */

package edu.uprb.component_demo;

import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// JtextArea es un textField de Multiples Linea 
@SuppressWarnings("serial")
public class JTextAreaDemo extends JFrame {
	
	// The components and their containing panel.
	private JLabel simpleLabel;
	private JTextArea simpleTextArea;
	private JScrollPane scrollPane;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.	
	public JTextAreaDemo() {
		setTitle("JTextArea Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);      // width, height
		setLocation(400, 400);  // x, y
		
		buildMainPanel();
		add(mainPanel);
	}
	
	// Builds a panel and its components.
	private void buildMainPanel() {
		simpleLabel = new JLabel();
		simpleLabel.setText("Enter a text:");
		
		// el simpletext area es el JtextArea
		simpleTextArea = new JTextArea();
		// la cantidad de filas 
		simpleTextArea.setRows(5);
		// la cantidad de columnas 
		simpleTextArea.setColumns(20);
		// el Line wraps lo que hace es que adjusta el texto en el JTextArea 
		// hace que no se valla a lo vertical si no que siga horinzotal
		simpleTextArea.setLineWrap(true);
		// setea un font nuevo ,Font.PLain-puede tener bold,italic etc.,14 es el tamano
		simpleTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		simpleTextArea.setText("change the text");
		simpleTextArea.selectAll();
		
		// anade los scrolling vertical e horizontal 
		scrollPane = new JScrollPane();
		// el scroll panel pertenece al jTextArea 
		scrollPane.setViewportView(simpleTextArea);
		
		mainPanel = new JPanel();
		mainPanel.add(simpleLabel);
		mainPanel.add(scrollPane);  // this includes simpleTextArea // ya JscrollPane contiene al JtextArea
	}
	
	// Instantiates the frame.
	public static void main(String[] args) {
		JTextAreaDemo demo = new JTextAreaDemo();
		demo.setVisible(true);
	}
}