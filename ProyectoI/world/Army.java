package world;
import shapes.*;
/**
 * The army class, they are the armies that each nation has
 * and those that each one needs to be conquered
 *
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
 */
public class Army
{
    private int needArmiesToConquer;
    private int actualArmies;
    private Rectangle visual;
    /**
     * Create an army
     * @ param actualArmies, actualArmies are the armed forces that the nation has
     * @ param toConquer, toConquer are the armies to conquer a born
     * @ param Figura, Figura is the representation of the armies
     */
    public Army(int actualArmies, int toConquer, Rectangle Figura)
    {
        this.actualArmies = actualArmies;
        needArmiesToConquer = toConquer;
        visual = Figura;
    }
    /**
     * This method if a nation is conquered
     * @ return bandera, bandera returns if it is conquered or not
     */
    public boolean isConquered(){
        boolean bandera = true;
        if (actualArmies < needArmiesToConquer) bandera = false;
        return bandera;
    }
    /**
     * This method puts the armies
     */
    public void putArmies(){
        String nArmy = Integer.toString(this.actualArmies);
        visual.setString(nArmy);
    }
    /**
     * This method adds an army
     */
    public void addArmy(){
        actualArmies++;
        putArmies();
    }
    /**
     * This method remove an army
     */
    public void delArmy(){
        actualArmies--;
        putArmies();
    }
    /**
     * This method returns the current number of arms
     * @ return actualArmies, actualArmies is the number the armies of the nation 
     */
    public int getActualArmy(){
        return this.actualArmies;
    }
}
