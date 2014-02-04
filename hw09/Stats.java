// Peter Duchovni
// Homework 9
// Period 9
// October 2, 2013

public class Stats {
// floored arithmetic mean
  public static int mean(int a, int b) {
    return (a + b)/2;
  }
// proper arithmetic mean
  public static double mean(double a, double b) {
    return (a + b)/2;
  }
// max of two ints
  public static int max(int a, int b) {
    return (a >= b) ? a : b;
  }
// max of two doubles
  public static double max(double a, double b) {
    return (a >= b) ? a : b;
  }
// rounded geometric mean of two integers
  public static int geoMean(int a, int b) {
    return (int) Math.round(Math.sqrt((double)a * (double)b));
  }
// geometric mean of two doubles
  public static double geoMean(double a, double b) {
    return Math.sqrt(a * b);
  }
}
