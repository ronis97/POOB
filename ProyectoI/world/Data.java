package world;
import java.util.Random;

/**
 * The data class are the data that a nation contains
 *
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
 */
public class Data
{
    private int posX;
    private int posY;
    private int limX;
    private int limY;
    private String color;
    private Random r = new Random();
    /**
     * Create the nation data
     * @ param width, width is the x limite to put the nation
     * @ param length, length is the y limite to put the nation
     */
    public Data(int width, int length)
    {
        limX = width;
        limY = length;
        color = randomColor();
    }
    /**
     * This method change the data randomly
     */
    public void change(){
        posX = randomX();
        posY = randomY();
        color = randomColor();
    }
    /**
     * This method returns the x postion of the nation
     * @ return posX, posX is the x postion of the nation
     */
    public int getposX(){
        return posX;
    }
    /**
     * This method returns the y postion of the nation
     * @ return posY, posY is the y postion of the nation
     */
    public int getposY(){
        return posY;
    }
    /**
     * This method returns the y postion of the nation
     * @ return color, color is the color of the nation
     */
    public String getColor(){
        return this.color;
    }
    /*
     * This method return a x position randomly
     * @ return x
     */
    private int randomX(){
        return r.nextInt(limX-50)+50;
    }
    /*
     * This method return a y position randomly
     * @ return y
     */
    private int randomY(){
        return r.nextInt(limY-50)+50;
    }
    /*
     * This method returns a color raandomly
     * @ return res, res is the color random
     */
    private String randomColor(){
        int R = r.nextInt(255) + 1;
        int G = r.nextInt(255) + 1;
        int B = r.nextInt(255) + 1;
        String RR = Integer.toString(R);
        String GG = Integer.toString(G);
        String BB = Integer.toString(B);
        String res = String.join(",",RR,GG,BB);
        return res;
    }
}
