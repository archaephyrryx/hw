public class Fibonacci {
    public static int fibonacci( int n ) {
	if (n == 0 || n == 1) {
	    return 1;
	} else {
	    return (fibonacci(n-1) + fibonacci(n-2));
	}
    }

    public static int tibonacci( int n ) {
	return fibonacci_tail( n, 0, 0, 0 );
    }

    // n: index of the fibonacci number to be found
    // i: index of the fibonacci number j
    // j: a fibonacci number
    // k: the fibonacci number before j
    public static int fibonacci_tail( int n, int i, int j, int k ) {
	if (i == n) {
	    if (j == 0) {
		return 1;
	    } else {
		return j;
	    }
	} else {
	    if (j == 0 || j == 1) {
		return fibonacci_tail( n, i+1, 1+k, 1);
	    } else {
		return fibonacci_tail( n, i+1, j+k, j);
	    }
	}
    }

    public static int fibonacci_iter( int n ) {
	int j = 1;
	int k = 0;
	for (int i = 0; i < n; i++, j+=k, k=j-k) { continue; }
	return j;
    }


    public static void main( String[] args ) {

	System.out.println( Fibonacci.fibonacci(30) );
	System.out.println( Fibonacci.fibonacci_iter(30) );
	System.out.println( Fibonacci.tibonacci(30) );
    }
}
