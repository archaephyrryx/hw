public class CyclicLL<E> {
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
	    n.setNext(n);
	    n.setPrev(n);
	    current = n;
	} else {
	    n.setNext(current);
	    n.setPrev(current.prev);
	    current.prev.setNext(n);
	    current.prev = n;
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
	Node<E> tmp = current;
	String s = "";
	do {
	    s = s + tmp.getData()+" ";
	    tmp = tmp.getNext();
	} while (tmp != current);
	return s;
    }

    public static void main (String[] args) {
	CyclicLL<String> L = new CyclicLL<String>();
	L.insert("Man");
	L.insert("Bites");
	L.insert("Dog");
	System.out.println(L);
	L.forward();
	System.out.println(L);
	L.forward();
	System.out.println(L);
	L.forward();
    }
}
