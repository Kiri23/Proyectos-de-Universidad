// GenericLinkedList.java
package chapter10;

public class GenericLinkedList {
  private Node first, last;
  private int count = 0; // The number of elements in the list

  public GenericLinkedList() {
  }

  /** Return the first element in the list */
  public Object getFirst() {
    if (count == 0) return null;
    else return first.element;
  }

  /** Return the last element in the list */
  public Object getLast() {
    if (count == 0) return null;
    else return last.element;
  }

  /** Add an element to the beginning of the list */
  public void addFirst(Object element) {
    Node newNode = new Node(element);
    newNode.next = first;
    first = newNode;
    count++;

    if (last == null)
      last = first;
  }

  /** Add an element to the end of the list */
  public void addLast(Object element) {
    if (last == null) {
      first = last = new Node(element);
    }
    else {
      last.next = new Node(element);
      last = last.next;
    }

    count++;
  }

  /** Add an element at the specified index.
   * The index of the first element is 0.
   */
  public void add(int index, Object element) {
    if (index == 0) addFirst(element);
    else if (index >= count) addLast(element);
    else {
      Node current = first;
      for (int i = 1; i < index; i++)
        current = current.next;
      Node temp = current.next;
      current.next = new Node(element);
      (current.next).next = temp;
      count++;
    }
  }

  /** Remove the first node */
  public boolean removeFirst() {
    if (count == 0) return false;
    else {
      first = first.next;
      count--;
      return true;
    }
  }

  /** Remove the last node */
  public boolean removeLast() {
    if (count == 0) return false;
    else {
      Node current = first;

      for (int i = 0; i < count - 2; i++) {
        current = current.next;
      }

      last = current;
      last.next = null;
      count--;
      return true;
    }
  }

  /** Remove the first node that contains the specified element
    * Return true if the element is removed
    * Return false if no element is removed
    */
  public boolean remove(Object element) {
    Node previous = first;
    Node current;

    if (first != null) {
      if (element.equals(first.element)) {
        first = first.next;
        count--;
        return true;
      }
      else {
        current = first.next;
      }
    }
    else
      return false;

    for (int i = 0; i < count - 1; i++) {
      if (element.equals(current.element)) {
        previous.next = current.next; // Remove the current element
        count--;
        return true;
      }
      else {
        previous = current;
        current = current.next;
      }
    }

    return false;
  }

  /** Remove the node at the specified index.
   * The index of the first element is 0.
   * Return true if the element is removed
   * Return false if no element is removed
   */
  public boolean remove(int index) {
    if ((index < 0) || (index >= count)) return false;
    else if (index == 0) return removeFirst();
    else if (index == count - 1) return removeLast();
    else {
      Node current = first;

      for (int i = 1; i < index; i++) {
        current = current.next;
      }

      current.next = current.next.next;
      count--;
      return true;
    }
  }

  /** Return the number of elements in the list */
  public int getCount() {
    return count;
  }

  /** Override toString() to return elements in the list */
  public String toString() {
    StringBuffer result = new StringBuffer("[");

    Node current = first;
    for (int i = 0; i < count; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null)
        result.append(", "); // Seperate two elements with a comma
      else
        result.append("]"); // Insert the closing ] in the string
    }

    return result.toString();
  }
}