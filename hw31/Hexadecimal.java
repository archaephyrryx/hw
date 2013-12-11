// Peter Duchovni
// Period 9
// HW 30
// November 21, 2013

public class Hexadecimal implements Comparable {
    private int _decNum;
    private String _hexNum;

    public Hexadecimal() { 
	_decNum = 0;
	_hexNum = "0";
    }

    public Hexadecimal( int n ) {
	this();
	if (n >= 0) {
	    _decNum = n;
	    _hexNum = decToHex(n);
	}
    }


    public String toString() { 
        String ret = + _decNum + "|";
	ret += "0x" + _hexNum;
	return ret;
    }


    public static String decToHex( int n ) {
        String hexNum = "";
	int m;

	for (; n > 0; n /= 16) {
	    m = (n % 16); 

	    if (m <= 9) {
		hexNum = m + hexNum;
	    } else {
		hexNum = ((char) (55 + m)) + hexNum; // 55 + 10 = 65 is ASCII for 'A'
	    }
	}
	return (hexNum.length() > 0) ? hexNum : "0";
    }


    public static String decToHexR( int n ) { 
        int m = 0;

	return (n == 0) ? "" // Empty for 0
			: decToHexR( n/16 ) + (((m = (n%16)) < 10) ? m // numerical case
				                                 : ((char) (55 + m))); // alphabetic case
    }


    public boolean equals( Object other ) { 
        return ( this == other || ( other instanceof Hexadecimal &&
				    ((Hexadecimal)other)._decNum == this._decNum &&
				    ((Hexadecimal)other)._hexNum.equals(this._hexNum) )  );
	                                           // has to be .equals, as they are strings
    }


    public int compareTo( Object other ) {
	if (other instanceof Hexadecimal) {
	    int odec = ((Hexadecimal)other)._decNum;

	    return (odec < this._decNum) ?  1 :
	           (odec > this._decNum) ? -1 : 0;
	}

	return ((int) ('E'+'R'+'R'+'O'+'R')); // Why not?
    }


    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal h1 = new Hexadecimal(10);
	Hexadecimal h2 = new Hexadecimal(10);
	Hexadecimal h3 = h1;
	Hexadecimal h4 = new Hexadecimal(20);

	System.out.println( h1 );
	System.out.println( h2 );
	System.out.println( h3 );       
	System.out.println( h4 );       

	// Here be Ye Olde Friendly Top-Comment-Bar.
	//    Move it down as you incrementally develop & test...
	System.out.println( "\n==..." );
	System.out.println( h1 == h2 ); //should be false
	System.out.println( h1 == h3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( h1.equals(h2) ); //should be true
	System.out.println( h1.equals(h3) ); //should be true
	System.out.println( h3.equals(h1) ); //should be true
	System.out.println( h4.equals(h2) ); //should be false
	System.out.println( h1.equals(h4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( h1.compareTo(h2) ); //should be 0
	System.out.println( h1.compareTo(h3) ); //should be 0
	System.out.println( h1.compareTo(h4) ); //should be neg
	System.out.println( h4.compareTo(h1) ); //should be pos
    }//end main()

} //end class
