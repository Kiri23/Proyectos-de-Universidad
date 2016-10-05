package chapter11;

import javax.swing.*;
import java.awt.*;

public class CenterFrame {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Centered Frame");
    frame.setSize(400, 300);

    // New since JDK 1.3 to exit the program upon closing
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Get the dimension of the screen
    Dimension screenSize =
      Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;
    int screenHeight = screenSize.height;

    // Locate the upper-left corner (x, y) of the centered frame
    int x = (screenWidth - frame.getWidth()) / 2;
    int y = (screenHeight - frame.getHeight()) / 2;

    // Set the location of the frame
    frame.setLocation(x, y);
    frame.setVisible(true);
  }
}