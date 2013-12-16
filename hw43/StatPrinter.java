// Peter Duchovni
// Period 9
// HW 42
// December 15, 2013

import java.util.ArrayList;

public class StatPrinter {

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency;


    //*************** QUESTION __ **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data)+1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]
    //  Runtime efficiency: O(N)
    public StatPrinter( ArrayList <Integer> data ) { 
	int m = max(data).intValue();
	_frequency = new ArrayList<Integer>(m + 1);

	for (int i = 0; i <= m; ++i)
	    _frequency.add((new Integer(0)));

	for (Integer i : data) {
	    int ival = i.intValue();
	    _frequency.set(ival, (Integer) (_frequency.get(ival) + 1));
	}
    }


    //*************** QUESTION __ **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    //  Runtime efficiency: O(N)
    public Integer max( ArrayList <Integer> data ) { 
	Integer maximum = data.get(0);

	for (Integer elem : data)
	    maximum = (maximum.compareTo(elem) >= 0) ? maximum : elem;

	return maximum;
    }


    //*************** QUESTION __ **************************
    //postcond: returns true if i>0 and i<_frequency.size()-1
    //          and _frequency.get(i-1) < _frequency.get(i)
    //          and _frequency.get(i+1) < _frequency.get(i)
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    //  Runtime efficiency: O(1)
    public boolean isLocalMode( int i ) { 
	return (i > 0 &&
	        i < _frequency.size() - 1 && 
		_frequency.get(i-1).compareTo(_frequency.get(i)) < 0 &&
		_frequency.get(i+1).compareTo(_frequency.get(i)) < 0);

    }


    //*************** QUESTION __ **************************
    //postcond: returns list of modes in _frequency
    //  Runtime efficiency: O(N)
    public ArrayList <Integer> getLocalModes() {
	ArrayList<Integer> localmodes = new ArrayList<Integer>();

	for (int i = 0; i < _frequency.size(); ++i)
	    if (isLocalMode(i))
		localmodes.add((Integer) i);

	return localmodes;

    }

    /* For testing
    public String toString() { 
	String ret = "[";
	if (_frequency.size() > 0) {
	    ret += _frequency.get(0);
	    for (int i = 1; i < _frequency.size(); ++i)
	        ret += ", " + _frequency.get(i);
	}
	ret += "]\n";
	return ret;
    }
    */


    //*************** QUESTION __ **************************
    //precond:  longestBar > 0
    //  Runtime efficiency: O(N)
    public void printHistogram( int longestBar ) { 
	double scale = (longestBar)/((double) max(_frequency).intValue());
	for (int i = 0; i < _frequency.size(); ++i) {
	   System.out.printf("%d: ", i);
	   int stars = (int) ((_frequency.get(i).intValue()) * scale );
	   while ((stars--) > 0) {
	       System.out.print("*");
	   }
	   System.out.print("\n");
	}

    }
 
}//end class StatPrinter
