public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E d) {
	data = d;
	next = null;
    }

    public Node() {
	data = null;
	next = null;
    }


    public E getData() {
	return data;
    }
    
    public void setNext(Node<E> n) {
	next = n;
    }

    public Node<E> getNext() {
	return next;
    }

    public String toString() {
	return data.toString();
    }
}
