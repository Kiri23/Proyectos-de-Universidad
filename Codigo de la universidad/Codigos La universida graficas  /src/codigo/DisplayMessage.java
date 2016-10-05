// DisplayMessage.java: Display a message on a panel in the applet
package chapter14;

import javax.swing.*;
import chapter11.MessagePanel;

public class DisplayMessage extends JApplet {
  /** Initialize the applet */
  public void init() {
    // Get parameter values from the HTML file
    String message = getParameter("MESSAGE");
    int x = Integer.parseInt(getParameter("X"));
    int y = Integer.parseInt(getParameter("Y"));

    // Create a message panel
    MessagePanel messagePanel = new MessagePanel(message);
    messagePanel.setXCoordinate(x);
    messagePanel.setYCoordinate(y);

    // Add the message panel to the applet
    getContentPane().add(messagePanel);
  }
}