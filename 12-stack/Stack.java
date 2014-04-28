import java.util.Arrays;

public class Stack {
    private int top;
    private String[] data;

    public Stack() {
	data = new String[10];
	top = 0;
    }

    public void push(String s) {
	int l = data.length;
	if (top == l - 1)
	    data = Arrays.copyOf(data, l*2);
	if (data[top] != null)
	    ++top;
	data[top] = s;
    }

    public String pop() {
	String ret = data[top];
	if (top == 0)
	    data[top] = null;
	else
	    --top;
	return ret;
    }

    public String peek() {
	return data[top];
    }

    public int size() {
	return (isEmpty()) ? 0 : top + 1;
    }

    public boolean isEmpty() {
	return (data[top] == null);
    }

    public String toString() {
	return Arrays.asList(Arrays.copyOf(data, top+1)).toString();
    }
}
