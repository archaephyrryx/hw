// Peter Duchovni
// Period 9
// Homework 18
// October 26, 2013

public class Pig {

  private static final String VOWELS = "aeoiu"; // and sometimes y

  public static boolean hasA(String w, String letter) {
    if (w.equals("")) { return false; }
    return ( w.substring(0,1).equals(letter) ||
             hasA(w.substring(1), letter) );
  }

  public static boolean isAVowel(String letter) {
    return hasA(VOWELS, letter);
  }

  public static int countVowels(String w) {
    int i;
    int count = 0;

    for (i = 0; i < w.length(); ++i) {
      if (isAVowel(w.substring(i, i+1))) {
        ++count; // One vowel, ah ah ah...
      }
    }
    return count;
  }

  public static boolean hasAVowel(String w) {
    return (countVowels(w) > 0); // Baa baa, String w, have you any vowels?
  }

  public static String allVowels(String w) {
    int i;
    String vowels = "";

    for (i = 0; i < w.length(); ++i) {
      if (isAVowel(w.substring(i, i+1))) {
        vowels += w.substring(i,i+1);
      }
    }
    return vowels;
  }

  public static String firstVowel( String w ) {
    int i;

    /* allVowels(String w).substring(0,1) would be extreme folly. */
    for (i = 0; i < w.length(); ++i) {
      if (isAVowel(w.substring(i, i+1))) {
        return w.substring(i,i+1);
      }
    }
    return "";
  }

  public static boolean beginsWithVowel( String w ) {
    return (!(w.equals("")) && isAVowel(w.substring(0,1))); /* "empty string"
    may begin with a vowel, but "the empty string" does not. */
  }

  public static String engToPig( String w ) {
    String append = "";
    
    if (beginsWithVowel(w)) {
      append = "w";
    } else {
      while (!beginsWithVowel(w) && w.length() > 0) { 
        append += w.substring(0,1); /*  order  */
        w = w.substring(1);         /* matters */
      }
    }
    return w+"-"+append+"ay"; /* engToPig("hello") -> "w-appenday" */
  }

  public static void main( String[] args ) {
    for (String w : args) {
      System.out.println( engToPig(w) );
    }
  }
}
