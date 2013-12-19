/*======================================
  class BubbleSort -- implements bubblesort algorithm
  ======================================*/

import java.util.ArrayList;

public class BubbleSort {

    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>(size);
	
	for (int i = 0; i < size; ++i)
	    retAL.add(new Integer((int) (Math.random() * (hi - lo)) + lo));

	return retAL;
    }


    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	for (int i = 0; i < al.size(); ++i) {
	    Integer replacement;
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
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	boolean sorted = false;

	for (int i = 0; i < data.size() && !(sorted) ; ++i) {
	    for (int j = i+1; j < data.size(); ++j) {
		sorted = true;
		int second = data.get(j);
		int first = data.get(j-i);
		if (second < first) {
		    sorted = false;
		    first -= (second = (first += second) - second);
		    data.set(j, new Integer(second));
		    data.set(j-1, new Integer(first));
		}
	    }
	}
    } // O(N^2)


    // ArrayList-returning bubbleSort
    // postcondition: order of data's elements unchanged
    //                Returns sorted copy of data.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
	ArrayList<Comparable> data = new ArrayList<Comparable>(input);

	bubbleSortV(data);
	return data;
    }//end bubbleSort -- O(N^2)


    public static void main(String [] args){

	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	bubbleSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	bubbleSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );

    	ArrayList glen = new ArrayList<Integer>();
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

      	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = bubbleSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	System.out.println( coco );

    }//end main

}//end class BubbleSort
