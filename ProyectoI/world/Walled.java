
package world;
import shapes.*;
import java.util.ArrayList;

/**
 * The Nation walled class allows adding them to
 * the world canvas, contain armies, be
 * conquered and others
 * 
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
 */
public class Walled extends Nation
{
    /**
     * Creates a nation walled
     * @ param color, color is the color of the nation
     * @ param x, x is the x position of the nation
     * @ param y, y is the y position of the nation
     * @ param nArmies, nArmies is the number of armed of the nation
     * @ param armiesToConquer, armiesToConquer is the number of armies to conquer the nation 
     * @ param world, world is the world where the nation is
     * @ param nNation, nNations is the number the nations in the world
     */
    public Walled(String color, int x, int y, int nArmies, 
        int armiesToConquer, Rectangle world, int nNation){
        super(color,x,y,nArmies,armiesToConquer,world,nNation);
        }    
}
