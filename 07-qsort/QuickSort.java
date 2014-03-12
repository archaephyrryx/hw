import java.util.Arrays;

public class QuickSort { 

    public static int[] quicksort(int[] a) {
	int l = a.length;
	if (l <= 1) { return a; }

	int pivot = (int) (Math.random()*l);

	int[] parted = new int[l];
	int head = 0;
	int tail = l-1;

	for (int i = 0; i < l; ++i) {
	    if (i == pivot) { continue; }
	    if (a[i] <= a[pivot]) { parted[head] = a[i]; ++head; }
	    else { parted[tail] = a[i]; --tail; }
	}

	int inf[] = quicksort(Arrays.copyOfRange(parted, 0, head));
	int sup[] = quicksort(Arrays.copyOfRange(parted, tail+1, l));

	int cat[] = new int[l];
	System.arraycopy(inf, 0, cat, 0, inf.length);
	cat[inf.length] = a[pivot];
	System.arraycopy(sup, 0, cat, inf.length+1, sup.length);

	return cat;
    }
}
