// Peter Duchovni
// Period 9
// HW 17
// October 22, 2013


public class Commas {
  public static String commafyR(int n) {
    return ((n == 0) ? "" /* If it is zero, return empty string */
                     : ((n >= 1000) ? commafyR(n/1000) + "," + /* if it is greater than 1000,
		                                                  return the commafied head plus
							          the last three digits, separated
							          by a comma */
//
				      ((n % 1000 == 0) ? "000" /* If it is 0 mod 1000,
				                                  we want 000 instead of 0 */
				                       : (n%1000))
		                    : "" + n)); /* if it is less than 1000, we
				    just output all of the  digits. */
  }

  public static String commafyF(int n) {
    String accomadation = "";

    // prepend comma for greater than 1000, empty string otherwise, to the last
    // three digits (000 in cases where it is 0 mod 1000) of the number,
    // prepended to the running string. Every iteration, it is divided through
    // by 1000, truncating it by three digits, until it reaches zero.
    for ( ; n > 0; n /= 1000) {
      accomadation = ((n >= 1000) ? ",":"") + ((n >= 1000 && n % 1000 == 0) ? "000" : (n%1000)) + accomadation;
    }
    return accomadation;
  }

  // Tests
  public static void main( String[] args ) {
    System.out.println(commafyR(10000000));
    System.out.println(commafyF(10000000));
  }

}
