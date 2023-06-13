package world;
public class WorldContest
{
    private static boolean completed;
    /**
     * This method returns the cost that caused us to conquer the world
     * @ param nations, nations is the number of nations in the world
     * @ param routes, routes are the respective routes between nations y their cost
     * @ param armies, armies are the current navies and the ones that a nation needs to be conquered
     * @ return costs, costs is the cost after conquer the world
     */
    public static int solve(int nations, int[][] routes, int[][] armies){
        World world = new World(nations, routes, armies);
        world.solve();
        int costs = world.payments();
        return costs;        
    }
    /**
     * This method simulate the conquest of the world
     * @ param nations, nations is the number of nations in the world
     * @ param routes, routes are the respective routes between nations y their cost
     * @ param armies, armies are the current navies and the ones that a nation needs to be conquered
     * @ param slow, slow is the velocity
     */
    public static void simulate(int nations,int[][] routes, int[][] armies, boolean slow){
        World world = new World(nations, routes, armies);
        world.solve();        
    }
    /**
     * This method returns if the last action could be done or not
     * @ return completado, completado is the last actión executed or not
     */
    public static boolean ok(){
        return completed;
    }
}
