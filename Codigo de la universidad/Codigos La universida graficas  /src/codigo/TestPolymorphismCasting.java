// TestPolymorphismCasting.java: Demonstrate casting objects
package chapter8;

import chapter6.Circle;

public class TestPolymorphismCasting {
  /** Main method */
  public static void main(String[] args) {
    // Declare and initialize two geometric objects
    Object object1 = new Circle(5);
    Object object2 = new Cylinder(5, 3);

    // Display circle
    displayObject(object1);
    System.out.println();

    // Display cylinder
    displayObject(object2);
  }

  /** A method for displaying a geometric object */
  static void displayObject(Object object) {
    System.out.println("The toString method returns " +
        object.toString());

    if (object instanceof Cylinder) {
      System.out.println("The area is " +
        ((Cylinder)object).findArea());
      System.out.println("The volume is " +
        ((Cylinder)object).findVolume());
    }
    else if (object instanceof Circle) {
      System.out.println("The area is " +
        ((Circle)object).findArea());
    }
  }
}