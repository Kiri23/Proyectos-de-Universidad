// RegistrationClientUsingObjectStream.java: The applet client for
// gathering student informationthe and passing it to the server
import java.io.*;
import java.net.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class RegistrationClientUsingObjectStream extends JApplet
  implements ActionListener {
  // Button for registering a student in the file
  private JButton jbtRegister = new JButton("Register");

  // Create student information panel
  private StudentPanel studentPanel = new StudentPanel();

  // Indicate if it runs as application
  private boolean isStandAlone = false;

  // Host name or ip
  String host = "localhost";

  public void init() {
    // Add the student panel and button to the applet
    getContentPane().add(studentPanel, BorderLayout.CENTER);
    getContentPane().add(jbtRegister, BorderLayout.SOUTH);

    // Register listener
    jbtRegister.addActionListener(this);

    // Find the IP address of the Web server
    if (!isStandAlone)
      host = getCodeBase().getHost();
  }

  /** Handle button action */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtRegister) {
      try {
        // Establish connection with the server
        Socket socket = new Socket(host, 8000);

        // Create an output stream to the server
        ObjectOutputStream toServer =
          new ObjectOutputStream(socket.getOutputStream());

        // Get text field
        Student s = studentPanel.getStudent();

        // Get data from text fields and send it to the server
        toServer.writeObject(s);
      }
      catch (IOException ex) {
        System.err.println(ex);
      }
    }
  }

  /** Run the applet as an application */
  public static void main(String[] args) {
    // Create a frame
    JFrame frame = new JFrame("Register Student Client");

    // Create an instance of the applet
    RegistrationClientUsingObjectStream applet =
      new RegistrationClientUsingObjectStream();
    applet.isStandAlone = true;

    // Get host
    if (args.length == 1) applet.host = args[0];

    // Add the applet instance to the frame
    frame.getContentPane().add(applet, BorderLayout.CENTER);

    // Invoke init() and start()
    applet.init();
    applet.start();

    // Display the frame
    frame.pack();
    frame.setVisible(true);
  }
}