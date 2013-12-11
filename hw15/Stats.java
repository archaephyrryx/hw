// Peter Duchovni
// Homework 13
// Period 9
// October 13, 2013

public class Stats {
// floored arithmetic mean
  public static int mean(int a, int b) {
    return (a + b)/2;
  }

// floored arithmetic mean
  public static int mean(int a, int b, int c) {
    return (a + b + c)/3;
  }

// proper arithmetic mean
  public static double mean(double a, double b) {
    return (a + b)/2;
  }

// proper arithmetic mean
  public static double mean(double a, double b, double c) {
    return (a + b + c)/3;
  }

// max of two ints
  public static int max(int a, int b) {
    return (a >= b) ? a : b;
  }

// min of two ints
  public static int min(int a, int b) {
    return (a >= b) ? b : a;
  }

// max of two doubles
  public static double max(double a, double b) {
    return (a >= b) ? a : b;
  }

// max of three doubles: calls the two-var max on max of first two and third
  public static double max(double a, double b, double c) {
    return (a>=b) ? max(a,c) : max(b,c);
  }
  
// geometric mean of two doubles
  public static double geoMean(double a, double b) {
    return Math.exp(mean(Math.log(a), Math.log(b)));
  }

// floored geometric mean of two integers
  public static int geoMean(int a, int b) {
    return (int) Math.exp(mean(Math.log(a), Math.log(b)));
  }

// geometric mean of three doubles
  public static double geoMean(double a, double b, double c) {
    return Math.exp(mean(Math.log(a), Math.log(b), Math.log(c)));
  }

// floored geometric mean of three integers
  public static int geoMean(int a, int b, int c) {
    return (int) Math.exp(mean(Math.log(a), Math.log(b), Math.log(c)));
  }

// brute-force gcd
  public static int gcd( int a, int b ) {
    int i;
    int gcd = 1;

    for (i = 1; i <= min(a,b); ++i )
      if (a % i == 0 && b % i == 0)
        gcd = i;

    return gcd;
  }

// iterative euclidean algorithm
  public static int gcdew( int a, int b ) {
    int max = max(a,b);
    int min = min(a,b);

    while (min != 0) {
      int newmax = min;
      int newmin = max % min;
      max = newmax;
      min = newmin;
    }
    return max;
  }
// recursive euclidean algorithm
  public static int gcder( int a, int b ) {
    if (a * b == 0)
      return a + b;
    return gcder((a % b), (b % a));
  }
}
