// TestLinkedList.java: Test GenericLinkedList class
package chapter10;

public class TestLinkedList {
  public static void main(String[] args) {
    // Create a linked list
    GenericLinkedList list = new GenericLinkedList();

    // Add elements to the list
    list.addFirst("Tom"); // Add it to the beginning of the list
    list.addFirst("John"); // Add it to the beginning of the list
    list.addLast("George"); // Add it to the end of the list
    list.addLast("Michael"); // Add it to the end of the list
    list.add(2, "Michelle"); // Add it to the list at index 2
    list.add(5, "Samantha"); // Add it to the list at index 5
    list.add(0, "Daniel"); // Same as list.addFirst("Daniel")

    // Print the list
    System.out.println("Strings are added to the list");
    System.out.println(list);

    // Remove elements from the list
    list.remove("Daniel"); // Same as list.remove(0) in this case
    list.remove(2); // Remove the element at index 2
    list.removeLast(); // Remove the last element

    // Print the list
    System.out.println("The contents of the list after deletions");
    System.out.println(list);
  }
}