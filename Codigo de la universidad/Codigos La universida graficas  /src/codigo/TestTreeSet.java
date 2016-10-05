import java.util.*;

public class TestTreeSet {
  public static void main(String[] args) {
    // Create a hash set
    Set set = new HashSet();
    
    // Text in a string
    String text = "Have a good day. Have a good class. " + 
      "Have a good visit. Have fun!";

    // Extract words from text
    StringTokenizer st = new StringTokenizer(text, " .!?");
    while (st.hasMoreTokens()) 
      set.add(st.nextToken());

    TreeSet treeSet = new TreeSet(set);
    System.out.println(treeSet);
    
    // Obtain an iterator for the hash set
    Iterator iterator = treeSet.iterator();

    // Display the elements in the hash set
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
  }
}