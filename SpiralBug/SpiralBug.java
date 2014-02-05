import info.gridworld.actor.Bug;

public class SpiralBug extends Bug
{
    private int steps;
    private int sideNum;
    private int sideLength;
    private int sideLengthStep;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public SpiralBug(int sidestep)
    {
        steps = 0;
	sideNum = 0;
	sideLength = 0;
        sideLengthStep = sidestep;
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
	    sideLength += sideLengthStep;
            turn();
            turn();
	    sideNum += 1; sideNum %= 4;
            steps = 0;
        }
    }
}
