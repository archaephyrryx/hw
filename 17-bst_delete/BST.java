public class BST {
    class Node {
	int data;
	Node parent;
	Node left;
	Node right;

	Node( int i ) {
	    data = i;
	    parent = null;
	    left = null;
	    right = null;
	}

	Node() {
	    parent = null;
	    left = null;
	    right = null;
	}

    }

    private Node radix;
    private Node root;

    public BST() {
	radix = new Node(Integer.MIN_VALUE);
	root = null;
	radix.right = root;
    }

    public BST(int i) {
	root = new Node(i);
	radix.right = root;
    }

    public void setRoot(Node n) {
	if (root == null) {
	    root = n;
	    radix.right = root;
	} else {
	    n.left = root.left;
	    n.right = root.right;
	    n.parent = root.parent;
	    radix.right = n;
	    root = n;
	}
    }

    public Node search(int x) {
	return search(x,root);
    }

    public Node search(int x, Node n) {
	if (n == null || n.data == x)
	    return n;
	if (n.data < x)
	    return search(x, n.right);
	else
	    return search(x, n.left);
    }

    public Node tsearch(int x) {
	return tsearch(x,radix);
    }

    public Node tsearch(int x, Node n) {
	if (n == null)
	    return radix;
	if (n.data < x) {
	    if (n.right == null)
		return n;
	    else
		return tsearch(x, n.right);
	}
	if (n.data > x) {
	    if (n.left == null)
		return n;
	    else 
		return tsearch(x, n.left);
	}
	else {
	    return n.parent;
	}
    }

    public void insert(int i) {
	splice(tsearch(i), i);
    }

    private void splice(Node n, int i) {
	Node m = new Node(i);
	m.parent = n;

	if (i < n.data && n.left == null)
	    n.left = m;
	if (i > n.data && n.right == null)
	    n.right = m;
    }

    public void delete (int x) {
	prune(search(x));
    }

    private void prune (Node n) {
	if (n == null || n == radix) 
	    return;

	Node par = n.parent;

	if (n.left == null) {
	    if (par.left == n)
		par.left = n.right;
	    if (par.right == n)
		par.right = n.left;
	    return;
	}
        if (n.right == null) {
	    if (par.left == n)
		par.left = n.right;
	    if (par.right == n)
		par.right = n.right;
	    return;
	}

	Node tracer = n.left;
	Node max = n.left.right;

	while (max != null) {
	    tracer = tracer.right;
	    max = max.right;
	}
	n.data = tracer.data;
	prune(tracer);
    }


}
