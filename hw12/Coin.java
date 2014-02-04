// Peter Duchovni
// HW 12
// Period 9
// 2013-10-09

import java.math.*;
import java.text.*;

public class Coin {
  public String upFace;
  public String name;
  public BigDecimal value;
  private int flipCtr;
  private int headsCtr;
  private int tailsCtr;
  private double bias;

  // Coins are quarters unless otherwise specified
  public Coin() {
    this("quarter", "heads");
  }

  // Coins are heads-up unless otherwise specified
  public Coin( String newname ) {
    this(newname, "heads");
  } 

  // new coins have not been flipped, and have no bias
  public Coin( String newname, String newface ) {
    name = newname;
    assignValue();
    upFace = newface;
    flipCtr = 0;
    headsCtr = 0;
    tailsCtr = 0;
    bias = 0.5;
  }

  /* Looks kind of crazy, but I was going for the least number of lines of code
   * that would accomplish the goal. What it does is flip a virtual coin and
   * calculate whether it is heads or tails based on the result and the bias. A
   * bias of 1.0 is always heads, and a bias of 0.0 is always tails. After
   * saving the correct string to the faceUp instance var, it compares that
   * freshly assigned faceUp side against heads, and increments both the
   * flipcounter and the appropriate side-counter by 1. De-obfuscated in-line*/
  public String flip() {
    flipCtr = (
               (upFace = 
	               (Math.random() < bias) // if a random number is less than bias
	                                      ? "heads" : "tails") // upface = heads, else upface = tails
		== "heads") // if upface is heads
		? tailsCtr + (++headsCtr) // flipCtr becomes tails + incremented heads
		: (++tailsCtr) + headsCtr; // else heads + incremented tails

    /* I had to make it two lines. I know this isn't an obfuscated coding class,
       but variety is the spice of life, and this is probably unique */
    return upFace;
  }


  // Coming from the above mutator, I bet this is a breath of fresh air
  public String toString() {
    return name + " -- " + upFace;
  }

  // Not much I could obfuscate here...
  public boolean equals(Coin other) {
    return (other.upFace == upFace);
  }

  private void assignValue() {
  /* We haven't learned this yet, have we? It would be a shame not to use it
     though... */
    switch (name) {
      case "dollar":
        value = new BigDecimal("1.00");
	break;
      case "quarter":
        value = new BigDecimal("0.25");
	break;
      case "dime":
        value = new BigDecimal("0.10");
	break;
      case "nickle":
        value = new BigDecimal("0.05");
	break;
      case "penny":
        value = new BigDecimal("0.01");
	break;
    }
  }
}
