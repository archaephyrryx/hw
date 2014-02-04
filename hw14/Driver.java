public class Driver {
  public static void main( String[] args ) {
    Stats palindrome;
    palindrome = new Stats();
    
    System.out.println("gcd of 121 and 1331: " + palindrome.gcd(121,1331));
    System.out.println("gcd of 97 and 101: " + palindrome.gcd(97,101));
    System.out.println("gcd of 2 and 13: " + palindrome.gcd(2,13));
  }
}
