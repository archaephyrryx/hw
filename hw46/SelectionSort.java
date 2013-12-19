/*======================================
  class SelectionSort -- implements SelectionSort algorithm
  ======================================*/

import java.util.ArrayList;

public class SelectionSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive

    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList<Integer> populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>(size);
	
	for (int i = 0; i < size; ++i)
	    retAL.add(new Integer((int) (Math.random() * (hi - lo + 1)) + lo));

	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList<Integer> al ) {
	/* For each index of the array, the function randomly selects one of the
	 * elements in indices greater than or equal to that one, with a
	 * successive (1/i) choice for each successive index i. This is uniform
	 * by induction, as this is true for zero elements and one element, and
	 * if each of n elements have a 1/n probability of being picked, then
	 * adding one more element gives the first n elements (n/n+1)*(1/n) =
	 * 1/n+1 probability of being picked, as they are picked when the last
	 * one is not.
	 */
	for (int i = 0; i < al.size(); ++i) { // Random selection for index i
	    Integer replacement = new Integer(0); // Null declaration to satisfy compiler
	    for (int j = 0; (i + j) < al.size(); ++j) {
		if ( ((int) (Math.random() * j)) == 0) {
		    replacement = al.get(i + j);
		}
	    }
	    al.set(i, replacement);
	}
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Integer> data ) {
	/* 
	 * Loops N times, for list of size N, on each pass finding the correct
	 * element for each index, progressing from the first in ascending sort
	 * order. This will break * after n passes, or when a pass finds no out-of-place elements,
	 * which can only happen if the list is sorted.
	 */
	int mindex; // Holds index of minimum element
	int min; // 
	int jval;

	for (int index = 0; index < data.size(); ++index) { 
	    mindex = index;
	    for (int j = index; j < data.size(); ++j) {
		min = data.get(mindex).intValue(); 
		jval = data.get(j).intValue();
		if (jval < min) {
		    mindex = j;
		}
	    }
	    Integer old = data.get(index);
	    data.set(index, data.get(mindex));
	    data.set(mindex, old);

	    System.out.println(data);
	}
    }//end selectionSortV -- O(N^2)


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Integer> selectionSort( ArrayList<Integer> input ) {
	ArrayList<Integer> data = new ArrayList<Integer>(input);

	selectionSortV(data);
	return data;
    }//end selectionSort, O(N^2)

    public static void main( String [] args ) {

	ArrayList<Integer> glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	selectionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList<Integer> coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	selectionSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	/*===============for VOID methods=============
	  ============================================*/

	/*==========for AL-returning methods==========
    	ArrayList<Integer> glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList<Integer> glenSorted = selectionSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

      	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = selectionSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	System.out.println( coco );
	  ============================================*/

    }//end main

}//end class SelectionSort
