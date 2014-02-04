// Peter Duchovni
// Period 9
// HW 38
// December 4, 2013

public class SuperArray implements ListInt {
    private int[] _data;
    private int _lastPos;
    private int _size;


    //default constructor
    //initializes 10-item array
    public SuperArray() { 
	_data = new int[10];
	_size = 0;
	_lastPos = -1;
    }


    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() { 
	String ret = "[";
	if (_data.length > 0) {
	    ret += _data[0];
	    for (int i = 1; i < _data.length; ++i)
	        ret += ", " + _data[i];
	}
	ret += "]\n";
	return ret;
    }


    //double capacity of this instance of SuperArray 
    private void expand() { 
        int data[] = new int[2 * _data.length];

	for (int i = 0; i < _data.length; i++)
	    data[i] = _data[i];

	_data = data;
    }


    //accessor method -- return value at specified index
    public int get( int index ) {
	if (index < _size)
	    return _data[index];
	else
	    return 0;
    }


    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) {
        int old = get(index);

        while (index >= _data.length)
	    expand();

        _data[index] = newVal;

	if (_lastPos < index) {
	    _lastPos = index;
	    _size = index + 1;
        }
	return old; 
    }

    //adds an item after the last item
    public boolean add( int newVal ) { 
        set( _lastPos + 1, newVal );
	_lastPos++;
	return true;
    }


    //inserts an item at index    
    public void add( int index, int newVal ) { 
        for (int i = _lastPos; i > index; --i)
	    set( i + 1, _data[i] );

        set(index, newVal);
	_lastPos++;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public int remove( int index ) { 
        int removal = _data[index];

        for (int i = index; i < _lastPos; ++i)
	    set( i, _data[i+1] );

        _data[_lastPos] = 0;
	_lastPos--;

	return removal;
    }


    //return number of meaningful items in _data
    public int size() {
	return _size;
    }


    public static void main( String[] args ) {

	SuperArray curtis = new SuperArray();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis );

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set( i, i * 2 );
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < 3; i++ ) {
	    curtis.expand();
	    System.out.println("Printing expanded SuperArray curtis...");
	    System.out.println(curtis);
	    System.out.println("new length of underlying array: " 
			       + curtis._data.length );
	}
    }
}
