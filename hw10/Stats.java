// Peter Duchovni
// Homework 10
// Period 9
// October 5, 2013

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
}
