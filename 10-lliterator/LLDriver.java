import java.util.Iterator;

public class LLDriver {
    public static void main( String[] args ) {
	LinkedList<String> L = new LinkedList<String>();

	L.add("Filli");
	L.add("Killi");
	L.add("Oin");
	L.add("Gloin");
	L.add("Biffor");
	L.add("Boffor");
	L.add("Bombur");
	L.add("Thorin");
	L.add("Ori");
	L.add("Nori");

	for (String dwarf : L) {
	    System.out.printf("%s, at your service.\n", dwarf);
	}
    }
}
