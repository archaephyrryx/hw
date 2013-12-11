// Peter Duchovni
// Period 9
// Homework 33
// November 26, 2013

public class BinSearch {
    
    public static int binSearch ( int[] a, int target ) {
        if (isSorted(a))
	    //return binSearchRec( a, target, 0, a.length-1 );
            return binSearchIter( a, target, 0, a.length-1 );
	return -1;
    }
    
    public static int binSearchRec( int[] a, int target, int lo, int hi ) {
        int guess = (lo + hi)/2;
        
        if (a[guess] == target) // Found it!
            return guess;
	if (lo >= hi) // Not in array
	  return -1;
	if (a[guess] > target)
	    return binSearchRec(a, target, guess + 1, hi); // raise floor
	if (a[guess] < target)
	    return binSearchRec(a, target, lo, guess - 1); // lower ceiling
	return -1; // for compiler's amusement
    }
    
    
    public static int binSearchIter( int[] a, int target, int lo, int hi ) {
        int guess;

        while (true) {
            guess = (lo + hi)/2;
            
            if (a[guess] == target) { // found it!
                return guess;
            } else {
	        if (lo >= hi) // not in array
                    break;
                if (a[guess] > target)
                    lo = guess + 1; // raise floor
                else if (a[guess] < target)
                    hi = guess - 1; // lower ceiling
                continue;
            }
        }
        return -1; // for compiler's amusement
    }
    
    
    private static boolean isSorted( int[] arr ) {
        boolean sorted = true;
        int last = arr[0];    
        
        
        for (int elem : arr) {
            sorted = sorted && (elem >= last);
            last = elem;
        }
        return sorted;
    }
    
    
    private static void printArray( int[] arr ) {
        String output = "[ ";
        
        for( int i : arr )
            output += i + ", ";
        
        output = output.substring( 0, output.length()-2 ) + " ]";
        
        System.out.println( output );
    }
    
    
    public static void main ( String[] args ) {

         System.out.println("\nNow testing binSearch on int array...");
         
         int[] iArr = { 2, 4, 6, 8, 6, 42 };
         printArray( iArr );
         System.out.println( "sorted? -- " + isSorted(iArr) );
         System.out.println( binSearch(iArr,6) );
         System.out.println( binSearch(iArr,43) );
         
         int[] iArr2 = { 2, 4, 6, 8, 13, 42 };
         printArray( iArr2 );
         System.out.println( "sorted? -- " + isSorted(iArr2) );
         System.out.println( binSearch(iArr2,6) );
         System.out.println( binSearch(iArr2,43) );
    }
}
