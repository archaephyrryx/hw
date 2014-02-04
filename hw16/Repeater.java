// Peter Duchovni
// Period 9
// Homework 16
// October 21, 2013

public class Repeater {
  // TI Fighter:  |-o-| 
  public static String fenceF(int posts) {
    int i;
    String fence = "";

    for (i = 0; i < posts; ++i) {
      fence += (i == 0) ? "|" : "--|"; // paranoid users can use >fence += "|";<
    }

    return fence;
  }

  // One-liner
  public static String fenceR(int posts) {
    return ((posts == 1) ? "|" : fenceR(posts - 1) + "--|");
  }

  public static String reverseF(String s) {
    int i;
    String reverse = ""; 

    for (i = s.length(); i > 0; i--) {
      reverse += s.substring(i-1,i);
    }
    
    return reverse;
  }

  // Returning an expression seems to work...
  public static String reverseR(String s) {
    return ((s.length() == 0) ? s : reverseR(s.substring(1)) + s.substring(0,1));
  }

  public static void main( String[] args ) {
    Repeater echo;
    echo = new Repeater();

    System.out.println(echo.fenceF(13)); // Fencing Team
    System.out.println(echo.fenceR(13)); // Fencing Team
    System.out.println(echo.reverseF("no evil repaid")); // Diaper live on!
    System.out.println(echo.reverseR("no evil repaid"));
  }
}
