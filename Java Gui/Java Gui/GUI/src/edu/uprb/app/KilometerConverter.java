/*
 * Source file: KilometerConverter.java
 * This class represents a frame that let the user enter a distance in kilometers
 * and displays the equivalent distance in miles.
 */

package edu.uprb.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class KilometerConverter extends JFrame {

	// The components and their containing panel.
	private JLabel kilometersLabel;
	private JTextField kilometersTextField;
	private JButton convertButton;
	private JButton resetButton;
	private JLabel milesLabel;
	private JTextField milesTextField; // read Only
	private JPanel mainPanel; 

	// Creates a frame that contains the main panel.
	public KilometerConverter() {
		setTitle("Kilometer Converter ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setLocation(400,400);

		buildPanel();
		add(mainPanel);
	}

	// Builds a panel and its components.
	private void buildPanel() {
		kilometersLabel = new JLabel("Kilometer: ");
		kilometersTextField = new JTextField(5); // texField de tamano 5 //columns 

		convertButton = new JButton("Convert");
		convertButton.setMnemonic(KeyEvent.VK_C);

		resetButton = new JButton("Reset");
		resetButton.setMnemonic(KeyEvent.VK_R);

		milesLabel = new JLabel("Miles:");
		milesTextField = new JTextField(5);
		// no se puedeeditar // no se puede tampoco entra en el focus,cuando de con tab 
		milesTextField.setEditable(false);
		milesTextField.setFocusable(false);

		convertButton.addActionListener(new ButtonListener());
		resetButton.addActionListener(new ButtonListener());

		mainPanel = new JPanel();
		mainPanel.add(kilometersLabel);
		mainPanel.add(kilometersTextField);
		mainPanel.add(convertButton);
		mainPanel.add(resetButton);
		mainPanel.add(milesLabel);
		mainPanel.add(milesTextField);


	}

	// This private class is an action listener for the buttons.
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent evt) {
			// lo que se compara es la direcion //converte=Button tiene la referencia a la dirrecion
			if(evt.getSource() == convertButton) {
				String input = kilometersTextField.getText();
				try{
					double kilometers = Double.parseDouble(input);
					double miles = kilometers * 0.6214;

					DecimalFormat fmt = new DecimalFormat("#,##0.000");
					milesTextField.setText(fmt.format(miles));
				}catch(NumberFormatException ex){
					// mostrar un optionPaneque que pertenesca al mainPanel y va a ser dependiente del MainPanel
					// no puede seguir bregando hasta que atienda el showMessageDialog 
					JOptionPane.showMessageDialog(mainPanel, "Invalid Number!,Try Again.",
							"Number Format Error",
							JOptionPane.ERROR_MESSAGE);
					// no borralo solament selecionar todo el texto 
					kilometersTextField.selectAll();
					kilometersTextField.requestFocusInWindow();
					
					milesTextField.setText("");
				}
				
			}else{ // si no es convertButton seria entonces reset pq no hay otro button 
				milesTextField.setText("");
				kilometersTextField.setText("");
				kilometersTextField.requestFocusInWindow();

			}
			
		}
		
	}

	// Instantiates the frame.
	public static void main(String[] args) {
		KilometerConverter converter = new KilometerConverter();
		converter.setVisible(true);
	}

}