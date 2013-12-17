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


    // *** INSERT YOUR CONSTRUCTOR AND METHODS HERE ***
    public Concentration() {
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

    }

 

    //DO NOT MODIFY main()
    public static void main( String[] args ) {
	Concentration game = new Concentration();
	game.play();
    }

}//end class Concentration

