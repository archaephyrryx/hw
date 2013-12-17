/*========================================
class Concentration
Facilitates playing game of Concentration,
aka Memory.

eg,
 if _list is initialized to {"ape","bat","cat","dog","eel","fog","goo","hat"}  

 ...then a partial sample run might look like:  
          0	 1	 2	 3
	  4	 5	 6	 7
	  8	 9	10	11
	 12	13	14	15

$ turn over > 1
$ turn over > 4
          0	ape	 2	 3
	  ape    5	 6	 7
	  8	 9	10	11 12	13	14	15 $ turn over> 2 $ turn over> 11
          0	ape     bat      3
	 ape     5	 6	 7
	  8	 9	10	cat
	 12	13	14	15     

$ Not a match

          0	ape	 2	 3
	 ape     5	 6	 7
	  8	 9	10	11
	 12	13	14	15

========================================*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import cs1.Keyboard;

public class Concentration {

    //instance variables
    //storage for 4x4 grid of Tiles. _board.size() == 16	
    private ArrayList<Tile> _board; 

    //count of Tiles with faces visible
    private int _numberFaceUp;  

    //list of Strings used for Tile vals
    private WordList _list;

    private static int _numRows = 4;

    public Concentration() {
<<<<<<< HEAD
	_board = new ArrayList<Tile>(16); // Allocate _board
	_list = new WordList(); // Create _list

	String[] words = {"ape","bat","cat","dog","eel","fog","goo","hat"};

	for (String i : words)
	    _list.add(i);

	_list.populate(_board); // Fill _board from _list

	long seed = System.nanoTime(); // Random seed for initial shuffle
	Collections.shuffle(_board, new Random(seed)); // Shuffle
    }

    public void display() {
	String tileFace;
	for (int i = 0; i < _numRows; ++i) {
	    for (int j = 0; j < (16/_numRows); ++j) {
		tileFace = _board.get(4*i + j).toString();
		if (tileFace.equals("-X-"))
		    tileFace = String.format("%3d", (4*i + j + 1));

		System.out.printf("%s%s", tileFace, ((j == 3) ? "\n" : "\t"));
	    }
	}

    }


    public void play() {
	int solved = 0;
	int first;
	int second;
	Tile firstTile;
	Tile secondTile;
=======
	_board = new ArrayList<Tile>(16);
	_list = new WordList({"ape","bat","cat","dog","eel","fog","goo","hat"});
	Wordlist _copy = _list.clone()

	for (int i = 0; i < 8; --i) {
	    _list.addAll(_list)
	}

	for (int i = 16; i > 0; --i) {
	    int index = (int) (Math.random()*i);
	    _board.add(new Tile(_copy.get(index)));
	    _copy.remove(index);
	}
>>>>>>> 4f63a56... Foobar edits

	display();

	while (solved < _board.size()) {
	    first = 0;
	    second = 0;

	    while (true) {
		System.out.print("$ turn over > ");
		first = Keyboard.readInt();
		--first;

		if (first >= 0 && first < _board.size() && !(_board.get(first).isFaceUp())) {
		    firstTile = _board.get(first);
		    break;
		}

		System.out.println("Invalid entry. Try again.\n");
	    }

	    while (true) {
		System.out.print("$ turn over > ");
		second = Keyboard.readInt();
		--second;

		if (second >= 0 && second < _board.size() && second != first && !(_board.get(second).isFaceUp())) {
		    secondTile = _board.get(second);
		    break;
		}

		System.out.println("Invalid entry. Try again.\n");
		continue;
	    }

	    firstTile.flip();
	    secondTile.flip();
	    
	    display();

	    if (firstTile.equals(secondTile)) {
		solved += 2;
		continue;
	    }

	    System.out.println("$ Not a match\n");
	    firstTile.flip();
	    secondTile.flip();
	    display();
	}
    }

 

 

    //DO NOT MODIFY main()
    public static void main( String[] args ) {
	Concentration game = new Concentration();
	game.play();
    }

}//end class Concentration

