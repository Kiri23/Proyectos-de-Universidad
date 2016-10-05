/*
 * Source file: JListDemo.java
 * This class represents a frame that contains a a list.
 */

package edu.uprb.component_demo;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
// Representancion Grafica del ArrayList 
// Cada uno de estos elemento tiene sus indices y pueden saber su posicion 
public class JListDemo extends JFrame {
	
	// The components and their containing panel.
	private JList<String> simpleList; // Programacion Generica que selecione que tioo de dato quieres que contenga 
	private JScrollPane scrollPane;
	private JPanel mainPanel;
	
	// Creates a frame that contains the main panel.
	public JListDemo() {
		setTitle("JList Demo");
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
		
		simpleList = new JList<String>();
		simpleList.setVisibleRowCount(6); // seis filas visibles 
		simpleList.setListData(options); // le indico lo que va a obtener como lista 
		simpleList.addListSelectionListener(new ListListener()); // le anado el listener para que escuche a eventos 
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(simpleList);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(
				BorderFactory.createTitledBorder("Select an Option"));
		mainPanel.add(scrollPane);  // this includes simpleList // el scroll pane contiene el simpleList
	}
	
	// This private class is a list selection listener.
	private class ListListener implements ListSelectionListener {

		// Handles the selection of a list option.
		@Override
		public void valueChanged(ListSelectionEvent evt) {
			String selection = (String)simpleList.getSelectedValue(); 
			int index = simpleList.getSelectedIndex();
			
			JOptionPane.showMessageDialog(null, 
					"You selected " + selection + 
					"\nAt index #" + index);
		}
		
	}
	
	// Instantiates the frame.
	public static void main(String[] args) {
		JListDemo demo = new JListDemo();
		demo.setVisible(true);
	}

}
