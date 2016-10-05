// ButtonDemo.java: Use buttons to move message in a panel
package chapter13;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import chapter11.MessagePanel;

public class ButtonDemo extends JFrame implements ActionListener {
  // Create a panel for displaying message
  private MessagePanel messagePanel
    = new MessagePanel("Welcome to Java");

  // Declare two buttons to move the message left and right
  private JButton jbtLeft, jbtRight;

  /** Main method */
  public static void main(String[] args) {
    ButtonDemo frame = new ButtonDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }

  /** Default constructor */
  public ButtonDemo() {
    setTitle("Button Demo");

    // Set the background color of messagePanel
    messagePanel.setBackground(Color.yellow);

    // Create Panel jpButtons to hold two Buttons "<=" and "right =>"
    JPanel jpButtons = new JPanel();
    jpButtons.setLayout(new FlowLayout());
    jpButtons.add(jbtLeft = new JButton());
    jpButtons.add(jbtRight = new JButton());

    // Set button text
    jbtLeft.setText("<=");
    jbtRight.setText("=>");

    // Set keyboard mnemonics
    jbtLeft.setMnemonic('L');
    jbtRight.setMnemonic('R');

    // Set icons
    //jbtLeft.setIcon(new ImageIcon("image/left.gif"));
    //jbtRight.setIcon(new ImageIcon("image/right.gif"));

    // Set toolTipText on the "<=" and "=>" buttons
    jbtLeft.setToolTipText("Move message to left");
    jbtRight.setToolTipText("Move message to right");

    // Place panels in the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(messagePanel, BorderLayout.CENTER);
    getContentPane().add(jpButtons, BorderLayout.SOUTH);

    // Register listeners with the buttons
    jbtLeft.addActionListener(this);
    jbtRight.addActionListener(this);
  }

  /** Handle button events */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtLeft) {
      messagePanel.moveLeft();
    }
    else if (e.getSource() == jbtRight) {
      messagePanel.moveRight();
    }
  }
}