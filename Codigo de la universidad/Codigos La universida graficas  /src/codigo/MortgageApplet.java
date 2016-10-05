// MortgageApplet.java: Applet for computing mortgage payments
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MortgageApplet extends JApplet
  implements ActionListener {
  // Declare and create text fields for interest rate
  // year, loan amount, monthly payment, and total payment
  private JTextField jtfAnnualInterestRate = new JTextField();
  private JTextField jtfNumOfYears = new JTextField();
  private JTextField jtfLoanAmount = new JTextField();
  private JTextField jtfMonthlyPayment = new JTextField();
  private JTextField jtfTotalPayment = new JTextField();

  // Declare and create a Compute Mortgage button
  private JButton jbtComputeMortgage = new JButton("Compute Mortgage");

  /** Initialize user interface */
  public void init() {
    // Set properties on the text fields
    jtfMonthlyPayment.setEditable(false);
    jtfTotalPayment.setEditable(false);

    // Right align text fields
    jtfAnnualInterestRate.setHorizontalAlignment(JTextField.RIGHT);
    jtfNumOfYears.setHorizontalAlignment(JTextField.RIGHT);
    jtfLoanAmount.setHorizontalAlignment(JTextField.RIGHT);
    jtfMonthlyPayment.setHorizontalAlignment(JTextField.RIGHT);
    jtfTotalPayment.setHorizontalAlignment(JTextField.RIGHT);

    // Panel p1 to hold labels and text fields
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(5, 2));
    p1.add(new Label("Annual Interest Rate"));
    p1.add(jtfAnnualInterestRate);
    p1.add(new Label("Number of Years"));
    p1.add(jtfNumOfYears);
    p1.add(new Label("Loan Amount"));
    p1.add(jtfLoanAmount);
    p1.add(new Label("Monthly Payment"));
    p1.add(jtfMonthlyPayment);
    p1.add(new Label("Total Payment"));
    p1.add(jtfTotalPayment);
    p1.setBorder(new
      TitledBorder("Enter interest rate, year and loan amount"));

    // Panel p2 to hold the button
    JPanel p2 = new JPanel();
    p2.setLayout(new FlowLayout(FlowLayout.RIGHT));
    p2.add(jbtComputeMortgage);

    // Add the components to the applet
    getContentPane().add(p1, BorderLayout.CENTER);
    getContentPane().add(p2, BorderLayout.SOUTH);

    // Register listener
    jbtComputeMortgage.addActionListener(this);
  }

  /** Handle the "Compute Mortgage" button */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtComputeMortgage) {
      // Get values from text fields
      double interest = (Double.valueOf(
        jtfAnnualInterestRate.getText())).doubleValue();
      int year =
        (Integer.valueOf(jtfNumOfYears.getText())).intValue();
      double loan =
        (Double.valueOf(jtfLoanAmount.getText())).doubleValue();

      // Create a mortgage object
      Mortgage m = new Mortgage(interest, year, loan);

      // Display monthly payment and total payment
      jtfMonthlyPayment.setText(String.valueOf(m.monthlyPayment()));
      jtfTotalPayment.setText(String.valueOf(m.totalPayment()));
    }
  }
}