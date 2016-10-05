// TestContinue.java: Test the continue keyword
package chapter3;

public class TestContinue {
  /** Main method */
  public static void main(String[] args) {
    int sum = 0;
    int number = 0;

    while (number < 20) {
      number++;
      if (number == 10 || number == 11) continue;
      sum += number;
    }

    System.out.println("The sum is " + sum);
  }
}