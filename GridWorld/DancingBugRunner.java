import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

public class DancingBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
	int[] foo = {1,3,5,4,2,2,7,2,4,6,1,1,4,1,5,6,2};
        DancingBug alice = new DancingBug(foo);
        alice.setColor(Color.ORANGE);
        world.add(new Location(5, 5), alice);
        world.show();
    }
}
