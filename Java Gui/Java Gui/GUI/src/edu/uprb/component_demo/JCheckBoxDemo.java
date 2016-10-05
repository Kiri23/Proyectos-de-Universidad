/*
 * Source file: JCheckBoxDemo.java
 * This class represents a frame that contains some check boxes.
 */

package edu.uprb.component_demo;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
// se pueden elegir mas de uno // no hay grouping pq todos los botones son independientes 
public class JCheckBoxDemo extends JFrame {
	
	// The components and their containing panel.
	private JCheckBox firstCheckBox;
	private JCheckBox secondCheckBox;
	private JCheckBox thirdCheckBox;
	private JLabel selectionLabel;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.
	public JCheckBoxDemo() {
		setTitle("JCheckBox Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 150);      // width, height
		setLocation(400, 200);  // x, y
		
		buildMainPanel();
		add(mainPanel);
	}

	// Builds a panel and its components.
	private void buildMainPanel() {
		firstCheckBox = new JCheckBox();
		firstCheckBox.setText("First");
		firstCheckBox.setMnemonic(KeyEvent.VK_F);
		
		secondCheckBox = new JCheckBox();
		secondCheckBox.setText("Second");
		secondCheckBox.setMnemonic(KeyEvent.VK_S);
		
		thirdCheckBox = new JCheckBox();
		thirdCheckBox.setText("Third");
		thirdCheckBox.setMnemonic(KeyEvent.VK_T);
		
		CheckBoxListener listener = new CheckBoxListener();
		firstCheckBox.addItemListener(listener);  // no es buttonActinLstener 
		secondCheckBox.addItemListener(listener);  // es ItemListener pq cada uno es depedniente 
		thirdCheckBox.addItemListener(listener);
		
		selectionLabel = new JLabel();
		selectionLabel.setText("Your selection: NOTHING");
		
		mainPanel = new JPanel();
		mainPanel.setBorder(  // anadiele un border al mainPanel 
				BorderFactory.createTitledBorder("Select an Option"));

		mainPanel.add(firstCheckBox);
		mainPanel.add(secondCheckBox);
		mainPanel.add(thirdCheckBox);
		mainPanel.add(selectionLabel);
	}
	
	// This private class is an item listener for the check boxes.
	private class CheckBoxListener implements ItemListener {

		// Handles the click of the check boxes.
		@Override
		public void itemStateChanged(ItemEvent evt) {
			String selection = "Your selection:";
			
			// se ultiliza if secuncialmente pq cada button es dependiente un button no depende del otro 
			// si pongo if and else es error logico pq un button no dependiende de otro 
			if (firstCheckBox.isSelected())
				selection += " First";
			
			if (secondCheckBox.isSelected())
				selection += " Second";
			
			if (thirdCheckBox.isSelected())
				selection += " Third";
			
			if (! firstCheckBox.isSelected() && ! secondCheckBox.isSelected() && 
					!thirdCheckBox.isSelected())
				selection = "Your selection: NOTHING";
			
			selectionLabel.setText(selection);
		}
		
	}

	// Instantiates the frame.
	public static void main(String[] args) {
		JCheckBoxDemo demo = new JCheckBoxDemo();
		demo.setVisible(true);
	}
	
}
