
/**
 * Write a description of class prubea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class prubea
{
    Rectangle yellow = new Rectangle();
    Rectangle blue = new Rectangle();
    Rectangle red;
    
    public prubea(){
        Rectangle yellow = new Rectangle();
        Rectangle blue = new Rectangle();
        Rectangle red;
        red = yellow;
        yellow.makeVisible();
        yellow.changeSize(30, 80);
        yellow.changeColor("yellow");
        blue = new Rectangle();
        blue.changeSize(20, 80);
        blue.changeColor("blue");
        blue.moveVertical(30);
        red.changeColor("red");
        red.changeSize(20, 80);
        red.moveVertical(50);
        red.makeVisible();
        blue.makeVisible();
    }
}
