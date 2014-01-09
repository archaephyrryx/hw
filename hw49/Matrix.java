/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below, categorize runtime of each. 
        Test in your main method.
  ====================================*/ 

public class Matrix {
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] _matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix() {
	this(DEFAULT_SIZE);
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) {
	_matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() {
	return _matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
	return _matrix[r-1][c-1];
    }


    //return true if this location is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
	return (_matrix[r-1][c-1] == null);
    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
	Object old = _matrix[r-1][c-1];
	_matrix[r-1][c-1] = newVal;
	return old;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
	String ret = "";
	for (int i = 0; i < size(); ++i) {
	    for (int j = 0; j < size(); ++j) {
		ret += _matrix[i][j];
		ret += "\t";
	    }
	    ret += "\n";
	}

	return ret;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) {
	if (this == rightSide) return true;

	if (!(rightSide instanceof Matrix)) return false;

	Matrix other = (Matrix) rightSide;
	if (other.size() != size()) return false;

	boolean eq = true;

	for (int i = 1; i <= size(); ++i) {
	    for (int j = 1; j <= size(); ++j) {
		eq = eq && ( this.get(i,j).equals(other.get(i,j)) );
		if (!eq) break;
	    }
	    if (!eq) break;
	}
	return eq;
    }


    //return true if target is in this matrix; false otherwise
    public boolean isFound( Object target ) {
	for (int i = 1; i <= size(); ++i) {
	    for (int j = 1; j <= size(); ++j) {
		if (get(i,j).equals(target))
		    return true;
	    }
	}
	return false;
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
	for (int i = 0; i < size(); ++i) {
	    Object temp = _matrix[i][c2-1];
	    _matrix[i][c2-1] = _matrix[i][c1-1];
	    _matrix[i][c1-1] = temp;
	}
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
	Object[] temp = _matrix[r2-1];
	_matrix[r2-1] = _matrix[r1-1];
	_matrix[r1-1] = temp;
    }


    //main method for testing
    public static void main( String[] args ) {
	Matrix neo = new Matrix(2);
	Matrix keanu = new Matrix(2);
	Matrix reeves = new Matrix(2);
	Matrix reloaded = new Matrix(3);

	neo.set(1,1,"I");
	neo.set(1,2,"Am");
	neo.set(2,1,"The");
	neo.set(2,2,"One!");

	keanu.set(1,1,"I");
	keanu.set(1,2,"Know");
	keanu.set(2,1,"Kung");
	keanu.set(2,2,"Fu!");

	System.out.println(neo);
	System.out.println(keanu);

	System.out.println(neo.get(1,1));
	System.out.println(neo.get(1,2));
	System.out.println(neo.get(2,1));
	System.out.println(neo.get(2,2));

	System.out.println(keanu.get(1,1));
	System.out.println(keanu.get(1,2));
	System.out.println(keanu.get(2,1));
	System.out.println(keanu.get(2,2));

	System.out.println(keanu.equals(neo));
	System.out.println(neo.equals(keanu));
    }

}//end class Matrix
