/*
 * Source file: JComboBoxDemo.java
 * This class represents a frame that contains a combo box.
 */

package edu.uprb.component_demo;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
// comboBox es una combinacion entre TextArea 
public class JComboBoxDemo extends JFrame {
	
	// The components and their containing panel.
	private JComboBox<String> simpleCombo;
	private JScrollPane scrollPane;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.
	public JComboBoxDemo() {
		setTitle("JComboBox Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);      // width, height
		setLocation(400, 200);  // x, y
		
		buildMainPanel();
		add(mainPanel);
	}
	
	// Builds a panel and its components.
	private void buildMainPanel() {
		String[] options = { "First", "Second", "Third", "Fourth", "Fifth",
				"Sixth", "Seventh", "Eighth", "Nineth", "Tenth"};
		
		simpleCombo = new JComboBox<String>(); // se crea 
		simpleCombo.addItem(""); // anade un item 
		for (String elem : options)
			simpleCombo.addItem(elem); // forEach loop para andir los items 
		simpleCombo.addItemListener(new ComboBoxListener()); // andele un listener para escuchar por evento 
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(simpleCombo);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(
				BorderFactory.createTitledBorder("Select an Option"));
		mainPanel.add(scrollPane);  // this includes simpleList
	}
	
	// This private class is an action listener.
	private class ComboBoxListener implements ItemListener {

		// Handles the selection of a combo box option.
		@Override
		public void itemStateChanged(ItemEvent e) {
			String selection = (String)simpleCombo.getSelectedItem();
			int index = simpleCombo.getSelectedIndex();
			
			JOptionPane.showMessageDialog(mainPanel, 
					"You selected " + selection + 
					"\nAt index #" + index);
		}
		
	}
	
	// Instantiates the frame.
	public static void main(String[] args) {
		JComboBoxDemo demo = new JComboBoxDemo();
		demo.setVisible(true);
	}

}
