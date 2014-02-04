// Peter Duchovni, Dennis Nenov, Nicholas Romanoff
// Period 9
// Homework 19
// October 28, 2013

public class Pig {
  private static final String VOWELS = "aeoiu";

  public static boolean hasA(String w, String letter) {
    return (!(w.equals("")) && ( w.substring(0,1).equals(letter) ||
                            hasA(w.substring(1), letter))); /* If not empty,
			    test first letter, and the rest */
  }

  public static boolean isAVowel(String letter) {
    return hasA(VOWELS, letter); /* Is it found in the string of vowels */
  }

  public static int countVowels(String w) {
    int i;
    int count = 0;

    for (i = 0; i < w.length(); ++i) {
      if (isAVowel(w.substring(i, i+1))) {
        ++count; /* add 1 for every vowel found */
      }
    }
    return count;
  }

  public static boolean hasAVowel(String w) {
    return (countVowels(w) > 0); /* is the number of vowels greater than 0 */
  }

  public static String allVowels(String w) {
    int i;
    String vowels = "";

    for (i = 0; i < w.length(); ++i) {
      if (isAVowel(w.substring(i, i+1))) {
        vowels += w.substring(i,i+1); /* adds each vowel to a String */
      }
    }
    return vowels;
  }

  public static String firstVowel( String w ) {
    int i;

    for (i = 0; i < w.length(); ++i) {
      if (isAVowel(w.substring(i, i+1))) {
        return w.substring(i,i+1); /* returns the first vowel it finds */
      }
    }
    return "";
  }

  public static boolean beginsWithVowel( String w ) {
    return ( !(w.equals("")) && /* not empty, AND */
            (isAVowel(w.substring(0,1)) || /* is a vowel */
	     (w.substring(0,1).equals("y") && /* OR is a y that is */
	      !(beginsWithVowel( w.substring(1)))))); /* followed by a consonant */
  }

  public static String engToPig( String w ) {
    w = w.toLowerCase();
    String append  = (beginsWithVowel(w)) ? "w" : "";
    
    while ( w.length() > 0 && !beginsWithVowel(w) ) { 
      append += w.substring(0,1); /* add first letter to append string */
      w = w.substring(1); /* cut first letter off */
    }

    append += "ay"; /* add suffix */

    if (hasA(",.?!;:-", w.substring(w.length() - 1))) {
      append += w.substring(w.length() - 1); /* add trailing punctuation to end */
      w = w.substring(0, w.length() - 1); /* remove trailing punctuation */
    }

    w += append; /* append appropriate suffix */

    return w.substring(0,1).toUpperCase() + w.substring(1); /* Capitalize first letter */
  }

  public static void main( String[] args ) {
    for (String w : args) {
      System.out.println( engToPig(w) ); /* translate all args */
    }
  }
}
