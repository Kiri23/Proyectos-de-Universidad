// TestSum.java: Compute sum = 0.01 + 0.02 + … + 1;
package chapter3;

import javax.swing.JOptionPane;

public class TestSum {
  /** Main method */
  public strictfp static void main(String[] args) {
    // Initialize sum
    float sum = 0;

    // Add 0.01, 0.02, 0.03, ..., 1.0 to sum
    for (float i = 0.01f; i <= 1.0f; i = i + 0.01f)
      sum += i;

    // Display result
    JOptionPane.showMessageDialog(null, "The sum is " + sum,
      "Example 3.3 Output", JOptionPane.INFORMATION_MESSAGE);

    System.exit(0);
  }
}