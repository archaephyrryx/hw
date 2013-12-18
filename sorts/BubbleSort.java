/*======================================
  class BubbleSort -- implements bubblesort algorithm
  ======================================*/

public class BubbleSort {

    //precond: lo < hi && size > 0
    //postcond: returns an Array of random INts
    //          from lo to hi, inclusive
    public static int[] populate( int size, int lo, int hi ) {
	int[] retINA = new int[size];

	//***INSERT YOUR CODE HERE***

	return retINA;
    }


    //randomly rearrange elements of an ArrayList
    public static void shuffle( int[] ina ) {
	//***INSERT YOUR CODE HERE***

    }


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( int[] data ) {
	for (int i = 0; i < data.length; ++i) {
	    for (int j = 1; j < data.length; ++j) {
		if (data[j] < data[j-1]) {
		    data[j-1] += data[j];
		    data[j] = data[j-1] - data[j];
		    data[j-1] -= data[j];
		}
	    }
	}
    }//end bubbleSortV -- O(?)


    // ArrayList-returning bubbleSort
    // postcondition: order of data's elements unchanged
    //                Returns sorted copy of data.
    public static ArrayList<Comparable> bubbleSort( int[] input ) {
	//declare and initialize empty ArrayList for copying
	ArrayList<Comparable> data = new ArrayList<Comparable>();

	//***INSERT YOUR CODE HERE***

	return data;
    }//end bubbleSort -- O(?)


    public static void main(String [] args){

	/*===============for VOID methods=============
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
	  ============================================*/

	/*==========for AL-returning methods==========
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
	  ============================================*/

    }//end main

}//end class BubbleSort
