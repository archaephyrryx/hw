public class Node {
    private String data;
    private Node next;

    public Node(String d) {
	data = d;
	next = null;
    }

    public Node() {
	data = null;
	next = null;
    }


    public String getData() {
	return data;
    }
    
    public void setNext(Node n) {
	next = n;
    }

    public Node getNext() {
	return next;
    }

    public String toString() {
	return data;
    }

    public static String toString(Node n) {
	if (n != null)
	    return n.toString();
	return null;
    }
}
