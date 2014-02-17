import java.io.*;
import java.util.*;

class Queens {
    private char board[][];
    private int s;
    private boolean solved;
    private final char queen = 'Q';
    private final char free  = '.';
    private final char range = 'x';

    public Queens( int n ) {
	board = new char[n][n];
	s = n;
	solved = false;

	for (int i = 0; i < s; ++i) {
	    for (int j = 0; j < s; ++j) {
		board[i][j] = free;
	    }
	}
    }

    public String toString()
    {
	String st = "[0;0H";

	int i,j;
	for (i=0;i<s;i++)
	    {
		for (j=0;j<s;j++)
		    {
			st = st + board[i][j];
		    }
		st = st + "\n";
	    }
	return st;
    }

    private void delay(int wait) {
	try {
	    Thread.sleep(wait);
	} catch (InterruptedException e) {
	    System.exit(0);
	}
    }

    private void solve( int x, int y ) {
	if (x >= s) {
	    solved = true;
	    System.out.println(this);
	} else if (board[x][y] == free) {
	    delay(100);
	    board[x][y] = queen;
	    System.out.println(this);

	    boolean mask[][] = new boolean[s][s];

	    for (int i = 0; i < s; ++i) {
		for (int j = 0; j < s; ++j) {
		    if (board[i][j] == free && (x == i || x - i == y - j ||
				                y == j || x - i == j - y)) {
			    mask[i][j] = true;
			    board[i][j] = range;
		    } else {
			mask[i][j] = false;
		    }
		}
	    }
	    for (int n = 0; n < s; ++n) {
		solve( x+1, n );
		if (!solved) {
		    continue;
		} else {
		    break;
		}
	    }
	    board[x][y] = free;
	    for (int i = 0; i < s; ++i) {
		for (int j = 0; j < s; ++j) {
		    if (mask[i][j]) {
			board[i][j] = free;
		    }
		}
	    }
	}
    }

    private void solve() {
	for (int n = 0; n < s && !solved; ++n) {
	    solve( 0, n );
	}
    }




    public static void main( String[] args ) {
	Queens q = new Queens(11);
	System.out.println("[2J");
	System.out.println(q);
	q.solve();
    }
}
