package world;
import java.util.Stack;

/**
 * The action class it helps us to look at the actions
 * carried pout in the simulator
 *
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
 */
public class Action
    {
    private String action;
    private Object object;
    private World world;
    private boolean lastAction;
    /**
     * Create a action
     * @param action, action is the action to create
     * @param object, object is the object to create
     * @param world, world is the canvas of world
     */
    public Action(String action, Object object, World world){
        this.action = action;
        this.object = object;
        this.world = world;
        lastAction = false;
        System.out.print(world);
    }
    /**
     * This method change action and object
     */
    public void change(String action,Object object){
        this.action = action;
        this.object = object;
    }
    /**
     * This method returns the action
     * @ return action
     */
    public String getaction(){
        return action;
    }
    /**
     * This method add a new action
     */
    public void add(){
        String typeObject = object.getClass().getName();
        lastAction = true;
        if (typeObject.equals("Nation")){
            Nation nation = (Nation) object;
            //world.addNation(nation);
        }
        else if (typeObject.equals("Route")){
            Route route = (Route) object;
            world.addRoute(route.getNation1(), route.getNation2(),
                route.getCost());
        }
    }
    /**
     * This method puts an army to the nation of the last action
     */
    public void put(){
        Nation nation = (Nation) object;
        nation.addArmy();
    }
    /**
     * This method removes an army to the nation of the last action
     */
    public void quit(){
        Nation nation = (Nation) object;
        nation.delArmy();
    }
    /**
     * This method return the action
     * @ return action
     */
    public String getAction(){
        return action;
    }
    /**
     * This method return the object
     * @ return object
     */
    public Object getObject(){
        return object;
    }
    /**
     * This method removes either the last action made with a nation or route
     */
    public void delete(){
        String typeObject = object.getClass().getName();
        lastAction = true;
        if (typeObject.equals("Nation")){
            Nation nation = (Nation) object;
            world.delNation(nation.getColor());
        }
        else if (typeObject.equals("Route")){
            Route route = (Route) object;
            String nation1 = route.getNation1();
            String nation2 = route.getNation2();
            world.delRoute(nation1, nation2);
        }
    }
    /**
     * This method perform the requested action
     */
    public void takeAction(){
        if (action.equals("add")) delete();
        else if (action.equals("delete")) add();
        else if (action.equals("put")) quit();
        else if (action.equals("quit")) put();
        else if (action.equals("visible")) world.makeInvisible();
        else if (action.equals("Invisible")) world.makeVisible();
    }
    /**
     * This method reverses the action and performs it
     */
    public void invertAction(){
        if (action.equals("add")) action = "delete";
        else if(action.equals("delete")) action = "add";
        else if (action.equals("put")) action = "quit";
        else if (action.equals("delete")) action = "put";
        else if (action.equals("visible")) action = "Invisible";
        else if (action.equals("Invisible")) action = "visible";
    }
    /**
     * This method returns if the action is equal
     * @ param act, act is the action
     * @ return boolean
     */
    public boolean equals(Action act){
        if (action.equals(act.getaction())){ 
            if (object == null) return true;
            else{
                return object.equals(act.object);
            }
        }       
        else {return false;}
    }
}
