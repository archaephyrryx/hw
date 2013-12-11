// Peter Duchovni
// HW 13
// Period 9
// 2013-10-10

public class Coin {
  public String upFace;
  public String name;
  public double value;
  private int flipCtr;
  private int headsCtr;
  private int tailsCtr;
  private double bias;

  // Coins are quarters unless otherwise specified
  public Coin() {
    name = "quarter";
    upFace = "heads";
    assignValue();
    flipCtr = 0;
    headsCtr = 0;
    tailsCtr = 0;
    bias = 0.5;
  }

  // Coins are heads-up unless otherwise specified
  public Coin( String newname ) {
    this();
    name = newname;
    assignValue();
  } 

  // Coins have no directional bias unless otherwise specified
  public Coin( String newname, String newface ) {
    this(newname);
    upFace = newface;
  }

  // New constructor with bias (newbias is a portmanteau of 'newb' and 'tobias')
  public Coin( String newname, String newface, double newbias ) {
    this(newname, newface);
    bias = newbias;
  }

  // Cleaned it up a bit
  public String flip() {
    upFace = (Math.random() < bias) ? "heads" : "tails";

    flipCtr++;
    headsCtr += ((upFace == "heads") ? 1 : 0);
    tailsCtr += ((upFace == "tails") ? 1 : 0);

    return upFace;
  }

  // Overloaded toString() method
  public String toString() {
    return name + " -- " + upFace;
  }

  // Comparison of two coins
  public boolean equals(Coin other) {
    return (other.upFace == upFace);
  }

  // Internal evaluator of coin value
  private void assignValue() {
    switch (name) {
      case "dollar":
        value = 1.00;
	break;
      case "quarter":
        value = 0.25;
	break;
      case "dime":
        value = 0.10;
	break;
      case "nickle":
        value = 0.05;
	break;
      case "penny":
        value = 0.01;
	break;
      default: 
        value = 0.00;
	break;
    }
  }
}
