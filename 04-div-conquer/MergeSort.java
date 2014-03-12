import java.util.ArrayList;

public class MergeSort {

    public static ArrayList<String> mergeSort( ArrayList<String> array ) {
		int l = array.size();

		if (l <= 1) {
		    return array;
		} else {
		    ArrayList<String> h1 = new ArrayList<String>(array.subList(0,l/2));
		    ArrayList<String> h2 = new ArrayList<String>(array.subList(l/2,l));
	    
		    ArrayList<String> r1 = mergeSort( h1 );
		    ArrayList<String> r2 = mergeSort( h2 );
	    
		    return merge(r1, r2);
	    }
	}

	public static ArrayList<String> merge( ArrayList<String> r1, ArrayList<String> r2 ) {
		ArrayList<String> merged = new ArrayList<String>();
		
		for (int i = 0, j = 0; i + j < r1.size() + r2.size();  ) {
			merged.add( (
				    ( (j >= r2.size()) ||
				      (i <  r1.size() &&
				      r1.get(i).compareTo(r2.get(j)) <= 0 ) ) ?
				      (r1.get(i++)) : (r2.get(j++)) ) );
		}

		return merged;
	}

    public static void main (String[] args) {
    	ArrayList<String> foo = new ArrayList<String>();

    	for (int i = 0; i < 1000; ++i) {
    		for (int j = 0; j < 1000; ++j) {
    			if (((int) (Math.random() * 1000) % (j+1)) == 0) {
    				foo.add("" + j);
    			}
    		}
    	}

    	for ( String i : foo ) {
    		System.out.printf(" %s ", i);
    	}
    	System.out.println();
    	for (String i : MergeSort.mergeSort(foo)) {
    		System.out.printf(" %s ", i);
    	}
    	System.out.println();
    }


}
