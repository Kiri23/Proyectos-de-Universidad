// LinearSearch.java: Search for a number in a list
package chapter5;

import javax.swing.JOptionPane;

public class LinearSearch {
  /** Main method */
  public static void main(String[] args) {
    int[] list = new int[10];

    // Declare and initialize output string
    String output = "The list is ";

    // Create the list randomly and display it
    for (int i = 0; i < list.length; i++) {
      list[i] = (int)(Math.random() * 100);
      output += list[i] + "  ";
    }

    // Prompt the user to enter a key
    String keyString = JOptionPane.showInputDialog(null,
      output + "\nEnter a key:",
      "Example 5.11 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string into integer
    int key = Integer.parseInt(keyString);

    // Search for key
    int index = linearSearch(list, key);
    if (index != -1)
      output = "The key " + key + " is found in index " + index;
    else
      output = "The key " + key + " is not found in the list";

    // Display the result
    JOptionPane.showMessageDialog(null, output,
      "Example 5.11 Output", JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }

  /** The method for finding a key in the list */
  public static int linearSearch(int[] list, int key) {
    for (int i = 0; i < list.length; i++)
      if (key == list[i])
        return i;
    return -1;
  }
}