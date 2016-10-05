/*
 * Source file: HospitalFeeCalculator.java
 * This class represents a frame that let the user enter the number of days in
 * a hospital, the type of room and the extras.  The application will display
 * a report with the fee.
 */

package edu.uprb.app;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HospitalFeeCalculator extends JFrame {

	// The components and their containing panels.
	private JLabel daysLabel;
	private JTextField daysTextField;
	private JPanel daysPanel;
	
	private JRadioButton publicRadioButton;
	private JRadioButton semiPrivateRadioButton;
	private JRadioButton privateRadioButton;
	private JPanel roomTypePanel;
	
	private JCheckBox tvCheckBox;
	private JCheckBox phoneCheckBox;
	private JCheckBox internetCheckBox;
	private JPanel extrasPanel;
	
	private JTextArea reportTextArea;
	private JPanel reportPanel; 
	
	private JButton calculateButton;
	private JButton resetButton;
	private JPanel buttonsPanel;

	// Creates a frame that contains the panels.
	public HospitalFeeCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hospital Fee Calculator");
		
		buildDaysPanel();
		buildRoomTypePanel();
		buildExtrasPanel();
		buildButtonsPanel();
		buildReportPanel();
		
		setLayout(new BorderLayout()); // not needed, default for content pane
		add(daysPanel, BorderLayout.NORTH);
		add(roomTypePanel, BorderLayout.WEST);
		add(extrasPanel, BorderLayout.EAST);
		add(reportPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		
		// Pack components and center frame
		pack();
		setLocationRelativeTo(null);
	}

	// Builds the days panel and its components.
	private void buildDaysPanel() {
		daysLabel = new JLabel("Number of Days:");
		daysTextField = new JTextField(10);
		
		daysPanel = new JPanel();
		daysPanel.add(daysLabel);
		daysPanel.add(daysTextField);
	}

	// Builds the room type panel and its components.
	private void buildRoomTypePanel() {
		publicRadioButton = new JRadioButton("Public");
		publicRadioButton.setMnemonic(KeyEvent.VK_P);
		publicRadioButton.setSelected(true);
		
		semiPrivateRadioButton = new JRadioButton("Semi-Private");
		semiPrivateRadioButton.setMnemonic(KeyEvent.VK_S);
		
		privateRadioButton = new JRadioButton("Private");
		privateRadioButton.setMnemonic(KeyEvent.VK_V);
		
		ButtonGroup group = new ButtonGroup();
		group.add(publicRadioButton);
		group.add(semiPrivateRadioButton);
		group.add(privateRadioButton);
		
		roomTypePanel = new JPanel(new GridLayout(3, 1));
		roomTypePanel.setBorder(BorderFactory.createTitledBorder("Room Type"));
		roomTypePanel.add(publicRadioButton);
		roomTypePanel.add(semiPrivateRadioButton);
		roomTypePanel.add(privateRadioButton);
	}
	
	// Builds the extras panel and its components.
	private void buildExtrasPanel() {
		tvCheckBox = new JCheckBox("TV");
		tvCheckBox.setMnemonic(KeyEvent.VK_T);
		
		phoneCheckBox = new JCheckBox("Phone");
		phoneCheckBox.setMnemonic(KeyEvent.VK_P);
		
		internetCheckBox = new JCheckBox("Internet");
		internetCheckBox.setMnemonic(KeyEvent.VK_I);
		
		extrasPanel = new JPanel(new GridLayout(3, 1));
		extrasPanel.setBorder(BorderFactory.createTitledBorder("Extras"));
		extrasPanel.add(tvCheckBox);
		extrasPanel.add(phoneCheckBox);
		extrasPanel.add(internetCheckBox);
	}
	
	// Builds the report panel and its components.
	private void buildReportPanel() {
		reportTextArea = new JTextArea(10, 40);
		reportTextArea.setBorder(
				BorderFactory.createLineBorder(Color.BLACK, 1));
		reportTextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		reportTextArea.setEditable(false);
		reportTextArea.setFocusable(false);
		
		reportPanel = new JPanel();
		reportPanel.add(reportTextArea);
	}

	// Builds the buttons panel and its components.
	private void buildButtonsPanel() {
		calculateButton = new JButton("Calculate");
		calculateButton.setMnemonic(KeyEvent.VK_C);
		
		resetButton = new JButton("Reset");
		resetButton.setMnemonic(KeyEvent.VK_R);
		
		ButtonListener listener = new ButtonListener();
		calculateButton.addActionListener(listener);
		resetButton.addActionListener(listener);
		
		buttonsPanel = new JPanel();
		buttonsPanel.add(calculateButton);
		buttonsPanel.add(resetButton);
	}
	
	// This private class is an action listener for the buttons.
	private class ButtonListener implements ActionListener
	{

		// Handles the click of the buttons.
		@Override
		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == calculateButton) {
				try {
					int days = Integer.parseInt(daysTextField.getText());
					
					double roomTypeFee = 0.00;
					if (publicRadioButton.isSelected())
						roomTypeFee = days * 300.00;
					else if (semiPrivateRadioButton.isSelected())
						roomTypeFee = days * 400.00;
					else
						roomTypeFee = days * 500.00;
					
					double extrasFee = 0.00;
					if (tvCheckBox.isSelected())
						extrasFee += days * 5.00;
					if (phoneCheckBox.isSelected())
						extrasFee += days * 2.00;
					if (internetCheckBox.isSelected())
						extrasFee += days * 7.00;
					
					double totalFee = roomTypeFee + extrasFee;
					
					DecimalFormat fmt = new DecimalFormat("$#,##0.00");					
					reportTextArea.setText("Hospital Fee\n\n" +
							"Room Type Fee: " + fmt.format(roomTypeFee) + "\n" +
							"Extras Fee: " + fmt.format(extrasFee) + "\n\n" +
							"TOTAL FEE: " + fmt.format(totalFee));
				}
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, 
							"Invalid Number! Try again.",
							"Number Format Error", 
							JOptionPane.ERROR_MESSAGE);
					
					daysTextField.selectAll();
					daysTextField.requestFocusInWindow();
					return;
				}
			}
			else {
				publicRadioButton.setSelected(true);
				
				tvCheckBox.setSelected(false);
				phoneCheckBox.setSelected(false);
				internetCheckBox.setSelected(false);
				
				reportTextArea.setText("");
				
				daysTextField.setText("");
				daysTextField.requestFocusInWindow();				
			}
		}
		
	}
	
	// Instantiates the frame.
	public static void main(String[] args) {
		HospitalFeeCalculator calculator = new HospitalFeeCalculator();
		calculator.setVisible(true);
	}
	
}
