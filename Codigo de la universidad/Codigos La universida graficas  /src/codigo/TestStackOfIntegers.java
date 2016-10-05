package chapter6;

public class TestStackOfIntegers {
  public static void main(String[] args) {
    final int LIMIT = 120;
    int count = 0;
    StackOfIntegers stack = new StackOfIntegers();

    // Repeatedly find prime numbers
    for (int number = 2; number < LIMIT; number++)
      if (isPrime(number)) {
        stack.push(number);
        count++; // Increase the prime number count
      }

    // Print the first 30 prime numbers in decreasing order
    System.out.println("The prime numbers less than 120 are \n");
    final int NUMBER_PER_LINE = 10;

    while (!stack.empty()) {
      System.out.print(stack.pop() + " ");

      if (stack.getSize() % NUMBER_PER_LINE == 0)
        System.out.println(); // advance to the new line
    }
  }

  public static boolean isPrime(int number) {
    // Assume the number is prime
    boolean isPrime = true;

    // Test if number is prime
    for (int divisor = 2; divisor <= number / 2; divisor++) {
      //If true, the number is not prime
      if (number % divisor == 0) {
        // Set isPrime to false, if the number is not prime
        isPrime = false;
        break; // Exit the for loop
      }
    }

    return isPrime;
  }
}

class StackOfIntegers {
  private int[] elements;
  private int size;

  /** Default constructor */
  public StackOfIntegers() {
    this(16);
  }

  /** Construct a stack with the specified maximum capacity */
  public StackOfIntegers(int capacity) {
    elements = new int[capacity];
  }

  /** Push a new integer into the top of the stack */
  public int push(int element) {
    if (size >= elements.length) {
      int[] temp = new int[elements.length * 2];
      System.arraycopy(elements, 0, temp, 0, elements.length);
      elements = temp;
    }

    return elements[size++] = element;
  }

  /** Return and remove the top element from the stack */
  public int pop() {
    return elements[--size];
  }

  /** Return the top element from the stack */
  public int peek() {
    return elements[size - 1];
  }

  /** Test whether the stack is empty */
  public boolean empty() {
    return size == 0;
  }

  /** Return the number of elements in the stack */
  public int getSize() {
    return size;
  }
}