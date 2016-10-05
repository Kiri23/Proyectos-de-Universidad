// BinarySearch.java: Search a key in a sorted list
package chapter5;

import javax.swing.JOptionPane;

public class BinarySearch {
  /** Main method */
  public static void main(String[] args) {
    int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    // Declare and initialize output string
    String output = "The list is ";
    for (int i = 0; i < list.length; i++)
      output += list[i] + " ";

    // Prompt the user to enter a key
    String keyString = JOptionPane.showInputDialog(null,
      output + "\nEnter a key:",
      "Example 5.12 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string into integer
    int key = Integer.parseInt(keyString);

    // Display the result
    JOptionPane.showMessageDialog(null,
      "Index is " + binarySearch(list, key),
      "Example 5.12 Output", JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }

  /** Use binary search to find the key in the list */
  public static int binarySearch(int[] list, int key) {
    int low = 0;
    int high = list.length - 1;
    return binarySearch(list, key, low, high);
  }

  /** Use binary search to find the key in the list between
      list[low] list[high] */
  public static int binarySearch(int[] list, int key,
    int low, int high) {
    if (low > high)  // The list has been exhausted without a match
      return -low - 1;

    int mid = (low + high) / 2;
    if (key < list[mid])
      return binarySearch(list, key, low, mid - 1);
    else if (key == list[mid])
      return mid;
    else
      return binarySearch(list, key, mid + 1, high);
  }
}