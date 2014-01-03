// Peter Duchovni
// Period 9
// HW 47
// January 2, 2013


/*
 * Q1: More work is being done towards the end, as the binary-search insertion
 * covers a larger set; at the beginning, sorting is unnecessary, as the head is
 * sorted by definition of the algorithm, while at the end, the last element
 * must be inserted into a sorted list of size N-1
 *
 * Q2: For n items, n-1 passes are necessary to sort, as one item lists require
 * 0 passes and each additional element adds one additional pass
 *
 * Q3: After pass p, it is known that the first p elements of the array are in
 * relatively sorted order, meaning that they are in ascendingly sorted
 * sequence, but that elements may be inserted between two adjacent elements in
 * the final, fully-sorted list. We know this by the definition of the algorithm
 *
 * Q4: The runtime classification of this sort is O(log(n!)), or approximately
 * O(n*log(n)), as each pass requires a binary search (O(log(i)), summed from i
 * = 1 to i = n, or (O(log(1) + log(2) + ... + log(n))) = (O(log(1*2*3...*n))) =
 * (O(log(n!))) ≈ O(log(n^n)) = O(n*log(n)).
 */

import java.util.ArrayList;

public class InsertionSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList<Integer> populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>(size);
	
	for (int i = 0; i < size; ++i)
	    retAL.add(new Integer((int) (Math.random() * (hi - lo + 1)) + lo));

	return retAL;
    }

    public static void swap( ArrayList<Integer> al, int i, int j) {
	al.set(i, new Integer (al.get(i).intValue() + al.get(j).intValue()));
	al.set(j, new Integer (al.get(i).intValue() - al.get(j).intValue()));
	al.set(i, new Integer (al.get(i).intValue() - al.get(j).intValue()));
    }
    
    public static void shove( ArrayList<Integer> al, int oldIndex, int newIndex) {
	Integer first = al.get(oldIndex);
	al.remove(oldIndex);
	al.add(newIndex, first);
    }


    public static int compare(ArrayList<Integer> al, int first, int second) {
	return ((al.get(first)).compareTo(al.get(second)));
    }


    /*
     * For each index of the array, the function randomly selects one of the
     * elements in indices greater than or equal to that one, with a
     * successive (1/i) choice for each successive index i. This is uniform
     * by induction, as this is true for zero elements and one element, and
     * if each of n elements have a 1/n probability of being picked, then
     * adding one more element gives the first n elements (n/n+1)*(1/n) =
     * 1/n+1 probability of being picked, as they are picked when the last
     * one is not.
     */
    public static void shuffle( ArrayList<Integer> al ) {
	int replacement; // Index of replacement
	for (int i = 0; i < al.size(); ++i) { // Random selection for index i
	    replacement = i;
	    for (int j = i; j < al.size(); ++j) {
		if ( ((int) (Math.random() * (j - i))) == 0) {
		    replacement = j;
		}
	    }
	    swap(al, i, replacement);
	}
    }
    
    public static void insertionSortV( ArrayList<Integer> data ) {
	int tail; // Last sorted index
	int low; // Lower index of binsearch
	int high; // Higher index of binsearch

	for (tail = 0; tail < data.size() - 1; ++tail) { 
	    if (compare(data, tail+1, 0) <= 0) { // Smallest
		shove(data, tail+1, 0);
		continue;
	    }

	    else if (compare(data, tail+1, tail) >= 0)
		continue;

	    low = 0;
	    high = tail;

	    while (true) {
		int umid = (low + high + 1)/2;
		int lmid = (low + high - 1)/2;

		int ucomp = compare(data, tail+1, umid);
		int lcomp = compare(data, tail+1, lmid);

		if (ucomp == 0) {
		    shove(data, tail+1, umid);
		    break;
		} else if (lcomp == 0) { // less than
		    shove(data, tail+1, lmid);
		    break;
		} else if (lcomp * ucomp == -1) {
		    shove(data, tail+1, umid);
		    break;
		}
		else if (lcomp + ucomp == -2)
		    high = lmid;
		else if (lcomp + ucomp == 2)
		    low = umid;
	    }
	}
    }// O(log(n!)) or O(n*log(n))

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ArrayList-returning insertionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Integer> insertionSort( ArrayList<Integer> input ) {
	ArrayList<Integer> copy = new ArrayList<Integer>(input);
	insertionSortV(copy);
	return copy;
    }//end insertionSort, O(N^2)

    public static void main( String [] args ) {

	/*===============for VOID methods=============
	ArrayList<Integer> glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	insertionSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList<Integer> coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	insertionSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	  ============================================*/

	/*==========for AL-returning methods==========
    	ArrayList<Integer> glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList<Integer> glenSorted = insertionSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

      	ArrayList<Integer> coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList<Integer> cocoSorted = insertionSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	  ============================================*/

    }//end main

}//end class InsertionSort
