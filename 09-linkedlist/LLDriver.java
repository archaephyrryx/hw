public class LLDriver {
    public static void main( String[] args ) {
	LinkedList L = new LinkedList();

	L.add("Sully");
	System.out.println(L);
	L.add("Mike");
	System.out.println(L);
	L.add("Randall");
	System.out.println(L);
	L.add(2, "Randall");
	System.out.println(L);
	L.set(3, "Munroe");
	System.out.println(L);
	L.remove(1);
	System.out.println(L);
	L.remove(0);
	System.out.println(L);
	System.out.println(L.find("Randall"));
    }
}
