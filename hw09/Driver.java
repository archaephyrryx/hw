public class Driver {
  public static void main( String[] args ) {
    Stats palindrome;
    palindrome = new Stats();

    System.out.println("Mean of 1 and 3: " + palindrome.mean(1,3));
    System.out.println("Mean of 1 and 2: " + palindrome.mean(1,2));
    System.out.println("Mean of 1.0 and 3.0: " + palindrome.mean(1.0,3.0));
    System.out.println("Mean of 1.0 and 2.0: " + palindrome.mean(1.0,2.0));
    System.out.println("Max of 1 and 3: " + palindrome.max(1,3));
    System.out.println("Max of -1 and -3: " + palindrome.max(-1,-3));
    System.out.println("Max of 1.0 and 3.0: " + palindrome.max(1.0,3.0));
    System.out.println("Max of -1.0 and -3.0: " + palindrome.max(-1.0,-3.0));
    System.out.println("Geometric mean of 1 and 2: " + palindrome.geoMean(1,3));
    System.out.println("Geometric mean of 1 and -2: " + palindrome.geoMean(1,-2));
    System.out.println("Geometric mean of 1 and 4: " + palindrome.geoMean(1,4));
    System.out.println("Geometric mean of 1.0 and 3.0: " + palindrome.geoMean(1.0,3.0));
    System.out.println("Geometric mean of 1.0 and -3.0: " + palindrome.geoMean(1.0,-3.0));
    System.out.println("Geometric mean of 1.0 and 4.0: " + palindrome.geoMean(1.0,4.0));
  }
}
