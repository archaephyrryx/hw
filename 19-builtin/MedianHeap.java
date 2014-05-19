import java.util.*;

public class MedianHeap {

    class MinHeapComparator implements Comparator<Integer> {
	public int compare (Integer o1, Integer o2) {
	    int i1 = o1.intValue();
	    int i2 = o2.intValue();
	    return (i1 - i2);
	}
    }

    class MaxHeapComparator implements Comparator<Integer> {
	public int compare (Integer o1, Integer o2) {
	    int i1 = o1.intValue();
	    int i2 = o2.intValue();
	    return (i2 - i1);
	}
    }

    private PriorityQueue<Integer> under = new PriorityQueue<Integer>(11, new MaxHeapComparator());
    private PriorityQueue<Integer> over = new PriorityQueue<Integer>(11, new MinHeapComparator());
    private int median;
    
    public void add(int i) {
	if (i > median) {
	    over.add(new Integer(i));
	    if (over.size() > under.size() + 1) {
		under.add(new Integer(median));
		median = over.poll().intValue();
	    }
	} else if (i < median) {
	    under.add(new Integer(i));
	    if (under.size() > over.size() + 1) {
		over.add(new Integer(median));
		median = under.poll().intValue();
	    }
	}
    }

    public int findMedian() {
	return median;
    }

    public int removeMedian() {
	int old = median;
	if (under.size() > over.size()) {
	    median = under.poll();
	} else if (under.size() < over.size()) {
	    median = over.poll();
	} else {
	    median = (over.poll() + under.poll()) / 2;
	}
	return old;
    }

    public void print() {
	System.out.println(under);
	System.out.println(median);
	System.out.println(over);
    }

    public static void main (String [] args) {
	MedianHeap med = new MedianHeap();
	for (int i = 0; i < 20; ++i) {
	    int j = (int) (Math.random() * 100);
	    med.add(j);
	}
	med.print();
	System.out.println(med.findMedian());
    }
}
