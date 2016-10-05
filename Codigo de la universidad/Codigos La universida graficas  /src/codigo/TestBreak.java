// TestBreak.java: Test the break keyword in the loop
package chapter3;

public class TestBreak {
  /** Main method */
  public static void main(String[] args) {
    int sum = 0;
    int number = 0;

    while (number < 20) {
      number++;
      sum += number;
      if (sum >= 100) break;
    }

    System.out.println("The sum is " + sum);
  }
}