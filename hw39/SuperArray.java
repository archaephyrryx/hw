/*==================================================
  class SuperArray version 5.0
  Wrapper class for array. Facilitates 
  *  resizing 
  *  expansion 
  *  read/write capability on elements
  *  adding an element to end of array
  *  adding an element at specified index
  *  removing an element at specified index
  ...and now SuperArray complies with the specifications of the 
  List interface. (List.java must be in same dir as this file)
  ==================================================*/

// Peter Duchovni
// Period 9
// HW 38
// December 4, 2013

public class SuperArray<T> implements List<T> {

    private T[] _data;
    private int _lastPos;
    private int _size;

    public SuperArray() { 
	_data = (T[]) new Object[10];
	_lastPos = -1;
	_size = 0;	
    }

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

    private int length() {
	return _data.length; // _data should be T[], but is Object[], so it has no instantiated length
    }

    private void expand() { 
        T data[] = (T[]) new Object[2 * _data.length];

	for (int i = 0; i < _data.length; i++)
	    data[i] = _data[i];

	_data = data;
    }

    public T get( int index ) {
	if (index < _size)
	    return _data[index];
	else
	    return (T) null;
    }

    public T set( int index, T newVal ) {
        Object old = get(index); // Weird casting issues here

        while (index >= _data.length)
	    expand();

        _data[index] = newVal;

	if (_lastPos < index) {
	    _lastPos = index;
	    _size = index + 1;
        }
	return (T) old; // Cast at end
    }

    //adds an item after the last item
    public boolean add( T newVal ) { 
        set( _lastPos + 1, newVal );
	_lastPos++;
	return true;
    }

    //inserts an item at index    
    public void add( int index, T newVal ) { 
        for (int i = _lastPos; i > index; --i)
	    set( i + 1, _data[i] );

        set(index, (T) newVal);
	_lastPos++;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public T remove( int index ) { 
        T removal = _data[index];

        for (int i = index; i < _lastPos; ++i)
	    set( i, _data[i+1] );

        _data[_lastPos] = (T) null;
	_lastPos--;

	return removal;
    }


    //return number of meaningful items in _data
    public int size() {
	return _size;
    }


    public static void main( String[] args ) {

	SuperArray<Integer> curtis = new SuperArray<Integer>();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis.length(); i++ ) {
	    curtis.set( i, new Integer(i*2) ); // ints are not Integers
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < 3; i++ ) {
	    curtis.expand();
	    System.out.println("Printing expanded SuperArray curtis...");
	    System.out.println(curtis);
	    System.out.println("new length of underlying array: " 
			       + curtis.length() ); // Length accessor, not property
	}

	SuperArray<Integer> mayfield = new SuperArray<Integer>();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
    }
}
