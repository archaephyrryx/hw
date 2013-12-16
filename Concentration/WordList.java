public class WordList {

    private ArrayList myList; // contains Strings made up of letters

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
