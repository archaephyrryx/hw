public class Foo {

    public static int factorial( int n ) {
	if (n == 0) {
	    return 1;
	} else {
	    return n*factorial(n-1);
	}
    }

    public static int tactorial( int n ) {
	return factorial_tail( n, 1 );
    }

    public static int factorial_tail( int n, int stack ) {
	if (n == 0) {
	    return stack;
	} else {
	    return factorial_tail( n - 1, n*stack );
	}
    }

    public static void main( String[] args ) {
	System.out.println( Foo.factorial(6)   );
	System.out.println( Foo.tactorial(6) );
    }
}
