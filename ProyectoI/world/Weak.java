package world;

/**
 * The route weak class allows them to
 * be added to the world canvas connecting
 * two nations with only one of them
 *
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
 */
public class Weak extends Route
{
    /**
     * Create a route weak between the nations with
     * their default positions.
     * @ param nation1, nation1 is the nation to connected
     * @ param nation2, nation2 is other the nation to connected
     * @ param cost, cost is the cost of the route beeween the nations
     */
    public Weak(Nation nation1, Nation nation2, int cost){
        super(nation1,nation2,cost);
    }
}
