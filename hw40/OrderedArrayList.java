// Peter Duchovni
// Period 9
// HW 38
// December 4, 2013

/*============================================
   class OrderedArrayList
   Wrapper class for ArrayList.
   Imposes the restriction that stored items 
   must remain sorted in ascending order
   ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;

    // default constructor initializes instance variable _data
    public OrderedArrayList() {
    	_data = new ArrayList<Comparable>();
    }

    public String toString() { 
	String ret = "[";
	if (_data.size() > 0) {
	    ret += _data.get(0);
	    for (int i = 1; i < _data.size(); ++i)
	        ret += ", " + _data.get(i);
	}
	ret += "]\n";
	return ret;
    }
 
    public Comparable remove( int index ) { 
	return _data.remove(index);
    }

    public int size() { 
	return _data.size();
    }

    public Comparable get( int index ) { 
	return _data.get(index);
    }

    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear(Comparable newVal) { 
	for (int i = 0; i < _data.size(); ++i) {
	    if (_data.get(i).compareTo(newVal) >= 0) {
		_data.add(i, newVal);
		return;
	    }
	}
	_data.add(newVal);
    }


    // addBinary takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a binary search to find appropriate index
    public void addBinary(Comparable newVal) { 
	int glb = 0; // Greatest lower bound
	int lub = _data.size() - 1; // Least upper bound

	if (_data.size() == 0) { // Empty
	    _data.add(newVal);
	    return;
	}
	if (newVal.compareTo(_data.get(0)) == -1) { // Smallest
	    _data.add(0, newVal);
	    return;
	}
	if (newVal.compareTo(_data.get(lub)) == 1) { // Largest
	    _data.add(newVal);
	    return;
	}

	while (true) {
	    int mid = (glb + lub)/2;
	    int comp = newVal.compareTo(_data.get(mid));

	    if (comp == 0) { // equal
		_data.add(mid, newVal);
		return;
	    } else if (comp == -1) { // less than
		if (newVal.compareTo(_data.get(mid - 1)) >= 0) { // between
		    _data.add(mid, newVal);
		    return;
		} else // below
		    lub = mid - 1;
	    } else if (comp == 1) { // greater than
		if (newVal.compareTo(_data.get(mid + 1)) <= 0) { //between
		    _data.add(mid + 1, newVal);
		    return;
		} else // above
		    glb = mid + 1;
	    }
	}
    }


    // main method solely for testing purposes
    public static void main( String[] args ) {
	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.addLinear( (int)( 50 * Math.random() ) );
	System.out.println( Franz );

	// testing binary search
	Franz = new OrderedArrayList();
	for( int i = 0; i < 15; i++ )  {
	    Franz.addBinary( (int)( 50 * Math.random() ) );
	    System.out.println( Franz );
	}
	System.out.println( Franz );
    }

}//end class OrderedArrayList
