// DrawMessage.java: Display a message on a JPanel
package chapter11;

import javax.swing.*;
import java.awt.*;

public class DrawMessage extends JPanel {
  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new JFrame("DrawMessage");
DrawMessage m = new DrawMessage();
m.setBackground(Color.WHITE);
m.setFont(new Font("TimeRoman", Font.PLAIN, 16));
    frame.getContentPane().add(m);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }

  /** Paint the message */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.drawString("Welcome to Java!", 40, 40);
  }
}