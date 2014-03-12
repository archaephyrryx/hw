public class Driver {
    public static void main ( String[] args ) {
	int foo[] = {0,1,5,4,9,5,8,7,5,4,2,8,7,4,5,7,5,8};

	//for (int i = 0; i < foo.length; ++i) {
	int i = 7;
	System.out.println(QuickSort.quickselect(foo, i, 0, foo.length - 1));
	//}
    }
}
