public class QuickSort { 

	public static int quickselect(int[] a, int k, int lo, int hi) {
		if ( lo == hi ) { return a[lo]; }

		int pivot = (int) (Math.random()*(hi-lo+1) + lo);
		System.out.printf("%d < %d < %d\n", lo, pivot, hi);

		int l = a.length;

		int[] parted = new int[l];
		int head = 0;
		int tail = l-1;
		
		while ( head < lo || tail > hi ) {
		    if (head < lo) {
			dump(parted);
			parted[head] = a[head];
			++head;
		    } if (tail > hi) {
			dump(parted);
			parted[tail] = a[tail];
			--tail;
		    }
		}
		System.out.println();

		int i = lo, j = hi;
		dump(a);

		while ( i <= pivot || j >= pivot ) {
		    if ( head == tail ) { dump(parted); parted[head] = a[pivot]; dump(parted); break; }
		    if ( i < pivot ) {
			dump(parted);
			if ( a[i] <= a[pivot] ) { parted[head] = a[i]; ++head; }
			else {parted[tail] = a[i]; --tail; }
			++i;
		    }
		    if ( j > pivot ) {
			dump(parted);
			if ( a[j] <= a[pivot] ) { parted[head] = a[j]; ++head; }
			else { parted[tail] = a[j]; --tail; }
			--j;
		    }
		}
		System.out.println();

		if (k < head)
			return quickselect(parted, k, lo, head - 1);
		if (k > head)
			return quickselect(parted, k, head + 1, hi);
		return parted[head];
	}

	public static void dump(int[] array) {
	    for (int i = 0; i < array.length; ++i) {
		System.out.printf("%2d, ", array[i]);
	    }
	    System.out.println();
	}

}
