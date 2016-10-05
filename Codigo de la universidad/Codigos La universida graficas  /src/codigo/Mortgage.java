// Mortgage.java: Encapsulate mortgage information
public class Mortgage {
  private double annualInterestRate;
  private int numOfYears;
  private double loanAmount;

  /** Default constructor */
  public Mortgage() {
    this(7.5, 30, 100000);
  }

  /** Construct a mortgage with specified annual interest rate,
      number of years and loan amount
    */
  public Mortgage(double annualInterestRate, int numOfYears,
    double loanAmount) {
    this.annualInterestRate = annualInterestRate;
    this.numOfYears = numOfYears;
    this.loanAmount = loanAmount;
  }

  /** Return annualInterestRate */
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  /** Set a new annualInterestRate */
  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  /** Return numOfYears */
  public int getNumOfYears() {
    return numOfYears;
  }

  /** Set a new numOfYears */
  public void setNumOfYears(int numOfYears) {
    this.numOfYears = numOfYears;
  }

  /** Return loanAmount */
  public double getLoanAmount() {
    return loanAmount;
  }

  /** Set a newloanAmount */
  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  /** Find monthly payment */
  public double monthlyPayment() {
    double monthlyInterestRate = annualInterestRate / 1200;
    return loanAmount * monthlyInterestRate / (1 - 
      (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
  }

  /** Find total payment */
  public double totalPayment() {
    return monthlyPayment() * numOfYears * 12;
  }
}