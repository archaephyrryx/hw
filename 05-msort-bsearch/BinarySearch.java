import java.util.Arrays;

public class BinarySearch {

	public static int rbinsearch(int[] a, int n) {
		return rbinsearch(a, n, 0);
	}

	private static int rbinsearch(int[] a, int n, int f) {
		int l = a.length;
		if (l == 0)
			return -1;
		int m = (l-1)/2;
		if (n == a[m]) {
			return (f + m);
		}
		if (n < a[m]) {
			return rbinsearch(Arrays.copyOfRange(a, 0, m), n, f);
		}
		if (n > a[m]) {
			return rbinsearch(Arrays.copyOfRange(a, m+1, l), n, f+m+1);
		}
		return -1;
	}

	public static int ibinsearch(int[] a, int n) {
		int f = 0;
		int c = a.length - 1;
		int m;
		while (f < c) {	
			if (n < a[f] || n > a[c])
				return -1;
			if (n == a[f])
				return f;
			if (n == a[c])
				return c;
			
			m = (f+c)/2;
			if (n == a[m]) {
				return m;
			}
			if (n < a[m]) {
				c = m - 1;
				continue;
			}
			if (n > a[m]) {
				f = m + 1;
				continue;
			}
		}
		if (f == c && n == a[f])
			return f;
		return -1;
	}

	public static void main( String[] args ) {

		int foo[] = new int[63];

		for (int i = 0, j = 0; i < 63; ++i, j += 2) {
			foo[i] = j;
			System.out.printf("%d ", j);
		}

		System.out.println();
		for (int k = 0; k < 125; ++k) {
			System.out.printf("%d: %d | %d\n", k, rbinsearch(foo,k), ibinsearch(foo,k));
		}	


	}
}