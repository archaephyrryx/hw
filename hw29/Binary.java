// Peter Duchovni
// Period 9
// Homework 29
// November 20, 2013

public class Binary {
    private int _decNum; // What about real numbers?
    private String _binNum;

    public Binary() { 
        _decNum = 0; // Start from square 0
	_binNum = "0";
    }

    public Binary( int n ) {
	_decNum = (n >= 0) ? n : 0;
	_binNum = decToBin(_decNum);
    }

    public String toString() { 
	String ret = "10x" + _decNum + "|"; // 0xf : f in base 0
	ret += "2x" + _binNum;
	return ret;
    }

    public static String decToBin( int n ) {
	String binNum = "";

	for (int m = n; m > 0; m /= 2) { // play it safe with m
            binNum = (m%2) + binNum;
	}
        
	return (binNum.length() > 0) ? binNum : "0"; // _ != 0
    }


    public static String decToBinR( int n ) { 
	return decToBinR(n/2) + (n%2); // Head recursion
    }


    public static void main( String[] args ) {
	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	System.out.println(b1);
	System.out.println(b2);
	System.out.println(b3);       //false b/c b1, b2 not aliases
	System.out.println(b1 == b2); //true b/c b1, b3 are aliases
	System.out.println(b1 == b3); //false, but should be true
	System.out.println(b1.equals(b2));
    }
}
