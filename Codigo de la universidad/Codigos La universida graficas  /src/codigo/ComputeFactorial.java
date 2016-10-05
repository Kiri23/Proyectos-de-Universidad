// ComputeFactorial.java: Compute factorial of an integer
package chapter4;

import javax.swing.JOptionPane;

public class ComputeFactorial {
  /** Main method */
  public static void main(String[] args) {
    // Prompt the user to enter an integer
    String intString = JOptionPane.showInputDialog(null,
      "Please enter a non-negative integer:",
      "Example 4.8 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string into integer
    int n = Integer.parseInt(intString);

    // Display factorial
    JOptionPane.showMessageDialog(null,
      "Factorial of " + n + " is " + factorial(n),
      "Example 4.8 Output", JOptionPane.INFORMATION_MESSAGE);
  }

  /** Return the Fibonacci number for a specified index */
  static long factorial(int n) {
    if (n == 0) // Stopping condition
      return 1;
    else
      return n * factorial(n - 1); // Call factorial recursively
  }
}