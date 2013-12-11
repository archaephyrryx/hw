// Peter Duchovni
// Homework 12
// Period 9
// 2013-10-09

import java.math.*;
import java.text.*;

public class Driver {
  public static void main( String[] args ) {
    String deposited = "another account";
    String withdrawn = "one account";
    String face = "a certain side";

    Coin myCoin = new Coin("quarter", "heads");
    BankAccount myBank = new BankAccount("Me", "mine", 1234, 123456789, (new BigDecimal("20.00")));
    Coin yourCoin = new Coin("dime", "tails");
    BankAccount yourBank = new BankAccount("You", "yours", 4321, 987654321, (new BigDecimal("20.00")));

    System.out.println( myCoin );
    System.out.println( myBank );
    System.out.println( yourCoin );
    System.out.println( yourBank );

    myCoin.flip();
    yourCoin.flip();

    if (myCoin.equals( yourCoin )) {
      if (myCoin.upFace.equals("heads")) {
	myBank.deposit(myCoin);
	yourBank.withdraw(myCoin);
	myBank.deposit(yourCoin);
	yourBank.withdraw(yourCoin);
        deposited = "myBank";
        withdrawn = "yourBank";
        face = "heads";
      } else if (myCoin.upFace.equals("tails")) {
	myBank.withdraw(myCoin);
	yourBank.deposit(myCoin);
	myBank.withdraw(yourCoin);
	yourBank.deposit(yourCoin);
        deposited = "yourBank";
        withdrawn = "myBank";
        face = "tails";
      }
      System.out.println("Because both coins landed on " + face +
                         ", the value of each coin was withdrawn from account " + withdrawn +
			 " and deposited into account " + deposited +".\n");
    } else {
      System.out.println("Because the coins landed on different sides, nothing happened." );
    }

    System.out.println( myCoin );
    System.out.println( myBank );
    System.out.println( yourCoin );
    System.out.println( yourBank );
  }
}
