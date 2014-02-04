// Peter Duchovni
// Period 9
// Homework 6
// 2013-09-28

// BigDecimal is in here.
import java.math.*;

// Driver function for testing. Gave it an appropriate name.
public class Teller{
  public static void main( String[] args ) {
    BankAccount mafia;
    mafia = new BankAccount();

// Medvedev is russian for bear, vova is short for vladimir. This is a reference to a russian poem
    mafia.setName("Vova 'The Bear' Medvedev");
// Russian for "fiddlesticks"
    mafia.setPassword("yolkipolki");
// Year Ivan the Terrible died
    mafia.setPIN(1584);

    BigDecimal balance;
// 600 million rubles in USD, as of the time I wrote it
    balance = new BigDecimal("18555180.00");

    BigDecimal depositamt;
// The global financial crisis hit the Russian Mafia hard, evidently
    depositamt = new BigDecimal("1.00");

    BigDecimal withdrawalamt;
// They want to get 10 better computers
    withdrawalamt = new BigDecimal("0.50");

// RGB value for red
    mafia.setAccountNumber(256000000);
    mafia.setAccountBalance(balance);

    mafia.printInfo();

    mafia.deposit(depositamt);
    mafia.printInfo();

    mafia.withdraw(withdrawalamt);
    mafia.printInfo();
  }
}
