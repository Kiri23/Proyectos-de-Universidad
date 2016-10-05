// BorrowMortgage.java: Demonstrate using the classes Borrower
// Name, Address, and Mortgage
import javax.swing.JOptionPane;

public class BorrowMortgage {
  /** Main method */
  public static void main(String[] args) {
    // Create one borrower
    Borrower borrower = new Borrower();

    // Enter the information for the borrower

    // 1. Enter name
    Name name = new Name();
    // Prompt the user to enter first name
    String firstName = JOptionPane.showInputDialog(null, 
      "Enter first name:", "Example 9.1 Input", 
      JOptionPane.QUESTION_MESSAGE);

    // Set first name
    name.setFirstName(firstName);

    // Prompt the user to enter mi
    String mi = JOptionPane.showInputDialog(null, 
      "Enter mi:", "Example 9.1 Input", 
      JOptionPane.QUESTION_MESSAGE);

    // Set mi
    name.setMi(mi.charAt(0));

    // Prompt the user to enter last name
    String lastName = JOptionPane.showInputDialog(null, 
      "Enter last name:", "Example 9.1 Input", 
      JOptionPane.QUESTION_MESSAGE);
      
    // Set last name
    name.setLastName(lastName);

    // 2. Enter address
    Address address = new Address();
    // Prompt the user to enter street 
    String street = JOptionPane.showInputDialog(null, 
      "Enter street:", "Example 9.1 Input", 
      JOptionPane.QUESTION_MESSAGE);

    // Set street  
    address.setStreet(street);

    // Prompt the user to enter city
    String city = JOptionPane.showInputDialog(null, 
      "Enter city:", "Example 9.1 Input", 
      JOptionPane.QUESTION_MESSAGE);

    // Set city
    address.setCity(city);

    // Prompt the user to enter state
    String state = JOptionPane.showInputDialog(null, 
      "Enter state:", "Example 9.1 Input", 
      JOptionPane.QUESTION_MESSAGE);

    // Set state
    address.setState(state);

    // Prompt the user to enter zip
    String zip = JOptionPane.showInputDialog(null, 
      "Enter zip:", "Example 9.1 Input", 
      JOptionPane.QUESTION_MESSAGE);

    // Set zip
    address.setZip(zip);

    // 3. Enter mortgage information
    Mortgage mortgage = new Mortgage();
    // Prompt the user to enter annual interest rate
    String annualInterestRateString = JOptionPane.showInputDialog(
      null, "Enter annual interest rate (i.e. 7.25):", 
      "Example 9.1 Input", JOptionPane.QUESTION_MESSAGE);
      
    // Convert string into double
    double annualInterestRate = 
      Double.parseDouble(annualInterestRateString);
    
    // Set annual interest rate
    mortgage.setAnnualInterestRate(annualInterestRate);

    // Prompt the user to enter number of years
    String numOfYearsString = JOptionPane.showInputDialog(
      null, "Enter number of years:", 
      "Example 9.1 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string into integer
    int numOfYears = Integer.parseInt(numOfYearsString);
    
    // Set number of years 
    mortgage.setNumOfYears(numOfYears);

    // Prompt the user to enter loan amount
    String loanAmountString = JOptionPane.showInputDialog(
      null, "Enter loan amount:", 
      "Example 9.1 Input", JOptionPane.QUESTION_MESSAGE);

    // Convert string into double
    double loanAmount = Double.parseDouble(loanAmountString);
    
    // Set loan amount
    mortgage.setLoanAmount(loanAmount);

    // 4. Set values to the borrower
    borrower.setName(name);
    borrower.setAddress(address);
    borrower.setMortgage(mortgage);

    // Display mortgage information
    JOptionPane.showMessageDialog(null, borrower.toString(), 
      "Example 9.1 Output", JOptionPane.INFORMATION_MESSAGE);
    
    System.exit(0);
  }
}