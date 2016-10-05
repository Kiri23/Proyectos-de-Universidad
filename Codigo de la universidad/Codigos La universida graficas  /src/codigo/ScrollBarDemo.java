// ScrollBarDemo.java: Use scrollbars to move the message
package chapter13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import chapter11.MessagePanel;

public class ScrollBarDemo extends JFrame
  implements AdjustmentListener {
  // Create horizontal and vertical scrollbars
  private JScrollBar jscbHort =
    new JScrollBar(JScrollBar.HORIZONTAL);
  private JScrollBar jscbVert =
    new JScrollBar(JScrollBar.VERTICAL);

  // Create a MessagePanel
  private MessagePanel messagePanel =
    new MessagePanel("Welcome to Java");

  /** Main method */
  public static void main(String[] args) {
    ScrollBarDemo frame = new ScrollBarDemo();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  /** Default constructor */
  public ScrollBarDemo() {
    setTitle("ScrollBar Demo");

    // Add scrollbars and message panel to the frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(messagePanel, BorderLayout.CENTER);
    getContentPane().add(jscbVert, BorderLayout.EAST);
    getContentPane().add(jscbHort, BorderLayout.SOUTH);

    // Register listener for the scrollbars
    jscbHort.addAdjustmentListener(this);
    jscbVert.addAdjustmentListener(this);
  }

  /** Handle scrollbar adjustment actions */
  public void adjustmentValueChanged(AdjustmentEvent e) {
    if (e.getSource() == jscbHort) {
      // getValue() and getMaximumValue() return int, but for better
      // precision, use double
      double value = jscbHort.getValue();
      double maximumValue = jscbHort.getMaximum();
      double newX =
        (value * messagePanel.getWidth() / maximumValue);
      messagePanel.setXCoordinate((int)newX);
    }
    else if (e.getSource() == jscbVert) {
      // getValue() and getMaximumValue() return int, but for better
      // precision, use double
      double value = jscbVert.getValue();
      double maximumValue = jscbVert.getMaximum();
      double newY =
        (value * messagePanel.getHeight() / maximumValue);
      messagePanel.setYCoordinate((int)newY);
    }
  }
}