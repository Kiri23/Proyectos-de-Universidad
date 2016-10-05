// WelcomeApplet.java: Applet for displaying a message
package chapter14;

import javax.swing.*;

public class WelcomeApplet extends JApplet {
  /** Construct the applet */
  public WelcomeApplet() {
    getContentPane().add(
      new JLabel("Welcome to Java", JLabel.CENTER));
  }
}