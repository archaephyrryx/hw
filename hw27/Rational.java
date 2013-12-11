public class Rational {
  private int _numerator;
  private int _denominator;

  public Rational() {
    _numerator = 0;
    _denominator = 1;
  }

  public Rational(int numerator, int denominator) {
    this();
    if (denominator != 0) {
      _numerator = numerator;
      _denominator = denominator;
    } else {
      System.out.println("Error: Denominator must be non-zero. Defaulting to 0/1");
    }
  }

  public String toString() {
    String ret = _numerator + "/" + _denominator;
    return ret;
  }

  public double floatValue() {
    double quotient = 1;

    quotient *= _numerator;
    quotient /= _denominator;

    return quotient;
  }

  public void multiply(Rational other) {
    _numerator *= other._numerator; 
    _denominator *= other._denominator; 
  }

  public void divide(Rational other) {
    _numerator *= other._denominator; 
    _denominator *= other._numerator; 
  }

  public static int sgcd( int a, int b ) {
    if (a * b == 0)
      return a + b;
    return sgcd((a % b), (b % a));
  }

  public void add(Rational other) {
    int lcd = (other._denominator * _denominator)/sgcd(other._denominator,_denominator); 

    _numerator *= lcd / _denominator;
    _numerator += (other._numerator * lcd / other._denominator); 

    _denominator = lcd;
  }

  public void subtract(Rational other) {
    int lcd = (other._denominator * _denominator)/sgcd(other._denominator,_denominator); 

    _numerator *= lcd / _denominator;
    _numerator -= (other._numerator * lcd / other._denominator); 

    _denominator = lcd;
  }

  public int gcd() {
    return sgcd(_numerator, _denominator);
  }

  public void reduce() {
    int ndgcd = gcd(); 
    
    _numerator /= ndgcd;
    _denominator /= ndgcd;
  }

  public int compareTo(Rational other) {
    double me = floatValue();
    double them = other.floatValue();

    return (me > them) ?  1 :
           (me < them) ? -1 : 0;
  }
}
