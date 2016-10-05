// PrimeNumber.java: Print first 50 prime numbers
package chapter3;

public class PrimeNumber {
  /** Main method */
  public static void main(String[] args) {
    final int NUM_OF_PRIMES = 50; // Total prime numbers to display
    final int NUM_OF_PRIMES_PER_LINE = 10; // Display 10 per line
    int count = 0; // Count the number of prime numbers
    int number = 2; // A number to be tested for primeness
    boolean isPrime = true; // Is the current number prime?

    System.out.println("The first 50 prime numbers are \n");

    // Repeatedly find prime numbers
    while (count < NUM_OF_PRIMES) {
      // Assume the number is prime
      isPrime = true;

      // Test if number is prime
      for (int divisor = 2; divisor <= number / 2; divisor++) {
        //If true, the number is not prime
        if (number % divisor == 0) {
          // Set isPrime to false, if the number is not prime
          isPrime = false;
          break; // Exit the for loop
        }
      }

      // Print the prime number and increase the count
      if (isPrime) {
        count++; // Increase the count

        if (count % NUM_OF_PRIMES_PER_LINE == 0) {
          // Print the number and advance to the new line
          System.out.println(number);
        }
        else
          System.out.print(number + " ");
      }

      // Check if the next number is prime
      number++;
    }
  }
}