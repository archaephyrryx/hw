import java.util.*;
import java.io.*;

public class QSort { 

    public static int[] qsort(int[] a, int l, int r) {
	if (r-l >= 1) {
	    int bounds[] = partition(a, l, r);
	    int wall = bounds[0];
	    int rwall = bounds[1];
	    if (wall-1 > l)
		qsort(a, l, wall-1);
	    if (rwall+1 < r)
		qsort(a, rwall+1, r);
	}
	return a;
    }

    public static int[] qsort(int[] a) {
	return qsort(a, 0, a.length-1);
    }

    public static int getPivot(int[] a, int l, int r ) {
	int pivot = (int) (Math.random() * (r-l+1)) + l;
	return pivot;
    }

    public static void swap(int[] a, int i, int j) {
	if (i != j) {
	    a[i] += a[j];
	    a[j] = a[i] - a[j];
	    a[i] -= a[j]; 
	}
    }


    public static int[] partition( int[] a, int l, int r ) {
	int pivot = getPivot(a, l, r);
	System.out.printf("%02d %02d %02d\n", l, pivot, r);
	System.out.println(Arrays.toString(a));
	int wedge = a[pivot];

	swap(a, pivot, r);

	int wall = l;
	int rwall = l;
	for (int j = wall; j < r; ++j) {
	    if (a[j] == wedge) {
		swap(a, rwall, j);
		++rwall;
	    } else if (a[j] < wedge) {
		swap(a, wall, j);
		++wall;
		if (rwall < wall) { ++rwall; }
	    }
	}
	swap(a, rwall, r);
	int walls[] = {wall,rwall};
	return walls;
    }

    public static void main(String[] args) {
	int n = 20;
	long start,elapsed;

	int[] a = new int[n];
	Random rnd = new Random();
	for (int i=0;i<n;i++)
	    a[i]=rnd.nextInt(100);
	qsort(a);
    }
    
}    
