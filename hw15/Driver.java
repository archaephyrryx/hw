public class Driver {
  public static void main( String[] args ) {
    Stats palindrome;
    palindrome = new Stats();
    
    System.out.println("gcd of 121 and 1331: " + palindrome.gcd(121,1331));
    System.out.println("gcd of 121 and 1331: " + palindrome.gcder(121,1331));
    System.out.println("gcd of 121 and 1331: " + palindrome.gcdew(121,1331));
    System.out.println("gcd of 97 and 101: " + palindrome.gcd(97,101));
    System.out.println("gcd of 97 and 101: " + palindrome.gcder(97,101));
    System.out.println("gcd of 97 and 101: " + palindrome.gcdew(97,101));
    System.out.println("gcd of 2 and 13: " + palindrome.gcd(2,13));
    System.out.println("gcd of 2 and 13: " + palindrome.gcder(2,13));
    System.out.println("gcd of 2 and 13: " + palindrome.gcdew(2,13));
  }
}
