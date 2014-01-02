/*======================================
  class InsertionSort -- implements InsertionSort algorithm
  ======================================*/

import java.util.ArrayList;

public class InsertionSort {

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
    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void insertionSortV( ArrayList<Integer> data ) {
	/* 
	 * Loops N times, for list of size N, on each pass expanding the
	 * sorted head-region by one element and inserting the new element in
	 * the properly sorted position.
	 */
	int tail; // Holds last sorted index
	int uval; // Holds value of first unsorted index
	int lo; // Dummy variables for binary search
	int hi; // Dummy variables for binary search
	int insertIndex;

	for (hi = (tail = (lo = 0)); tail < data.size(); hi = (++tail), lo = 0) { 
	    uval = data.get(tail + 1).intValue();

	int glb = 0; // Greatest lower bound
	int lub = _data.size() - 1; // Least upper bound

	if (_data.size() == 0) { // Empty
	    _data.add(newVal);
	    return;
	} if (newVal.compareTo(_data.get(0)) == -1) { // Smallest
		_data.add(0, newVal);
		return;
	} if (newVal.compareTo(_data.get(lub)) == 1) { // Largest
		_data.add(newVal);
		return;
	} while (true) {
		int mid = (glb + lub)/2;
		int comp = newVal.compareTo(_data.get(mid));
		if (comp == 0) { // equal
			_data.add(mid, newVal);
			return;
		} else if (comp == -1) { // less // than
		    if (newVal.compareTo(_data.get(mid - 1)) >= >0)
				    >{
					>//
					    >between
					    _data.add(mid,
						    newVal);
					return;
				    }
			    else
				// below
				lub
				    =
				    mid
				    - 1;
			}
		    else
			if
			    (comp
			     ==
			     1)
			    {
				// greater
				// than
				if
				    (newVal.compareTo(_data.get(mid
								+
								1))
				     <=
				     0)
				    {
					//between
					_data.add(mid
						+
						1,
						newVal);
					return;
				    }
				else
				    // above
				    glb
					=
					mid
					+
					1;
			    }
	    }
    }



	}
    }//end insertionSortV -- O(N^2)


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // ArrayList-returning insertionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Integer> insertionSort( ArrayList<Integer> input ) {
	ArrayList<Integer> data = new ArrayList<Integer>(input);

	insertionSortV(data);
	return data;
    }//end insertionSort, O(N^2)

    public static void main( String [] args ) {

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
	ArrayList<Integer> glenSorted = insertionSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

      	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = insertionSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	System.out.println( coco );
	  ============================================*/

    }//end main

}//end class InsertionSort
