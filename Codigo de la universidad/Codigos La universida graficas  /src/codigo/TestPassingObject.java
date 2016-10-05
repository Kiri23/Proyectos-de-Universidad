// TestPassingObject.java: Demonstrate passing objects to methods
package chapter6;

public class TestPassingObject {
  /** Main method */
  public static void main(String[] args) {
    // Create a Circle object with default radius 1
    Circle myCircle = new Circle();

    // Print areas for radius 1, 2, 3, 4, and 5.
    int n = 5;
    printAreas(myCircle, n);

    // See myCircle.radius and times
    System.out.println("\n" + "Radius is " + myCircle.getRadius());
    System.out.println("n is " + n);
  }

  /** Print a table of areas for radius */
  public static void printAreas(Circle c, int times) {
    System.out.println("Radius \t\tArea");
    while (times >= 1) {
      System.out.println(c.getRadius() + "\t\t" + c.findArea());
      c.setRadius(c.getRadius() + 1);
      times--;
    }
  }
}