// Borrower.java: Encapsulate borrower information
package chapter10;

import chapter6.Loan;

public class Borrower extends Person {
  private Loan loan;

  /** Default constructor */
  public Borrower() {
    super();
  }

  /** Create a borrower with specified name and address */
  public Borrower(Name name, Address address) {
    super(name, address);
  }

  /** Return loan */
  public Loan getLoan() {
    return loan;
  }

  /** Set a new loan */
  public void setLoan(Loan loan) {
    this.loan = loan;
  }

  /** String representation for borrower */
  public String toString() {
    return super.toString() +
      "Monthly payment is " + loan.monthlyPayment() + '\n' +
      "Total payment is " + loan.totalPayment();
  }
}