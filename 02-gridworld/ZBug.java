import info.gridworld.actor.Bug;

public class ZBug extends Bug
{
    private int steps;
    private int phase;
    private int sideLength;

    public ZBug(int length)
    {
        steps = 0;
	phase = 0;
        sideLength = length;
	turn();
	turn();
    }

    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
	    if (phase == 0) {
		for (int i = 0; i < 3; ++i) { turn(); }
	    } else if (phase == 1) {
		for (int i = 0; i < 5; ++i) { turn(); }
	    }
	    if (phase == 2) { return; }
	    phase++;
	    steps = 0;
        }
    }
}
