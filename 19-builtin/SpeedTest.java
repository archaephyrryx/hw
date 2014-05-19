import java.util.*;

public class SpeedTest {

    public static void main ( String[] args ) {
	long t;
	long s;
	HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
	TreeMap<Integer,Integer> treemap = new TreeMap<Integer,Integer>();

	t = System.nanoTime();
	for (int i = 0; i < 10000; ++i) {
	    hashmap.put(new Integer((int) (Math.random() * 10000 * i)), new Integer((int) Math.random() * 10000 * i));
	}
	s = System.nanoTime();
	System.out.printf("HashMap: 10000 additions in\t\t %10d ns\n", s-t);

	t = System.nanoTime();
	for (int i = 0; i < 10000; ++i) {
	    hashmap.containsKey(new Integer((int) (Math.random() * 10000 * i)));
	}
	s = System.nanoTime();
	System.out.printf("HashMap: 10000 keysearches in\t\t %10d ns\n", s-t);

	t = System.nanoTime();
	for (int i = 0; i < 10000; ++i) {
	    hashmap.containsValue(new Integer((int) (Math.random() * 10000 * i)));
	}
	s = System.nanoTime();
	System.out.printf("HashMap: 10000 valuesearches in\t\t %10d ns\n", s-t);

	t = System.nanoTime();
	hashmap.keySet();
	s = System.nanoTime();
	System.out.printf("HashMap: key set found in\t\t %10d ns\n", s-t);

	t = System.nanoTime();
	hashmap.values();
	s = System.nanoTime();
	System.out.printf("HashMap: values found in\t\t %10d ns\n", s-t);


	t = System.nanoTime();
	for (int i = 0; i < 10000; ++i) {
	    treemap.put(new Integer((int) (Math.random() * 10000 * i)), new Integer((int) Math.random() * 10000 * i));
	}
	s = System.nanoTime();
	System.out.printf("TreeMap: 10000 additions in\t\t %10d ns\n", s-t);

	t = System.nanoTime();
	for (int i = 0; i < 10000; ++i) {
	    treemap.containsKey(new Integer((int) (Math.random() * 10000 * i)));
	}
	s = System.nanoTime();
	System.out.printf("TreeMap: 10000 keysearches in\t\t %10d ns\n", s-t);

	t = System.nanoTime();
	for (int i = 0; i < 10000; ++i) {
	    treemap.containsValue(new Integer((int) (Math.random() * 10000 * i)));
	}
	s = System.nanoTime();
	System.out.printf("TreeMap: 10000 valuesearches in\t\t %10d ns\n", s-t);

	t = System.nanoTime();
	treemap.keySet();
	s = System.nanoTime();
	System.out.printf("TreeMap: key set found in\t\t %10d ns\n", s-t);

	t = System.nanoTime();
	treemap.values();
	s = System.nanoTime();
	System.out.printf("TreeMap: values found in\t\t %10d ns\n", s-t);
    }
}
