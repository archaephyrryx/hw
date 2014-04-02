import java.io.*;
import java.util.*;

public class LLIterator<E> implements Iterator<E> {
    private Node<E> current;

    public LLIterator(Node<E> head) {
	current = head;
    }

    public boolean hasNext() {
	return (current!= null);
    }
    public E next() {
	if (hasNext()) {
	    E ret = current.getData();
	    current = current.getNext();
	    return ret;
	}
	return null;
    }

    public void remove() {
	return;
    }
}
