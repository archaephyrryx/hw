// Peter Duchovni
// Period 9
// Homework 31
// November 23, 2013

public class Searching {
    public static int frequency( int[] a, int target )
    {
	int freq = 0;

	for (int i : a) 
	    if (i == target)
		++freq;

	return freq;
    }

    public static int linSearch( int[] a, int target )
    {
	int tPos = -1;
	int i;

	for (i = 0; i < a.length; ++i) { // Changed while to for
	    if ( a[i] == target ) {
		tPos = i;
		break;
	    }
	}
	return tPos;
    }


    public static int linSearch ( String[] a, String target )
    {
	int tPos = -1;
	int i;

	for (i = 0; i < a.length; ++i) { // Changed while to for
	    if ( a[i].equals(target) ) {
		tPos = i;
		break;
	    }
	}
	return tPos;
    }

    public static int linSearch ( Binary[] a, Binary target )
    {
	int tPos = -1;
	int i;

	for (i = 0; i < a.length; ++i) { // Changed while to for
	    if ( a[i].equals(target) ) {
		tPos = i;
		break;
	    }
	}
	return tPos;
    }

    public static int linSearch ( Hexadecimal[] a, Hexadecimal target )
    {
	int tPos = -1;
	int i;

	for (i = 0; i < a.length; ++i) { // Changed while to for
	    if ( a[i].equals(target) ) {
		tPos = i;
		break;
	    }
	}
	return tPos;
    }

    public static int linSearch(Comparable[] a, Comparable target)
    {
	int tPos = -1;
	int i;

	for (i = 0; i < a.length; ++i) { // Changed while to for
	    if ( a[i].equals(target) ) {
		tPos = i;
		break;
	    }
	}
	return tPos;
    }

    private static void printArray( int[] arr )
    {
	String output = "[ "; 
	for( int i : arr )
	    output += i + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";
	System.out.println( output );
    }

    private static void printArray( Object[] arr )
    {
	String output = "[ "; 

	for( Object o : arr )
	    output += o + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";

	System.out.println( output );
    }

    public static void main ( String[] args ) {
	System.out.println("\nNow testing linSearch on int array...");

	int[] iArr = { 2, 4, 6, 8, 6, 42 };

	printArray( iArr );
	System.out.println( linSearch(iArr,6) );
	System.out.println( linSearch(iArr,43) );


	System.out.println("\nNow testing linSearch on String array...");

	String[] y = { "kiwi", "watermelon", "orange", "apple", 
		       "peach", "watermelon" };

	printArray( y );
	System.out.println( linSearch(y,"watermelon") );
	System.out.println( linSearch(y,"lychee") );


	System.out.println("\nNow testing linSearch on Binary array...");

	Binary[] bArr = new Binary[10];

	printArray( bArr );
	//Q: Why would a FOREACH loop not do the job here?
	//A: Foreach would alter COPIES of elements, leave array unchanged
	for( int i = 0; i < bArr.length; i++ )
	    bArr[i] = new Binary( (int)(100 * Math.random()) );

	printArray( bArr );
	System.out.println( "Searching for " + bArr[3] + "..." );
	System.out.println( linSearch(bArr, bArr[3] ) );
	System.out.println( linSearch(bArr, new Binary(5) ) );
	System.out.println( linSearch(bArr, new Binary(256)) );


	System.out.println("\nNow testing linSearch on Hexadecimal array...");

	Hexadecimal[] hArr = new Hexadecimal[10];

	printArray( hArr ); //should show array of nulls
	for( int i = 0; i < hArr.length; i++ )
	    hArr[i] = new Hexadecimal( (int)(100 * Math.random()) );

	printArray( hArr );
	System.out.println( "Searching for " + hArr[3] + "..." );
	System.out.println( linSearch(hArr, hArr[3] ) );
	System.out.println( linSearch(hArr, new Hexadecimal(5) ) );
	System.out.println( linSearch(hArr, new Hexadecimal(256)) );


	System.out.println("\nNow testing linSearch on Comparable array...");

	Comparable[] cArr = new Hexadecimal[10];

	printArray( cArr );
	for( int i = 0; i < cArr.length; i++ )
	    cArr[i] = new Hexadecimal( (int)(100 * Math.random()) );

	printArray( cArr );
	System.out.println( "Searching for " + cArr[3] + "..." );
	System.out.println( linSearch(cArr, cArr[3] ) );
	System.out.println( linSearch(cArr, (Comparable)( new Hexadecimal(5)) ) );
	System.out.println( linSearch(cArr, (Comparable) (new Hexadecimal(256))) );
    }
}
