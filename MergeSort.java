public class MergeSort {

    public static int[] mergeSort( int[] array ) {
		int l = array.length;

		if (l <= 1) {
	    	return array;
		} else {
	    	int[] h1 = new int[l/2];
	   		int[] h2 = new int[l - l/2];
	    
	    	System.arraycopy(array,   0, h1, 0, h1.length);
	    	System.arraycopy(array, l/2, h2, 0, h2.length);

	    	int[] r1 = mergeSort( h1 );
	    	int[] r2 = mergeSort( h2 );
	    
	    	return merge(r1, r2);
	    }
	}

	public static int[] merge( int[] r1, int[] r2 ) {
		int[] merged = new int[r1.length + r2.length];
		
		for (int i = 0, j = 0; i + j < r1.length + r2.length;  ) {
			merged[i+j] = ( (j >= r2.length) ||  // Short-circuit to r1 if r2 has been emptied
				            (i < r1.length &&  // Short-circuit to r2 if r1 has been emptied
				             r1[i] <= r2[j])  // Compare two values if neither are empty
				          ) ? (r1[i++])      // Push next r1-value onto merged array, post-inc i
			                : (r2[j++])     // Push next r2-value onto merged array, post-inc j
			                ;
		}

		return merged;
	}

    public static void main (String[] args) {
    	int[] foo = new int[1000];

    	for (int i = 0; i < 1000; ++i) {
    		for (int j = 0; j < 1000; ++j) {
    			if (((int) (Math.random() * 1000) % (j+1)) == 0) {
    				foo[i] = j;
    			}
    		}
    	}

    	for ( int i : foo ) {
    		System.out.printf(" %d ", i);
    	}
    	System.out.println();
    	for (int i : MergeSort.mergeSort(foo)) {
    		System.out.printf(" %d ", i);
    	}
    	System.out.println();
    }


}
