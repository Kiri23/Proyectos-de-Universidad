/*
 * Source file: JTextFieldDemo.java
 * This class represents a frame that contains a text field.
 */

package edu.uprb.component_demo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JTextFieldDemo extends JFrame {
	
	// The components and their containing panel.
	private JLabel simpleLabel;
	private JTextField simpleTextField;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.	
	public JTextFieldDemo() {
		setTitle("JTextField Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 100);      // width, height
		setLocation(400, 400);  // x, y
		
		// creo el panel 
		buildMainPanel();
		// ando el panel al JFRame
		add(mainPanel);
	}

	// Builds a panel and its components.
	private void buildMainPanel() {
		simpleLabel = new JLabel();
		simpleLabel.setText("Enter a text:");
		
		// otro componente JTEXTField 
		simpleTextField = new JTextField();
		// determina el ancho del texto
		simpleTextField.setColumns(10);
		simpleTextField.setText("change the text");
		//select all , seleciona todo el texto
		simpleTextField.selectAll();
		
		mainPanel = new JPanel();
		mainPanel.add(simpleLabel);
		// anade el textfield al panel que esta en el JFRAME 
		mainPanel.add(simpleTextField);
	}

	// Instantiates the frame.
	public static void main(String[] args) {
		JTextFieldDemo demo = new JTextFieldDemo();
		demo.setVisible(true);
	}
	
}