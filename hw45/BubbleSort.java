/*======================================
  class BubbleSort -- implements bubblesort algorithm
  ======================================*/

import java.util.ArrayList;

public class BubbleSort {

    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList<Integer> populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>(size);
	
	for (int i = 0; i < size; ++i)
	    retAL.add(new Integer((int) (Math.random() * (hi - lo)) + lo));

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


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Integer> data ) {
	/* boolean sorted stores false if at least one swap was
	 * performed on the last pass, and
	 * resets to true after each pass 
	 */
	boolean sorted = false;
	/* 
	 * Loops N times, for list of size N, on each pass resetting
	 * the value of sorted to true, which will cause the loop to
	 * break if no changes are made.  After the i'th pass, the
	 * first i indices of the list are guaranteed to be in order,
	 * so they are skipped. Looping is tail-first, starting at
	 * the maximum index and stopping at the index equal to the
	 * number of passes performed +1, which is compared to its predecessor,
	 * which will be the first unsorted index of the array. This will break
	 * after n passes, or when a pass finds no out-of-place elements,
	 * which can only happen if the list is sorted.
	 */
	for (int passes = 0; passes < data.size(); ++passes) { 
	    sorted = true;

	    for (int j = data.size() - 1; j > passes; --j) {
		int first = data.get(j-1).intValue();
		int second = data.get(j).intValue();
		if (first > second) {
		    sorted = false;
		    data.set(j-1, new Integer(second));
		    data.set(j, new Integer(first));
		}
	    }

	    System.out.println(data);
	    if (sorted)
		break;
	}
    } // O(N^2)


    // ArrayList-returning bubbleSort
    // postcondition: order of data's elements unchanged
    //                Returns sorted copy of data.
    public static ArrayList<Integer> bubbleSort( ArrayList<Integer> input ) {
	ArrayList<Integer> data = new ArrayList<Integer>(input);

	bubbleSortV(data);
	return data;
    }//end bubbleSort -- O(N^2)


    public static void main(String [] args){

	/*
	ArrayList<Integer> glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	bubbleSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList<Integer> coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	bubbleSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );

	*/
	//
    	ArrayList<Integer> glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = bubbleSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

      	ArrayList<Integer> coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = bubbleSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	System.out.println( coco );
	//

    }//end main

}//end class BubbleSort
