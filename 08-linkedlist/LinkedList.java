public class LinkedList {
    private Node head;

    public LinkedList() {
	head = null;
    }

    public void add( String d ) {
	Node tmp = new Node(d);
	tmp.setNext(head);
	head = tmp;
    }

    public void add( int i, String s ) {
	if (i == 0)
	    add(s);
	else {
	    Node graft = new Node(s);
	    Node onto = head;
	    int j = 0;
	    while ( j < i-1 ) {
		if ( onto == null ) {
		    System.err.printf("Index Error: cannot add at index %d of %d-element linked list.\n", i, j);
		    return;
		}
		onto = onto.getNext();
		++j;
	    }
	    graft.setNext(onto.getNext());
	    onto.setNext(graft);
	}
    }

    public String get ( int i ) {
	if (head == null) { 
	    System.err.println("Index Error: linked list has null head.");
	    return null;
	}
	Node n = head;
	int j = 0;
	while ( j < i ) {
	    if ( n == null ) {
		System.err.printf("Index Error: cannot retrieve index %d of %d-element linked list.\n", i, j);
		return null;
	    }
	    n = n.getNext();
	    ++j;
	}
	return n.getData();
    }

    public String set( int i, String s ) {
	if (i == 0) {
	    add(s);
	    return null;
	} else {
	    Node graft = new Node(s);
	    Node onto = head;
	    int j = 0;
	    while ( j < i-1 ) {
		if ( onto == null ) {
		    System.err.printf("Index Error: cannot set index %d of %d-element linked list.\n", i, j);
		    return null;
		}
		onto = onto.getNext();
		++j;
	    }
	    if (onto.getNext() == null) {
		graft.setNext(onto.getNext());
		onto.setNext(graft);
		return null;
	    } else {
		String ret = onto.getNext().getData();
		graft.setNext(onto.getNext().getNext());
		onto.setNext(graft);
		return ret;
	    }
	}
    }

    public String remove (int i) {
	if (i == 0) {
	    head = head.getNext();
	    return null;
	} else {
	    Node n = head;
	    int j = 0;
	    while ( j < i-1 ) {
		if ( n == null ) {
		    System.err.printf("Index Error: cannot remove index %d of %d-element linked list.\n", i, j);
		    return null;
		}
		n = n.getNext();
		++j;
	    }
	    if (n.getNext() == null) {
		return null;
	    } else {
		String ret = n.getNext().getData();
		n.setNext(n.getNext().getNext());
		return ret;
	    }
	}
    }

    public int find(String s) {
	int i;
	Node n = head;
	for (i = 0; n != null; ++i) {
	    if (n.getData().equals(s)) {
		return i;
	    }
	    n = n.getNext();
	}
	return -1;
    }

    public int length () {
	int i;
	Node n = head;
	for (i = 0; n != null; ++i) {
	    n = n.getNext();
	}
	return i;
    }

    public String toString() {
	String s = "";
	Node n = head;
	do  { 
	    s += "" + n + "\n";
	} while ( (n = n.getNext()) != null );
	return s;
    }
}
