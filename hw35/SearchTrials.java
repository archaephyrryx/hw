// Peter Duchovni
// Period 9
// Homework 35
// November 29, 2013

/*=================================================================//

    Results:

    Time in nanoseconds (and milliseconds) for each type of search:

    Binary search for number in list: 099734 ns (0.0997 ms)
    Linear search for number in list: 993422 ns (0.9934 ms)

    Binary search for number not in list: 0034223 ns (0.0342 ms)
    Linear search for number not in list: 1057466 ns (1.0575 ms)

//=================================================================*/

public class SearchTrials {
    
    public static int binSearch ( Comparable[] a, Comparable target ) {
	return binSearchIter( a, target, 0, a.length-1 ); // List should be sorted
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

    public static int binSearchIter( Comparable[] a, Comparable target, int lo, int hi ) {
	int guess;

	while (lo <= hi) {
	    guess = (lo + hi)/2;

	    if (a[guess].equals(target))
		return guess;
	    if (a[guess].compareTo(target) > 0)
                lo = guess + 1;
	    if (a[guess].compareTo(target) < 0)
		hi = guess - 1;
	}
        return -1;
    }
    
    
    private static void printArray( int[] arr ) {
        String output = "[ ";
        
        for( int i : arr )
            output += i + ", ";
        
        output = output.substring( 0, output.length()-2 ) + " ]";
        
        System.out.println( output );
    }
    
    
    public static void main ( String[] args ) {
	 // Start and end for each search
         long inbinstart;
         long inbinend;

         long notinbinstart;
         long notinbinend;

         long inlinstart;
         long inlinend;

         long notinlinstart;
         long notinlinend;

         /* Building array of first 1000 even numbers */
         Comparable cArr[] = new Comparable[1000];
         for (int i = 0; i < cArr.length; ++i) {
	     cArr[i] = (Comparable) (2 * i);
	 }

         /* Random Targets */
	 Comparable intarget = (Comparable) (((int) (Math.random() * 1000)) * 2);
	 Comparable notintarget = (Comparable) (((int) (Math.random() * 1000)) * 2 + 1);

         /* Trials */
	 inbinstart = System.nanoTime();
         binSearch(cArr,intarget);
	 inbinend = System.nanoTime();

	 notinbinstart = System.nanoTime();
         binSearch(cArr,notintarget);
	 notinbinend = System.nanoTime();

	 inlinstart = System.nanoTime();
         linSearch(cArr,intarget);
	 inlinend = System.nanoTime();

	 notinlinstart = System.nanoTime();
         linSearch(cArr,notintarget);
	 notinlinend = System.nanoTime();

         /* Print at end so as not to skew timing results by timing prints as well */
	 System.out.printf("Binary in: %d\n", (inbinend - inbinstart));
	 System.out.printf("Binary notin: %d\n", (notinbinend - notinbinstart));
	 System.out.printf("Linear in: %d\n", (inlinend - inlinstart));
	 System.out.printf("Linear notin: %d\n", (notinlinend - notinlinstart));
    }
}
