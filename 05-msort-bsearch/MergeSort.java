import java.util.ArrayList;

public class MergeSort {

    public static ArrayList<Comparable> mergeSort( ArrayList<Comparable> array ) {
		int l = array.size();

		if (l <= 1) {
		    return array;
		} else {
		    ArrayList<Comparable> h1 = new ArrayList<Comparable>(array.subList(0,l/2));
		    ArrayList<Comparable> h2 = new ArrayList<Comparable>(array.subList(l/2,l));
	    
		    ArrayList<Comparable> r1 = mergeSort( h1 );
		    ArrayList<Comparable> r2 = mergeSort( h2 );
	    
		    return merge(r1, r2);
	    }
	}

	public static ArrayList<Comparable> merge( ArrayList<Comparable> r1, ArrayList<Comparable> r2 ) {
		ArrayList<Comparable> merged = new ArrayList<Comparable>();
		
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
    	ArrayList<Comparable> foo = new ArrayList<Comparable>();

    	for (int i = 0; i < 1000; ++i) {
    		for (int j = 0; j < 1000; ++j) {
    			if (((int) (Math.random() * 1000) % (j+1)) == 0) {
    				foo.add(new Person("Alfred William the " + j + "th"));
    			}
    		}
    	}

    	for ( Comparable i : foo ) {
    		System.out.printf(" %s ", i.toString());
    	}
    	System.out.println();
    	for (Comparable i : MergeSort.mergeSort(foo)) {
    		System.out.printf(" %s ", i.toString());
    	}
    	System.out.println();
    }


}
