import java.util.*;

public class Fibonacci {
    protected ArrayList<Integer> known_fibs;

    public Fibonacci() {
	known_fibs = new ArrayList<Integer>();
	known_fibs.add(Integer.valueOf(1));
	known_fibs.add(Integer.valueOf(1));
    }


    public static int fibonacci( int n ) {
	if (n == 0 || n == 1) {
	    return 1;
	} else {
	    return (fibonacci(n-1) + fibonacci(n-2));
	}
    }

    public static int tibonacci( int n ) {
	return fibonacci_tail( n, 0, 1, 0 );
    }

    public static int fibonacci_tail( int n, int i, int j, int k ) {
	if (i == n)
	    return j;
	else
	    return fibonacci_tail( n, i+1, j+k, j);
    }

    public static int fibonacci_iter( int n ) {
	int j = 1;
	int k = 0;
	for (int i = 0; i < n; i++, j+=k, k=j-k) { continue; }
	return j;
    }

    public int libonacci( int n ) {
	int last = known_fibs.size() - 1;
	if (last >= n) {
	    return known_fibs.get(n).intValue();
	} else {
	    int penultimate = known_fibs.get(last - 1).intValue();
	    int ultimate = known_fibs.get(last).intValue();
	    int next = penultimate + ultimate;
	    known_fibs.add(Integer.valueOf(next));
	    return libonacci(n);
	}
    }


    public static void main( String[] args ) {
	Fibonacci f = new Fibonacci();
	System.out.println( Fibonacci.fibonacci(30) );
	System.out.println( Fibonacci.fibonacci_iter(30) );
	System.out.println( Fibonacci.tibonacci(30) );
	System.out.println( f.libonacci(30) );
	System.out.println( f.known_fibs );
    }
}
