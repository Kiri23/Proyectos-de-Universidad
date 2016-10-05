// MoveMessageDemo.java: Move the message in a panel using mouse
package chapter12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import chapter11.MessagePanel;

public class MoveMessageDemo extends JFrame {
  /** Default constructor */
  public MoveMessageDemo() {
    // Create a MoveMessagePanel instance for drawing a message
    MoveMessagePanel p = new MoveMessagePanel("Welcome to Java");

    // Place the message panel in the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p);
  }

  /** Main method */
  public static void main(String[] args) {
    MoveMessageDemo frame = new MoveMessageDemo();
    frame.setTitle("Move Message Using Mouse");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(100, 80);
    frame.setVisible(true);
  }
}

// MoveMessagePanel draws a message
class MoveMessagePanel extends MessagePanel
  implements MouseMotionListener {
  /** Construct a panel to draw string s */
  public MoveMessagePanel(String s) {
    super(s); // What if this line is omitted?
    this.addMouseMotionListener(this);
  }

  /** Handle mouse moved event */
  public void mouseMoved(MouseEvent e) {
  }

  /** Handle mouse dragged event */
  public void mouseDragged(MouseEvent e) {
    // Get the new location and repaint the screen
    setXCoordinate(e.getX());
    setYCoordinate(e.getY());
  }
}