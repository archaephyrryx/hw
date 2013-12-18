import java.util.ArrayList;

public class WordList {
    private ArrayList<String> _list; // contains Strings made up of letters

    public WordList() {
	_list = new ArrayList<String>();
    }

<<<<<<< HEAD
    public WordList(ArrayList<String> list) {// Constructor with arraylist arg
	this();
	_list.addAll(list);
    }

    public void add(String s) {// Mutator method to append given value
	_list.add(s);
=======
    public Wordlist() {
	String[] list = {"ape","bat","cat","dog","eel","fog","goo","hat"};
	this(list);
    }
    public Wordlist(String[] list) {
	myList = new ArrayList<String>(Array.asList(list));
    }

    public int numWordsOfLength(int len) { 
	int num = 0;
	for (String word : myList) {
	    if (word.length() == len) {
		num++;
	    }
	}
	return num;
>>>>>>> 4f63a56... Foobar edits
    }



    public String get(int i) {// Accessor method for item of given index
	return _list.get(i);
    }

    /* populate:
     * Fills with tiles for all words in _list
     */
    public void populate(ArrayList<Tile> tiles) {
	for (String word : _list) {
	    tiles.add(new Tile(word)); // Adds in pairs
	    tiles.add(new Tile(word));
	}
    }

}
