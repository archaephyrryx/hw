// Peter Duchovni
// Period 9
// Homework 22
// November 6, 2013


public class Slots {
  private static final String[] FRUITS = { "orange", "orange", "orange", 
					   "lime", "lime", "lime", 
					   "lemon", "lemon", "lemon", 
					   "peach", "peach", "peach"};
  private String[] _fruits;


  public Slots() {
    _fruits = new String[FRUITS.length]; // allocate, initialize _fruits
    for (int i = 0; i < FRUITS.length; ++i)
      _fruits[i] = FRUITS[i]; //Copy every element over from FRUITS
  }


  public String toString() {
    return (_fruits[0] + "\t" + _fruits[1] + "\t" + _fruits[2]);
  }


  private void swap( int i, int j ) {
    String iCopy = _fruits[i]; // Save copies
    String jCopy = _fruits[j]; // of each element
    _fruits[i] = jCopy; // Swap values
    _fruits[j] = iCopy; // of each element
  }


  public void spinOnce() {
    for (int modulus = 0; modulus < 3; ++modulus) { // Which column
      for (int i = 0; i < 4; ++i) { // Loop through elements
        int replace = (int) (Math.random() * (4 - i)); // Pick one
	swap( 3*i + modulus, 3*(i + replace) + modulus ); /* Swap it with itself or with one of its successors,
	                                                     with equal probability; same odds for each landing in place 1,
							     etc. */
      }
    }
  }


  public boolean FTW() {
    return (_fruits[0].equals( _fruits[1]) && _fruits[0].equals(_fruits[2])); /* Strings, not primitives,
                                                                                 so .equals() is vital */
  }


  public static void main( String[] args ) {
    Slots james;
    james = new Slots(); // Step 1: Init
 
    boolean won = false; /* Sitting down at a slot machine displaying a winning
			    combo does not give you a jackpot, unless the person
			    playing went to the lavatory before the wheels
			    stopped spinning */

  /* If money were involved, he might not keep going... */
    while (!won) {
      System.out.println("Spin...");
      james.spinOnce(); // Step 2: Spin it
      won = james.FTW();
      System.out.println(james);
    }

    System.out.println("Win!"); // Step 3: Win it
    System.out.println(james);
  } // Step 4: Finit
}
