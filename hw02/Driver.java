// Peter Duchovni
// pd #9
// HW#2
// 2012-09-19
// Defines a class with one method, main, which creates a new string, greeting,
// creates an instance of the BigSib class, assigns its value to greeting, and 
// prints it to stdout

public class Driver {
  public static void main( String[] args ) {
    String greeting;
    BigSib petarr;

    petarr = new BigSib();
    greeting = petarr.greet();

    System.out.println(greeting);
  }
}