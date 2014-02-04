// Peter Duchovni
// Period 9
// Homework 34
// December 1, 2013

public class BinSearch2 {
    
    public static int binSearch ( Comparable[] a, Comparable target ) {
        if (isSorted(a))
	    //return binSearchRec( a, target, 0, a.length-1 );
            return binSearchIter( a, target, 0, a.length-1 );
	return -1;
    }
    
    public static int binSearchRec( Comparable[] a, Comparable target, int lo, int hi ) {
        int guess = (lo + hi)/2;
        
        if (a[guess].equals(target))
            return guess;
	if (lo >= hi)
	  return -1;
	if (a[guess].compareTo(target) > 0)
	    return binSearchRec(a, target, guess + 1, hi);
	else if (a[guess].compareTo(target) < 0)
	    return binSearchRec(a, target, lo, guess - 1);
        return -1;
    }
    
    
    public static int binSearchIter( Comparable[] a, Comparable target, int lo, int hi ) {
        int guess;

        while (true) {
            guess = (lo + hi)/2;
            
            if (a[guess].equals(target)) {
                return guess;
            } else {
	        if (lo >= hi)
                    break;
		if (a[guess].compareTo(target) > 0)
                    lo = guess + 1;
		else if (a[guess].compareTo(target) < 0)
                    hi = guess - 1;
                continue;
            }
        }
        return -1;
    }
    
    
    private static boolean isSorted( Comparable[] arr ) {
        boolean sorted = true;
        Comparable last = arr[0];    
        
        for (Comparable elem : arr) {
	    if (!sorted) {
	        break;
            }
            sorted = sorted && (elem.compareTo(last) >= 0);
            last = elem;
        }
        return sorted;
    }
    
    
    private static void printArray( Comparable[] arr ) {
        String output = "[ ";
        
        for( Comparable i : arr )
            output += i + ", ";
        
        output = output.substring( 0, output.length()-2 ) + " ]";
        
        System.out.println( output );
    }
}
