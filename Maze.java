import java.io.*;
import java.util.*;

class Maze {
    private char[][] grid;
    private int h,w;
    private boolean solved = false;
    private final char me = '@';
    private final char path = '#';
    private final char trod = '.';
    private final char wall = ' ';
    private final char exit = '$';

    public Maze(String filename)
    {
	grid = new char[80][25];
	h=0;
	w=0;
	try {
	    FileInputStream fstream=new FileInputStream(filename);
	    DataInputStream in = new DataInputStream(fstream);
	    while (in.available()!=0)
		{
		    String line = in.readLine();
		    if (w==0)
			w = line.length();
		    for (int i=0;i<line.length();i++)
			{
			    grid[i][h]=line.charAt(i);
			}
		    h++;
		}
	    in.close();
	    }
	catch (Exception e) {
	    System.err.println("File Input Error");
	}
    }

    public String toString()
    {
	String s = "[0;0H";

	int i,j;
	for (i=0;i<h;i++)
	    {
		for (j=0;j<w;j++)
		    {
			s = s + grid[j][i];
		    }

		s = s + "\n";
	    }
	return s;
    }

    private void delay(int wait) {
	try {
	    Thread.sleep(wait);
	} catch (InterruptedException e) {
	    System.exit(0);
	}
    }

    public void solve(int x, int y, int dir) {
	if (grid[x][y] == exit) {
	    solved = true;
	    System.out.println(this);
	} else if (grid[x][y] == path) {
	    delay(75);
	    grid[x][y] = me;
	    System.out.println(this);
	    for (int i = -1; i <= 2; ++i) {
		int ndir = (dir + i + 4)%4;
		solve(x + (1 - ndir%2)*(1 - ndir), y + (ndir%2)*(2 - ndir), ndir);
		if (solved)
		    break;
	    }
	    grid[x][y] = trod;
	}
    }

    public static void main(String[] args)
    {
	Maze m = new Maze("maze.dat");

	System.out.println("[2J");
	System.out.println(m);
	m.solve(2,3,0);
    }


}
