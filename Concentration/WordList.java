public class WordList {

    private ArrayList myList; // contains Strings made up of letters

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
    }

    public void removeWordsOfLength(int len) { 
	for (int i = 0; i < myList.size(); ++i) {
	    if (myList.get(i).length() == len) {
		myList.remove(i);
	    }
	}
    }
}
