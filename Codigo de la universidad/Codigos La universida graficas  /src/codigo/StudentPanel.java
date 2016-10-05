// StudentPanel.java: Panel for displaying student information
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class StudentPanel extends JPanel {
  JTextField jtfName = new JTextField(32);
  JTextField jtfStreet = new JTextField(32);
  JTextField jtfCity = new JTextField(20);
  JTextField jtfState = new JTextField(2);
  JTextField jtfZip = new JTextField(5);

  /** Construct a student panel */
  public StudentPanel() {
    // Set the panel with line border
    setBorder(new BevelBorder(BevelBorder.RAISED));

    // Panel p1 for holding labels Name, Street, and City
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(3, 1));
    p1.add(new JLabel("Name"));
    p1.add(new JLabel("Street"));
    p1.add(new JLabel("City"));

    // Panel jpState for holding state
    JPanel jpState = new JPanel();
    jpState.setLayout(new BorderLayout());
    jpState.add(new JLabel("State"), BorderLayout.WEST);
    jpState.add(jtfState, BorderLayout.CENTER);

    // Panel jpZip for holding zip
    JPanel jpZip = new JPanel();
    jpZip.setLayout(new BorderLayout());
    jpZip.add(new JLabel("Zip"), BorderLayout.WEST);
    jpZip.add(jtfZip, BorderLayout.CENTER);

    // Panel p2 for holding jpState and jpZip
    JPanel p2 = new JPanel();
    p2.setLayout(new BorderLayout());
    p2.add(jpState, BorderLayout.WEST);
    p2.add(jpZip, BorderLayout.CENTER);

    // Panel p3 for holding jtfCity and p2
    JPanel p3 = new JPanel();
    p3.setLayout(new BorderLayout());
    p3.add(jtfCity, BorderLayout.CENTER);
    p3.add(p2, BorderLayout.EAST);

    // Panel p4 for holding jtfName, jtfStreet, and p3
    JPanel p4 = new JPanel();
    p4.setLayout(new GridLayout(3, 1));
    p4.add(jtfName);
    p4.add(jtfStreet);
    p4.add(p3);

    // Place p1 and p4 into StudentPanel
    setLayout(new BorderLayout());
    add(p1, BorderLayout.WEST);
    add(p4, BorderLayout.CENTER);
  }

  /** Get student information from the text fields */
  public Student getStudent() {
    return new Student(jtfName.getText().trim(),
                       jtfStreet.getText().trim(),
                       jtfCity.getText().trim(),
                       jtfState.getText().trim(),
                       jtfZip.getText().trim());
  }

  /** Set student information on the text fields */
  public void setStudent(Student s) {
    jtfName.setText(s.getName());
    jtfStreet.setText(s.getStreet());
    jtfCity.setText(s.getCity());
    jtfState.setText(s.getState());
    jtfZip.setText(s.getZip());
  }
}