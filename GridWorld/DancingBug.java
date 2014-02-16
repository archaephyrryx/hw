import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
    private int steps;
    private int len;
    private int[] DancePattern;

    public DancingBug(int[] pattern)
    {
	steps = 0;
	len = pattern.length;
	DancePattern = new int[len];
        for (int i = 0; i < len; ++i) {
	    DancePattern[i] = pattern[i];
	}
    }

    public void act()
    {
	int i = DancePattern[steps % len];
	while (i > 0) {
	    turn();
	    --i;
	}
	while (!(canMove())) {
	    turn();
	}
	move();
	steps++;
    }
}
