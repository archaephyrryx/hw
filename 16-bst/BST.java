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
    }

    private Node root;

    public BST() {
	root = null;
    }

    public BST(int i) {
	root = new Node(i);
    }

    public void setRoot(Node n) {
	if (root == null) {
	    root = n;
	} else {
	    n.left = root.left;
	    n.right = root.right;
	    n.parent = root.parent;
	    root = n;
	}
    }


    public Node search(int x) {
	Node n = root;
	while (n != null && n.data != x) {
	    if (n.data < x) {
		n = n.right;
		continue;
	    }
	    if (n.data > x) {
		n = n.left;
		continue;
	    }
	}
	return n;
    }

    public Node search_r(int x) {
	return search_r(x,root);
    }

    public Node search_r(int x, Node n) {
	if (n == null || n.data == x)
	    return n;
	if (n.data < x)
	    return search_r(x, n.right);
	else
	    return search_r(x, n.left);
    }



    public void insert(int i) {
	Node graft = new Node(i);
	Node n = root;
	while (true) {
	    int dat = n.data;
	    if (dat < i) {
		if (n.right != null)
		    n = n.right;
		else {
		    n.right = graft;
		    return;
		}
	    } else if (dat > i) {
		if (n.left != null)
		    n = n.left;
		else {
		    n.left = graft;
		    return;
		}
	    }
	    else {
		return;
	    }
	}
    }
}
