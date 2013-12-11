// Peter Duchovni
// Period 9
// Homework 21
// November 2, 2013

public class Loopier {
    private static int _index = 0; /* Global for linSearchR current index;
                                      initalized and reset each time to 0 */

    public static int freqFor ( int[] a, int target ) {
        int frequency = 0;
	int item;
	int index;

	for (index = 0; index < a.length; ++index) {
	    /* add one if the current item is the target, 0 otherwise */
	    frequency += (((item = a[index]) == target) ? 1 : 0);
	}

        return frequency;
    }

    public static int freqForEach ( int[] a, int target ) {
        int frequency = 0;

	for (int item : a) {
	    frequency += ((item == target) ? 1 : 0);
	}

        return frequency;
    }

    public static int freqWhile ( int[] a, int target ) {
        int frequency = 0;
	int item;
	int index = 0;

	while (index < a.length) {
            item = a[index++];
	    frequency += ((item == target) ? 1 : 0);
	}

        return frequency;
    }
    public static int linSearchR ( int[] a, int target ) {
	if (_index == a.length) {
            _index = 0; // reset
	    return -1; // return -1
	} else if (a[_index] == target) {
	    int myIndex = _index; // copy index
	    _index = 0; // reset index
	    return myIndex; // return copy
	} else {
	  ++_index; // increment
	  return linSearchR(a, target); //return
	}
    }

    public static int linSearch ( String[] a, String target ) {
        int index = 0;
	for (String value : a) {
	    if (value.equals(target)) {
              return index; // Non-recursive can use local index
	    }
	    ++index;
	}
	return -1;
    }


    public static void main ( String[] args ) {

        // Functions worked when tested
	/*==================================================
	System.out.println("\nNow testing linSearchR on int array...");
	//declare and initialize an array of ints
	int[] x = { 2, 4, 6, 8, 6, 42 };
	//search for 6 in array x
	System.out.println( linSearchR(x,6) );
	//search for 43 in array x
	System.out.println( linSearchR(x,43) );
	System.out.println("\nNow testing linSearch on String array...");
	//declare and initialize an array of Strings
	String[] y = { "kiwi", "watermelon", "orange", "apple", 
		       "peach", "watermelon" };
	//search for "watermelon" in array y
	System.out.println( linSearch(y,"watermelon") );
	//search for "lychee" in array y
	System.out.println( linSearch(y,"lychee") );

	//declare and initialize an array of ints
	int[] z = { 1, 5, 3, 5, 1, 5 };

	//compute frequency of 5 in array z
	int q = 5;
	System.out.println( freqFor ( z, q ) );
	System.out.println( freqForEach ( z, q ) );
	System.out.println( freqWhile ( z, q ) );

	//compute frequency of 2 in array z
	int r = 2;
	System.out.println( freqFor(z,r) );
	System.out.println( freqForEach(z,r) );
	System.out.println( freqWhile(z,r) );

	==================================================*/
    }
}
