// TestFontMetrics.java: Draw a message at the center of a panel
package chapter11;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;

public class TestMessagePanel extends JFrame {
  /** Default constructor */
  public TestMessagePanel() {
    MessagePanel messagePanel = new MessagePanel("Welcome to Java");

    // Set background color and font in messagePanel
    messagePanel.setBackground(Color.white);
    messagePanel.setFont(new Font("Californian FB", Font.BOLD, 30));

    // Center the message
    messagePanel.setCentered(true);

    getContentPane().add(messagePanel);
  }

  /** Main method */
  public static void main(String[] args) {
    TestMessagePanel frame = new TestMessagePanel();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setTitle("TestMessagePanel");
    frame.setVisible(true);
  }
}