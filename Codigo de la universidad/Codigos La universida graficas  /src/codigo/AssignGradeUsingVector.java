// AssignGradeUsingVector.java: Assign grade
import java.util.*;

import java.util.*;
import javax.swing.JOptionPane;

public class AssignGradeUsingVector {
  // Main method
  public static void main(String[] args) {
    Vector scoreVector = new Vector(); // Vector to hold scores
    double best = 0; // The best score
    char grade; // The grade
    
    do {
      // Read scores and find the best score
      String scoreString = JOptionPane.showInputDialog(null,
        "Please enter a new score"  +
        "\nA negative score terminates input", "Example 19.5 Input",
        JOptionPane.QUESTION_MESSAGE);
      
      // Convert string into int
      double score = Integer.parseInt(scoreString);
      
      if (score < 0) break;
      
      // Add the score into the vector
      scoreVector.addElement(new Double(score));
      
      // Find the best score
      if (score > best)
        best = score;
    } while (true);
    
    // Prepare the output string
    String output = "There are total " + scoreVector.size() +
      " students";
    
    // Assign and display grades
    for (int i = 0; i < scoreVector.size(); i++) {
      // Retrieve an element from the vector
      Double doubleObject = (Double)(scoreVector.elementAt(i));
      
      // Get the score
      double score = doubleObject.doubleValue();
      
      if (score >= best - 10)
        grade = 'A';
      else if (score >= best - 20)
        grade = 'B';
      else if (score >= best - 30)
        grade = 'C';
      else if (score >= best - 40)
        grade = 'D';
      else
        grade = 'F';
      
      output += "\nStudent " + i + " score is " + score +
      " and grade is " + grade;
    }
    
    JOptionPane.showMessageDialog(null, output,
      "Example 19.5 Output", JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }
}