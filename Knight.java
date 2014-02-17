import java.io.*;
import java.util.*;

class Knight {
    private int[][] board;
    private int s;
    private boolean solved = false;

    public Knight(int size)
    {
	board = new int[size][size];
	s = size;

	for (int i = 0; i < size; ++i) {
	    for (int j = 0; j < size; ++j) {
		board[i][j] = 0;
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
			st = st + " ";
			st = st + String.format("%2d", board[i][j]);
			st = st + " ";
		    }

		st = st + "\n";
		st = st + "\n";
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

    public void solve(int x, int y, int count) {
	if (x >= 0 && x < s && y >= 0 && y < s) {
	    if (board[x][y] == 0) {
		if (count == s * s) {
		    solved = true;
		    System.out.println(this);
		} else {
		    board[x][y] = count;
		    if (!solved) solve(x - 2, y - 1, count + 1);
		    if (!solved) solve(x - 2, y + 1, count + 1);
		    if (!solved) solve(x - 1, y - 2, count + 1);
		    if (!solved) solve(x - 1, y + 2, count + 1);
		    if (!solved) solve(x + 1, y - 2, count + 1);
		    if (!solved) solve(x + 1, y + 2, count + 1);
		    if (!solved) solve(x + 2, y - 1, count + 1);
		    if (!solved) solve(x + 2, y + 1, count + 1);
		    board[x][y] = 0;
		}
	    }
	}
    }

    public static void main(String[] args)
    {
	Knight m = new Knight(5);

	System.out.println("[2J");
	System.out.println(m);
	m.solve(0,0,1);
    }


}
