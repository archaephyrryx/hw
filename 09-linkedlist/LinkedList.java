public class LinkedList {
    private Node head;

    public LinkedList() {
	head = new Node();
    }

    public void add( String d ) {
	Node tmp = new Node(d);
	tmp.setNext(head.getNext());
	head.setNext(tmp);
    }

    public void add( int i, String s ) {
	Node graft = new Node(s);
	Node onto = head;
	int j = 0;
	while ( j < i ) {
	    if ( onto == null ) {
		throw new IndexOutOfBoundsException("add: " + i + ">= length" + this.size());
	    }
	    onto = onto.getNext();
	    ++j;
	}
	graft.setNext(onto.getNext());
	onto.setNext(graft);
    }

    public String get ( int i ) {
	Node n = head.getNext();
	int j = 0;
	while ( j < i ) {
	    if ( n == null ) {
		throw new IndexOutOfBoundsException("get: " + i + ">= length" + this.size());
	    }
	    n = n.getNext();
	    ++j;
	}
	return n.getData();
    }

    public String set( int i, String s ) {
	Node graft = new Node(s);
	Node onto = head;
	int j = 0;
	while ( j < i ) {
	    if ( onto == null ) {
		throw new IndexOutOfBoundsException("set: " + i + ">= length" + this.size());
	    }
	    onto = onto.getNext();
	    ++j;
	}
	String ret = Node.toString(onto.getNext());
	graft.setNext(onto.getNext().getNext());
	onto.setNext(graft);
	return ret;
    }

    public String remove(int i) {
	Node n = head;
	int j = 0;
	while ( j < i ) {
	    if ( n == null ) {
		throw new IndexOutOfBoundsException("remove: " + i + ">= length" + this.size());
	    }
	    n = n.getNext();
	    ++j;
	}
	String ret = Node.toString(n.getNext());
	n.setNext(n.getNext().getNext());
	return ret;
    }

    public int find(String s) {
	int i;
	Node n = head.getNext();
	for (i = 0; n != null; ++i) {
	    if (n.getData().equals(s)) {
		return i;
	    }
	    n = n.getNext();
	}
	return -1;
    }

    public int size() {
	int i;
	Node n = head.getNext();
	for (i = 0; n != null; ++i) {
	    n = n.getNext();
	}
	return i;
    }

    public String toString() {
	String s = "";
	Node n = head.getNext();
	do  { 
	    s += "" + n + "\n";
	} while ( (n = n.getNext()) != null );
	return s;
    }
}
