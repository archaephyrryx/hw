// Peter Duchovni
// Period 9
// Homework 13
// 2013-10-10

public class BankAccount{
  private String accountName;
  private String accountPassword;
  private int accountPIN;
  private int accountNumber;
  private double accountBalance;

  // default constructor
  public BankAccount() {
    setName("Mr. X");
    setPassword("default");
    setPIN(8888);
    setAccountNumber(888888888);
    setAccountBalance(0.00);
  }  

  // overloaded constructor
  public BankAccount(String name, String password, int pin, int number, double balance) {
    this();
    setName(name);
    setPassword(password);
    setPIN(pin);
    setAccountNumber(number);
    setAccountBalance(balance);
  }

  // sets account name   
  public String setName( String name ) {
    String old = accountName;
    accountName = name;
    return(old);
  }

  // sets account password
  public String setPassword( String password ) {
    String old = accountPassword;
    accountPassword = password;
    return(old);
  }

  // sets account pin
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

  // sets account number
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

  // sets account balance. If negative, returns false
  public boolean setAccountBalance( double balance ) {
    if (balance >= 0) {
      accountBalance = balance;
      return true;
    }
    return false;
  }

  // deposits coin by calling deposit on coin value
  public boolean deposit( Coin mint ) {
    return deposit(mint.value);
  }

  // deposits positive amount
  public boolean deposit( double amount ) {
    if (amount >= 0.00) {
      accountBalance += amount;
      return true;
    }
    return false;
  }

  // withdraws coin by calling withdraw on coin value
  public boolean withdraw( Coin mint ) {
    return withdraw(mint.value); 
  }

  // withdraws positive amount less than total balance
  public boolean withdraw( double amount ) {
    if (amount >= 0.00 && accountBalance >= amount) {
      accountBalance -= amount;
      return true;
    }
    return false;
  }

  // Returns boolean based on whether the coin's value can be withdrawn
  public boolean canWithdraw( Coin mint ) {
    return canWithdraw(mint.value);
  }

  // Returns boolean based on whether indicated value can be withdrawn
  public boolean canWithdraw( double amount ) {
    if (amount >= 0.00 && accountBalance >= amount) {
      return true;
    }
    return false;
  }
      
  // accessor method for balance
  public double getBalance() {
    return accountBalance;
  }
      
  // accessor method for name
  public String getName() {
    return accountName;
  }

  // overloaded toString() method
  public String toString() {
    String retstring = "";
    retstring += "Name: " + accountName + "\n";
    retstring += "Password: " + accountPassword + "\n";
    retstring += "PIN: " + accountPIN + "\n";
    retstring += "Account Number: " + accountNumber + "\n";
    retstring += "Balance: $" + accountBalance + "\n";
    return retstring;
  }
}
