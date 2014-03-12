public class Driver {
    public static void main ( String[] args ) {
	int foo[] = {0,1,5,4,9,5,8,7,5,4,2,8,7,4,5,7,5,8};
	int bar[] = QuickSort.quicksort(foo);

	for (int i : foo) {
	    System.out.printf("%d ", i);
	}
	System.out.println();
	for (int j : bar) {
	    System.out.printf("%d ", j);
	}
	System.out.println();
    }
}
