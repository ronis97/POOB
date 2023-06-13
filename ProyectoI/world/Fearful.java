package world;
import shapes.*;

/**
 * The army fearful class, they are the armies that each nation has
 * and those that each one needs to be conquered
 *
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
 */
public class Fearful extends Army
{
    /**
     * Create an army fearful
     * @ param actualArmies, actualArmies are the armed forces that the nation has
     * @ param toConquer, toConquer are the armies to conquer a born
     * @ param Figura, Figura is the representation of the armies
     */
    public Fearful(int actualArmies, int toConquer, Rectangle Figura){
        super(actualArmies,toConquer,Figura);
    }
}
