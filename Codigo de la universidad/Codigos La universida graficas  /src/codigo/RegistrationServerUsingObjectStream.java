// RegistrationServerUsingObjectStream.java: The server for the
// applet responsible for writing on the server side
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class RegistrationServerUsingObjectStream extends JFrame {
  private static JTextArea jtaLog;

  // The file to store the records
  private static RandomAccessFile raf = null;

  /** Main method */
  public static void main(String[] args) {
    RegistrationServerUsingObjectStream server =
      new RegistrationServerUsingObjectStream();
  }

  public RegistrationServerUsingObjectStream() {
    // Create a scroll pane to hold text area
    JScrollPane scrollPane = new JScrollPane(
      jtaLog = new JTextArea());

    // Add the scroll pane to the frame
    getContentPane().add(scrollPane, BorderLayout.CENTER);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setTitle("Registration Server Using Object Streams");
    setVisible(true);

    // Open the local file on the server side
    try {
      // Open the file if the file exists, create a new file
      // if the file does not exist
      raf = new RandomAccessFile("student.dat", "rw");
    }
    catch(IOException ex) {
      jtaLog.append(new Date() + ": Error: " + ex);
      System.exit(0);
    }

    // Establish server socket
    try {
      // Create a server socket
      ServerSocket serverSocket = new ServerSocket(8000);
      jtaLog.append(new Date() + ": Start a new server\n");

      // Count the number of threads started
      int count = 1;

      while (true) {
        // Connect to a client
        Socket socket = serverSocket.accept();
        jtaLog.append(new Date() + ": A client at " +
          socket.getInetAddress().getHostAddress() + " connected\n");

        // Start a new thread to register a client
        new RegistrationThread(socket, count++).start();
      }
    }
    catch (IOException ex) {
      jtaLog.append(new Date() + ": " + ex);
    }
  }

  /** Write student information to the file */
  private synchronized static void writeToFile(Student student) {
    try {
      // Append it to "student.dat"
      raf.seek(raf.length());
      student.writeStudent(raf);

      // Display data saved
      jtaLog.append("The following info is saved in the file\n");
      jtaLog.append(student.toString());
    }
    catch (Exception ex) {
      jtaLog.append(new Date() + ": " + ex);
    }
  }

  /** Define a thread to process the client registration */
  class RegistrationThread extends Thread {
    // The socket to serve a client
    private Socket socket;

    private int clientNo; // The thread number

    // Object input stream to get input from the client
    private ObjectInputStream in;

    // Create a registration thread
    public RegistrationThread(Socket socket, int clientNo) {
      this.socket = socket;
      this.clientNo = clientNo;

      jtaLog.append(new Date() + ": Thread " + clientNo
        + " started\n");

      // Create an input stream to receive data from a client
      try {
        in = new ObjectInputStream(socket.getInputStream());
      }
      catch(IOException ex) {
        jtaLog.append(new Date() + ": " + ex);
      }
    }

    public void run() {
      try {
        // Receive data from the client
        Student student = (Student)in.readObject();

        writeToFile(student);
      }
      catch (Exception ex) {
        System.out.println(ex);
      }
    }
  }
}