import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;

public class Jumper extends Actor
{
    public Jumper()
    {
        setColor(Color.RED);
    }

    public Jumper(Color jumperColor)
    {
        setColor(jumperColor);
    }

    public void act()
    {
        if (canMove())
            move();
        else
            turn();
    }

    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }

    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location target = next.getAdjacentLocation(getDirection());
        if (gr.isValid(target))
            moveTo(target);
        else
            removeSelfFromGrid();
    }

    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location target = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(target))
            return false;
        Actor neighbor = gr.get(target);
        return (neighbor == null) || (neighbor instanceof Flower);
    }
}
