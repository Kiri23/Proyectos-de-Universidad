/*
 * Source file: JRadioButtonDemo.java
 * This class represents a frame that contains some radio buttons.
 */

package edu.uprb.component_demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
// RadioButton que solamente se puede elegir un button solamente 
// no dos a la vez 
public class JRadioButtonDemo extends JFrame {

	// The components and their containing panel.
	private JRadioButton firstRadioButton;
	private JRadioButton secondRadioButton;
	private JRadioButton thirdRadioButton;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.
	public JRadioButtonDemo() {
		setTitle("JRadioButton Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 100);      // width, height
		setLocation(400, 200);  // x, y
		
		buildMainPanel(); //lama al metodo privado 
		add(mainPanel);
	}
	
	// Builds a panel and its components.
	private void buildMainPanel() {
		firstRadioButton = new JRadioButton();
		firstRadioButton.setText("First");
		firstRadioButton.setMnemonic(KeyEvent.VK_F);
		
		secondRadioButton = new JRadioButton();
		secondRadioButton.setText("Second");
		secondRadioButton.setMnemonic(KeyEvent.VK_S);
		
		thirdRadioButton = new JRadioButton();
		thirdRadioButton.setText("Third");
		thirdRadioButton.setMnemonic(KeyEvent.VK_T);
		
		RadioButtonListener listener = new RadioButtonListener();
		firstRadioButton.addActionListener(listener);
		secondRadioButton.addActionListener(listener);
		thirdRadioButton.addActionListener(listener);
		
		// el concepto es logico , no es visual 
		// si no se pone eso se pueden selecionar los tres juntos
		// pq cada button es depediente del otro y se necesita saber si un button es selecionado 
		// para que no se pueda selecionar otro 
		ButtonGroup group = new ButtonGroup();
		group.add(firstRadioButton);
		group.add(secondRadioButton);
		group.add(thirdRadioButton);
		
		mainPanel = new JPanel(); // ponerle un border al mainPanel y ponerle un texto 
		mainPanel.setBorder(
				BorderFactory.createTitledBorder("Select an Option"));

		mainPanel.add(firstRadioButton);
		mainPanel.add(secondRadioButton);
		mainPanel.add(thirdRadioButton);
	}
	
	// This private class is an action listener for the buttons.
	private class RadioButtonListener implements ActionListener {

		// Handles the click of the radio buttons.
		@Override
		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == firstRadioButton)
				JOptionPane.showMessageDialog(mainPanel, 
						"You pressed the first radio button");
			else if (evt.getSource() == secondRadioButton)
				JOptionPane.showMessageDialog(mainPanel,
						"You pressed the second radio button");
			else
				JOptionPane.showMessageDialog(mainPanel,
						"You pressed the third radio button");
		}
		
	}
	
	// Instantiates the frame.
	public static void main(String[] args) {
		JRadioButtonDemo demo = new JRadioButtonDemo();
		demo.setVisible(true);
	}
	
}