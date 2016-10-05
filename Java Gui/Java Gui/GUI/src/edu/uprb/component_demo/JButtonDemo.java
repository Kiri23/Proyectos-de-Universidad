/*
 * Source file: JButtonDemo.java
 * This class represents a frame that contains some buttons.
 */

package edu.uprb.component_demo;

// pero awt contiene los eventos 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

// en general swing cre los componentes 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
// tengo un label que dentro de un panel tiene tres botones 
public class JButtonDemo extends JFrame {
	
	// The components and their containing panel.
	private JLabel simpleLabel;
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.
	public JButtonDemo() {
		setTitle("JButton Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 100);      // width, height
		setLocation(400, 400);  // x, y
		
		buildMainPanel();
		add(mainPanel);
	}

	// Builds a panel and its components.
	private void buildMainPanel() {
		simpleLabel = new JLabel();
		simpleLabel.setText("Press a button.");
		
		firstButton = new JButton();
		firstButton.setText("First");
		// indicarle la nemonica /Alt + f // lo que hace es 
		// subrayar la letra F 
		firstButton.setMnemonic(KeyEvent.VK_F);
		
		secondButton = new JButton();
		secondButton.setText("Second");
		secondButton.setMnemonic(KeyEvent.VK_S);
		
		thirdButton = new JButton();
		thirdButton.setText("Third");
		thirdButton.setMnemonic(KeyEvent.VK_T);
		
		// esto permite que el buton este escuchando acciones 
		ButtonListener listener = new ButtonListener();
		// el addActionListener requiere un tipo de dato ActionListener
		firstButton.addActionListener(listener);
		secondButton.addActionListener(listener);
		thirdButton.addActionListener(listener);
		
		mainPanel = new JPanel();
		mainPanel.add(simpleLabel);
		mainPanel.add(firstButton);
		mainPanel.add(secondButton);
		mainPanel.add(thirdButton);
	}
	
	// esta clase solamente se llama cuando se presiona un button // pq el button anade la clase buttonListener
	// This private class is an action listener for the buttons. // pede tener multiples clase privadas pero solamente una clase publica
	private class ButtonListener implements ActionListener {
		//ActionListener contiene solamente un solo metod actionPerformed
		// ActionListener es una interfaz qque tengo que implementar todos los metodos definido en su OInterface z 
		
		
		// Handles the click of the buttons.
		@Override
		// ActionEvent me ayuda a determinar cual es el button que presione 
		//Action event se Importa de Awt 
		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == firstButton)
				JOptionPane.showMessageDialog(null,        // null para que aparesca en el centro
						"You pressed the first button");
			else if (evt.getSource() == secondButton)
				JOptionPane.showMessageDialog(null,
						"You pressed the second button");
			else
				JOptionPane.showMessageDialog(null,
						"You pressed the third button");
		}
	}

	// Instantiates the frame.
	public static void main(String[] args) {
		JButtonDemo demo = new JButtonDemo();
		demo.setVisible(true);
	}
	
}