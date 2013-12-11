// Peter Duchovni
// Period 9
// HW 32
// November 25, 2013

import cs1.Keyboard;

public class GuessNumber {
    //instance vars
    private int _lo, _hi, _guessCtr, _target;



    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) {
       	_lo = a;
	_hi = b;
	_guessCtr = 1;
	_target = (int) ( (_hi - _lo) * Math.random() + _lo ); //rand int betwixt Lo and Hi
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:
      post:
      ==================================================*/
    public void playRec() {
	int guess;
	System.out.printf("Guess a number between %d and %d: ",  _lo, _hi); // Formatted prompt
	guess = Keyboard.readInt(); // Read an int
	if (guess > _hi || guess < _lo) { // retry if invalid
	    System.out.println("Invalid guess.");
	    playRec();
	}
	if (guess == _target) {
	    System.out.printf("You have won! It took you %d guesses.\n", _guessCtr);
	} else {
	    _guessCtr++; // Didn't get it
	    if (guess < _target) { // Too low
		System.out.println("Too low.");
		_lo = guess + 1; // Raise floor
	    } else if (guess > _target) { // Too high
		System.out.println("Too high.");
		_hi = guess - 1; // Lower ceiling
	    }
	    playRec(); // Recurse
	}
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:
      post:
      ==================================================*/
    public void playIter() {
	int guess;
	while (true) {
	    System.out.printf("Guess a number between %d and %d: ",  _lo, _hi);
	    guess = Keyboard.readInt();
            if (guess > _hi || guess < _lo) {
	        System.out.println("Invalid guess.");
		continue; // Move along
	    }
	    if (guess == _target) {
		System.out.printf("You have won! It took you %d guesses.\n", _guessCtr);
		break; // break on win
	    } else {
		_guessCtr++; // Guessed wrong
		if (guess < _target) {
		    System.out.println("Too low.");
		    _lo = guess + 1; // raise floor
		} else if (guess > _target) {
		    System.out.println("Too high.");
		    _hi = guess - 1; // lower ceiling
		}
	    }
	}
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() {
        //use one or the other below:
        playRec();
        //playIter();
    }


    //main method to run it all
    public static void main( String[] args ) {

        //instantiate a new game
        GuessNumber g = new GuessNumber(1,100);

        //start the game
        g.play();
    }
}
