public class RPNStack {
    class Entry {
	double val;
	Entry sub; // Subordinate sheet

	public Entry(double v) {
	    val = v;
	}
    }

    private Entry top;

    public RPNStack() { top = new Entry(0); }

    public void push(double v) {
	Entry ent = new Entry(v);
	ent.sub = top;
	top = ent;
    }

    public double pop() {
	if (top == null)
	    return 0.0;
	double ret = top.val;
	top = top.sub;
	return ret;
    }

    public double peek() {
	if (top == null)
	    return 0.0;
	return top.val;
    }
    public boolean empty() {
	return (top == null);
    }
    public String toString() {
	String s = "";
	String l = ">> ";
	Entry tmp = top;
	while (tmp != null) {
	    s = l + tmp.val + "\n" + s;
	    tmp = tmp.sub;
	    l = ">  ";
	}
	return s;
    }
}
