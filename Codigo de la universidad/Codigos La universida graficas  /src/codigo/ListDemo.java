// ListDemo.java: Use list to select a country and display the
// selected country's flag
package chapter13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListDemo extends JFrame
  implements ListSelectionListener {
  final int NUMBER_OF_FLAGS = 9;

  // Declare an array of Strings for flag titles
  private String[] flagTitle = {"Canada", "China", "Denmark",
    "France", "Germany", "India", "Norway", "United Kingdom",
    "United States of America"};

  // The list for selecting countries
  private JList jlst = new JList(flagTitle);

  // Declare an ImageIcon array for the national flags of 9 countries
  private ImageIcon[] imageIcons = {
    new ImageIcon("image/ca.gif"),
    new ImageIcon("image/china.gif"),
    new ImageIcon("image/denmark.gif"),
    new ImageIcon("image/fr.gif"),
    new ImageIcon("image/germany.gif"),
    new ImageIcon("image/india.gif"),
    new ImageIcon("image/norway.gif"),
    new ImageIcon("image/uk.gif"),
    new ImageIcon("image/us.gif")
  };

  // Arrays of labels for displaying images
  private JLabel[] jlblImageViewer = new JLabel[NUMBER_OF_FLAGS];

  /** Main Method */
  public static void main(String[] args) {
    ListDemo frame = new ListDemo();
    frame.setSize(650, 500);
    frame.setTitle("List Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  /** Default Constructor */
  public ListDemo() {
    // Create a panel to hold nine labels
    JPanel p = new JPanel();
    p.setLayout(new GridLayout(3, 3, 5, 5));

    for (int i = 0; i < NUMBER_OF_FLAGS; i++) {
      p.add(jlblImageViewer[i] = new JLabel());
      jlblImageViewer[i].setHorizontalAlignment
        (SwingConstants.CENTER);
    }

    // Add p and the list to the frame
    getContentPane().add(p, BorderLayout.CENTER);
    getContentPane().add(new JScrollPane(jlst), BorderLayout.WEST);

    // Register listeners
    jlst.addListSelectionListener(this);
  }

  /** Handle list selection */
  public void valueChanged(ListSelectionEvent e) {
    // Get selected indices
    int[] indices = jlst.getSelectedIndices();

    int i;
    // Set icons in the labels
    for (i = 0; i < indices.length; i++) {
      jlblImageViewer[i].setIcon(imageIcons[indices[i]]);
    }

    // Remove icons from the rest of the labels
    for ( ; i < NUMBER_OF_FLAGS; i++) {
      jlblImageViewer[i].setIcon(null);
    }
  }
}