package chapter6;

import javax.swing.JFrame;

class TestFrame {
  public static void main(String[] args) {
    JFrame frame1 = new JFrame();
    frame1.setTitle("Window 1");
    frame1.setSize(200, 150);
    frame1.setLocation(200, 100);
    frame1.setVisible(true);

    JFrame frame2 = new JFrame();
    frame2.setTitle("Window 2");
    frame2.setSize(200, 150);
    frame2.setLocation(410, 100);
    frame2.setVisible(true);
  }
}