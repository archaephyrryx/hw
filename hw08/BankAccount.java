// Peter Duchovni (singleton)
// Period 9
// Homework 8
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

  public BankAccount() {
// calls the 
    this("Mr. X", "default", 8888, 888888888, (new BigDecimal("0.00")));
  }  

  public BankAccount(String name, String password, int pin, int number, BigDecimal balance) {
    setName(name);
    setPassword(password);
    setPIN(pin);
    setAccountNumber(number);
    setAccountBalance(balance);
  }

  public String setName( String name ) {
    String old = accountName;
    accountName = name;
    return(old);
  }
  public String setPassword( String password ) {
    String old = accountPassword;
    accountPassword = password;
    return(old);
  }
  public int setPIN( int pin ) {
    int old = accountPIN;
    if (pin < 1000 || pin > 9998) {
      accountPIN = 9999;
      System.out.println("Invalid value for PIN. Enter int from 1000-9998");
    } else {
      accountPIN = pin;
    }
    return old;
  }
  public int setAccountNumber( int number ) {
    int old = accountNumber;
    if (number < 100000000 || number > 999999998) {
      accountNumber = 999999999;
      System.out.println("Invalid value for account number. Enter int from 100000000-999999998");
    } else {
      accountNumber = number;
    }
    return old;
  }

  public boolean setAccountBalance( BigDecimal balance ) {
    if (balance.signum() != 0) {
      accountBalance = balance;
      return true;
    }
    return false;
  }

  public boolean deposit( BigDecimal amount ) {
// if the sign of the amount is positive
    if (amount.signum() != -1) {
// BigDoubles are immutable, have add method
      accountBalance = accountBalance.add(amount);
      return true;
    }
    return false;
  }
  public boolean withdraw( BigDecimal amount ) {
// if the sign of the amount is positive, and less than the account balance
    if (amount.signum() == 1 && amount.compareTo(accountBalance) == -1) {
      accountBalance = accountBalance.subtract(amount);
      return true;
    } else {
      return false;
    }
  }

  public boolean authenticate(String name, String password) {
    return (name == accountName && password == accountPassword);
  }

  public String toString() {
    String retstring = "";
    
    retstring += "Name: " + accountName + "\n";
    retstring += "Password: " + accountPassword + "\n";
    retstring += "PIN: " + accountPIN + "\n";
    retstring += "Account Number: " + accountNumber + "\n";
    retstring += "Balance: $" + accountBalance + "\n";


    return retstring;
  }
  
  public static void main( String[] args ) {
    BankAccount johnsmith;
    johnsmith = new BankAccount();
    BigDecimal balance;
    BigDecimal depositamt;
    BigDecimal withdrawalamt;

    System.out.println("Before parameters:\n" + johnsmith);

    johnsmith.setName("George Clooney"); // What else did you expect?
    johnsmith.setPassword("password"); // a VERY good password

    System.out.println("Name and Password:\n" + johnsmith);

    balance = new BigDecimal("100.00"); // George is an artist. This is his life savings
    johnsmith.setAccountBalance(balance);

    johnsmith.setPIN(0000); // George is a security expert
    johnsmith.setAccountNumber(01234567); // Clearly George is a CS Major
    System.out.println("Invalid PIN/Acct Number: \n" + johnsmith);

    johnsmith.setPIN(1234); // This one is much better than the last
    johnsmith.setAccountNumber(123456789); // Since when do banks let you pick your account number?
    System.out.println("Valid: \n" + johnsmith);

    depositamt = new BigDecimal("1.00"); // Tips from busing tables for a month
    johnsmith.deposit(depositamt);
    System.out.println("One dollar deposit: \n" + johnsmith);

    withdrawalamt = new BigDecimal("0.50"); // New gumball machine at diner
    boolean a = johnsmith.withdraw(withdrawalamt);
    System.out.println("Withdrawing 50 Cents: " + a);
    System.out.println(johnsmith);
    withdrawalamt = new BigDecimal("200.00"); // New MRI machine at diner
    boolean b = johnsmith.withdraw(withdrawalamt);
    System.out.println("Withdrawing 200 dollars: " + b);
    System.out.println(johnsmith);

    boolean c = johnsmith.authenticate("John Smith", "password"); // Even he got confused
    System.out.println("Authenticating as John Smith: " + c);
    boolean d = johnsmith.authenticate("George Clooney", "password"); 
    System.out.println("Authenticating as George Clooney: " + d);
  }
}
