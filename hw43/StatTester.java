/*===========================================
2,3,2,5,1,3
[0,1,2,2,0,1]

[1,2,1,4,2,3,5] 
2 and 4.

[1,2,1,4,2,3,5]

0 : **
1 : ****
2 : **
3 : ********
4 : ****
5 : ******
6 : **********

For each method, state run time efficiency using Big O notation.

Tips for Awesome:
* Look over all fxns, think a bit, decide which to tackle first.
	( Simplest?  Prerequisites? . . . )
* Develop 1 fxn at a time, test it, then move to next.
* For coding today, what extra code do you need to get past Mr. Compiler?
===========================================*/

import java.util.ArrayList;

public class StatTester {
    public static void main( String[] args ) {
        int[] arr1 = {2,3,2,5,1,3};
	ArrayList<Integer> arrl1 = new ArrayList<Integer>();
	for (int a : arr1)
	    arrl1.add(new Integer(a));


        int[] arr2 = {0,1,1,2,3,3,3,3,4,4,5,5,5,6,6,6,6,6};
	ArrayList<Integer> arrl2 = new ArrayList<Integer>();
	for (int a : arr2)
	    arrl2.add(new Integer(a));

	StatPrinter stat1 = new StatPrinter(arrl1);
	StatPrinter stat2 = new StatPrinter(arrl2);

	System.out.println(stat1);
	System.out.println(stat2);

	System.out.println(stat2.getLocalModes());
	stat2.printHistogram(10);
    }
}
