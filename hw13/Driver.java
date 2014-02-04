// Peter Duchovni
// Homework 13
// Period 9
// 2013-10-10

/* Care to gamble? */
public class Driver {
  public static void main( String[] args ) {
    /* One thousand dollars, a quarter at a time. */
    int rounds = 0;
    double potmax = 0.00;

    /* You can mess around with biases and values to get interesting cases */
    
    /* completely fair: equal odds */
    Coin coinOne = new Coin("quarter", "heads", 0.5);
    Coin coinTwo = new Coin("quarter", "tails", 0.5);

    /* opposite bias: tie */
    /* Coin coinOne = new Coin("quarter", "heads", 1.0);
       Coin coinTwo = new Coin("quarter", "tails", 0.0); */

    /* unequal value: player two will win more often */
    /* Coin coinOne = new Coin("quarter", "heads", 0.5);
       Coin coinTwo = new Coin("dime", "tails", 0.5 ); */

    /* Accounts */
    BankAccount bankOne = new BankAccount("Peter", "mine", 1234, 123456789, 1000.00);
    BankAccount bankTwo = new BankAccount("Mr. Brown", "yours", 4321, 987654321, 1000.00);

    /* Pot */
    BankAccount pot = new BankAccount("Pot", "pot", 1221, 123454321, 0.00);

    /* Print initial values */
    System.out.println( bankOne );
    System.out.println( bankTwo );
    System.out.println( pot );

    /* To the victor go the spoils */
    while (true) {
      if (!bankOne.canWithdraw(coinOne) && !bankTwo.canWithdraw(coinTwo)) {
        /* If neither can play, says so and exits */
        System.out.println("Neither player can withdraw any money.\n");
	break;
      } else if (!bankOne.canWithdraw(coinOne)) {
        /* If one can't play, two wins */
        System.out.println(bankOne.getName() + " has lost.\n");
	bankTwo.deposit(pot.getBalance());
	pot.setAccountBalance(0.00);
	break;
      } else if (!bankTwo.canWithdraw(coinTwo)) {
        /* If two can't play, one wins */
        System.out.println(bankTwo.getName() + " has lost.\n");
	bankOne.deposit(pot.getBalance());
	pot.setAccountBalance(0.00);
	break;
      }

      bankOne.withdraw(coinOne);
      bankTwo.withdraw(coinTwo);

      coinOne.flip();
      coinTwo.flip();

      /* Put them in the pot first, then give pot to winner, if one exists */
      pot.deposit(coinOne);
      pot.deposit(coinTwo);

      if (coinOne.equals( coinTwo )) {
	if (coinOne.upFace.equals("heads")) {
	  bankOne.deposit(pot.getBalance());
	  pot.setAccountBalance(0.00);
	} else if (coinOne.upFace.equals("tails")) {
	  bankTwo.deposit(pot.getBalance());
	  pot.setAccountBalance(0.00);
	}
      }
      
      rounds++;
      potmax = (pot.getBalance() >= potmax) ? pot.getBalance() : potmax;
    }
    
    System.out.println("Number of rounds: " + rounds + "\n");
    System.out.println("Largest amount in pot: " + potmax + "\n");

    System.out.println( bankOne );
    System.out.println( bankTwo );
    System.out.println( pot );
  }
}
