/*
 * Source file: JLabelDemo.java
 * This class represents a frame that contains a label.
 */

/* El JFrame (virtual machine) contiene un ciclo de evento que chequea 
 * eventos close button expand button dismis button  
 * 
 */
package edu.uprb.component_demo;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JLabelDemo extends JFrame {
	
	// The label and its containing panel.
	private JLabel simpleLabel;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.
	public JLabelDemo() {
		setTitle("JLabel Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 250);      // width, height
		setLocation(400, 400);  // x, y
		
		buildMainPanel();
		add(mainPanel);
	}
	
	// para andir objetos al jFrame no lo ouedo anadir directamente tengo que anadirlo a un panel 
	// y el panel continen los elementos como el label etc.el label no esta en el jFrame ,el panel es el que esta en jFrame
	// pueden haber multiples panel en un jframe y el panel ppuede tener multiples componentes
	// Builds a panel and its components.
	private void buildMainPanel() {
		// crea un label // anade las propiedades de un label
		simpleLabel = new JLabel();
		simpleLabel.setText("This is a label.");

		// se inicializa 
		mainPanel = new JPanel();
		// se anade un componento al panel 
		mainPanel.add(simpleLabel);
	}
	
	// Instantiates the frame.
	public static void main(String[] args) {
		JLabelDemo demo = new JLabelDemo();
		demo.setVisible(true);
	}

}