public class DoubleLL<E> {
    private class Node<E> {
	E data;
	Node<E> next, prev;

	public Node(E d) {
	    this.data = d;
	}
	public String toString() {
	    return data.toString();
	}
	public void setData(E d) { data = d; }
	public E getData() { return data; }

	public void setNext(Node<E> n) { next = n; }
	public Node<E> getNext() { return next; }
	public void setPrev(Node<E> p) { prev = p; }
	public Node<E> getPrev() { return prev; }

    }
    
    private Node<E> current;

    public void insert(E d) {
	Node<E> n = new Node<E>(d);
	if (current == null) {
	    current = n;
	} else {
	    n.setPrev(current);
	    if (current.next != null) { current.next.setPrev(n); }
	    n.setNext(current.next);
	    current.next = n;
	    current = n;
	}
    }

    public E getCurrent() {
	return current.getData();
    }

    public void forward() {
	if (current.getNext() != null) {
	    current = current.getNext();
	}
    }

    public void back() {
	if (current.getPrev() != null) {
	    current = current.getPrev();
	}
    }

    public String toString() {
	if (current == null) {
	    return "";
	}
	Node<E> head;
	for (head = current; head.getPrev() != null; head = head.getPrev()) {}
	String s = "";
	for (Node<E> tmp = head; tmp != null; tmp = tmp.getNext()) {
	    s = s + tmp.getData()+" ";
	}
	return s;
    }

    public static void main (String[] args) {
	DoubleLL<String> L = new DoubleLL<String>();
	System.out.println(L);
	L.insert("hello");
	System.out.println(L);
	L.insert("world");
	System.out.println(L);
	L.insert("three");
	System.out.println(L);
	System.out.println(L.getCurrent());
	L.forward();
	System.out.println(L.getCurrent());
	L.insert("inserted");
	System.out.println(L);
    }
}
