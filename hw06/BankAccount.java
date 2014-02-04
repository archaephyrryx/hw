// Peter Duchovni
// Period 9
// Homework 6
// 2013-09-28

// did some independent stuff, used BigDecimal for currency amounts.
import java.math.*;
import java.text.*;

public class BankAccount{
  private String accountName;
  private String accountPassword;
  private int accountPIN;
  private int accountNumber;
  private BigDecimal accountBalance;

  public void setName( String name ) {
    accountName = name;
  }
  public void setPassword( String password ) {
    accountPassword = password;
  }
  public void setPIN( int pin ) {
    accountPIN = pin;
  }
  public void setAccountNumber( int number ) {
    accountNumber = number;
  }
  public void setAccountBalance( BigDecimal balance ) {
    accountBalance = balance;
  }

  public void printInfo() {
    String pinString = Integer.toString(accountPIN);
    String numString = Integer.toString(accountNumber);
    // this formats the BigDouble, includes regional currency sign, return string
    String balString = NumberFormat.getCurrencyInstance().format(accountBalance);

    System.out.println("Name: " + accountName);
    System.out.println("Password: " + accountPassword);
    System.out.println("PIN: " + pinString);
    System.out.println("Account Number: " + numString);
    System.out.println("Account Balance: " + balString);
  }

  public void deposit( BigDecimal amount ) {
// if the sign of the amount is positive
    if (amount.signum() == 1) {
// BigDoubles are immutable, have add method
      accountBalance = accountBalance.add(amount);
    }
  }
  public void withdraw( BigDecimal amount ) {
// if the sign of the amount is positive, and less than the account balance
    if (amount.signum() == 1 && amount.compareTo(accountBalance) == -1) {
      accountBalance = accountBalance.subtract(amount);
    }
  }
}
