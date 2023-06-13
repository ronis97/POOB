package world;
import shapes.*;
import java.util.*;
/**
 * The Nation class allows adding them to
 * the world canvas, contain armies, be
 * conquered and others
 * 
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
 */
public class Nation
{
    private final int ANCHO = 20;
    private final int ALTO = 20;
    private String color;
    private int xPosition,yPosition;
    private Rectangle world;
    private Rectangle visual;
    private Rectangle marca = new Rectangle(ALTO/2,ANCHO/2);
    private ArrayList<Route> properRoutes = new ArrayList<Route>();
    private boolean conquered;
    private boolean isVisible;
    private Army army;
    private int nNation;
    private Data data;
    private ArrayList<Route> copyRoutes = new ArrayList<Route>();
    
    /**
     * Creates a nation 
     * @ param color, color is the color of the nation
     * @ param x, x is the x position of the nation
     * @ param y, y is the y position of the nation
     * @ param nArmies, nArmies is the number of armed of the nation
     * @ param armiesToConquer, armiesToConquer is the number of armies to conquer the nation 
     * @ param world, world is the world where the nation is
     * @ param nNation, nNations is the number the nations in the world
     */
    
    public Nation(String color, int x, int y, int nArmies, 
        int armiesToConquer, Rectangle world, int nNation){
        this.color = color;
        this.world = world;
        xPosition = getPositionX(x);
        yPosition = getPositionY(y);        
        isVisible = false;
        visual = new Rectangle(ANCHO,ALTO);
        army= new Army(nArmies,armiesToConquer,visual);
        this.nNation = nNation;
        configureVisual();
    }
    /**
     * Creates a nation 
     * @ param armiesToConquer, armiesToConquer is the number of armies to conquer the nation 
     * @ param actualArmies, actualArmies is the number of armed of the nation
     * @ param world, world is the world where the nation is
     * @ param nations, nations are the nations in the world
     * @ param nNation, nNations is the number the nations in the world
     */
    public Nation(int armiesToConquer, int actualArmies, Rectangle world,
        ArrayList<Nation> nations,int nNation){
        this.world = world;
        data = new Data(world.getWidth(), world.getHeight());
        isVisible = false;
        putData(nations);
        visual = new Rectangle(ANCHO,ALTO);
        army = new Army(actualArmies,armiesToConquer,visual);
        this.nNation = nNation;
        configureVisual();
    }
    /**
     * This method return if a nation is connected
     * @ param nation, nation is the nation to check if it is connected
     * @ return connected, connected returns if the nation is connected or not
     */
    public boolean isConnected(String nation){
        boolean connected = false;
        for (Route i: properRoutes){
            if (i.getNation2().equals(nation)) connected = true;
        }
        return connected;
    }
    
    /**
     * This method returns the Y coordinate of 
     * the world canvas.
     * @ return YPosition, YPosition is the Y coordinate of the world canvas
     */
    public int extractYCoordinate(){
        return world.getYPosition();
    }
    /**
     * This method returns the X coordinate of 
     * the world canvas.
     * @ return XPosition, XPosition is the X coordinate of the world canvas
     */
    public int extractXCoordinate(){
        return world.getXPosition();
    }
    /**
     * This method returns the x coordinate of the
     * nation which must be within the world canvas
     * @ return xPosition, xPosition fits the canvas of the world
     */
    public int getXPos(){
        return this.xPosition+ANCHO/2;
    }
    /**
     * This method returns the y coordinate of the
     * nation which must be within the world canvas
     * @ return yPosition, yPosition fits the canvas of the world
     */
    public int getYPos(){
        return this.yPosition+ALTO/2;
    }
    /**
     * This method returns the number of armed
     * @ return nArmies, nArmies is the number of armed
     */
    public int getArmies(){
        return army.getActualArmy();
    }
    /**
     * This method returns the nation's armies
     * @ return army, army is the armies in the nation
     */
    public Army getObjArmy(){
        return this.army;
    }
    /**
     * This method returns if there is a copy of the routes
     * @ return boolean, boolean the copies of the routes
     */
    public boolean existsCopyRoutes(){
        if (copyRoutes.size() != 0) return true;
        return false;
    }
    /**
     * This method returns the copied routes
     * @ return copyRoutes, copyRoutes are the routes copied 
     */
    public ArrayList<Route> getCopy(){
        return copyRoutes;
    }
    /**
     * This method returns whether a natio is conquered or not
     * @ return conquered, conquered say if it is true or false
     */
    public boolean conquest(){
        this.conquered = army.isConquered();
        update();
        return conquered;
    }
    /**
     * This method clean the copied routes
     */
    public void clear(){
        copyRoutes.clear();
    }
    /**
     * This method returns the number of nations in the world
     * @ return nNation, nNation is the number the nations in the world 
     */
    public int getidNation(){
        return this.nNation;
    }
    /**
     * This method returns the color of the nation
     * @ return color, color is the identifier of the nation
     */
    public String getColor(){
        return this.color;
    }
    /**
     * This method locates the nation on the canvas of the world 
     * with its respective color and strict location
     */
    public void configureVisual(){
        clear();
        visual.changeColor(color);
        visual.changePosition(xPosition, yPosition);
        army.putArmies();
        if (army.isConquered()){
            if (isVisible) marca.makeVisible();
            marca.changeColor("black");
            marca.changePosition(xPosition+5, yPosition+5);
        }
        else marca.changeColor(color);
    }
    /**
     * This method updates the nation's data
     */
    public void update(){        
        configureVisual();
        if (isVisible) makeVisible();
    }
    /**
     * This method makes the nation visible
     */
    public void makeVisible(){
        isVisible = true;
        visual.makeVisible();
        if(conquered)marca.makeVisible();
    }
    /**
     * This method makes the nation invisible
     */
    public void makeInvisible(){
        isVisible = false;
        marca.makeInvisible();
        visual.makeInvisible();
    }
    /**
     * This method adds an army to a nation
     */
    public void addArmy(){
        army.addArmy();
        update();
    }
    /**
     * This method removes an army from a nation
     */
    public void delArmy(){
        army.delArmy();
        update();
    }
    /**
     * This method adds a route of the nation with another
     * @ param ruta, ruta is the new route for the nation with another
     * @ param rutas, rutas is added to the world is routes
     * @ param nation2, nation2 is the nation with which a route will be created
     */
    public void addRoute(Route ruta, ArrayList<Route> rutas,Nation nation2){
        rutas.add(ruta);
        properRoutes.add(ruta);
        nation2.addRoute(ruta);
    }
    /**
     * This method adds a new route to the nation is own routes 
     * @ param ruta, ruta will be added to the nation is own routes
     */
    public void addRoute(Route ruta){
        if (!properRoutes.contains(ruta))properRoutes.add(ruta);
    }
    /**
     * This method removes a nation from the world canvas
     */
    public void delNation(ArrayList<Route> rutas){
        this.makeInvisible();
        copy();
        for(Route i: properRoutes) i.delRoute(rutas);
        rutas.removeAll(properRoutes);
    }
    /*
     * This method returns the Y coordinate of the nation
     * of the taking into account the world canvas
     * @ param yPosition, yPosition is the Y coordinate of the antion
     */
    private int getPositionY(int yPosition){
        int total = world.getHeight();
        if (yPosition == 0) return total - yPosition + 
            world.getYPosition() - ALTO;
        return total - yPosition + world.getYPosition();
    }
    /*
     * This method returns the X coordinate of the nation
     * of the taking into account the world canvas
     * @ param xPosition, xPosition is the X coordinate of the nation
     */
    private int getPositionX(int xPosition){
        int total = world.getXPosition();
        if (xPosition == 0) return total + xPosition;
        return total + xPosition-ANCHO;
    }
    /*
     * This methos put the data of the nations
     * @ param nations, nations are the nations in the world
     */
    private void putData(ArrayList<Nation> nations){
        data.change();
        while(searchCollisions(data.getposX(), data.getposY(), nations))data.change();
        this.color = data.getColor();
        xPosition = getPositionX(data.getposX());
        yPosition = getPositionY(data.getposY());
    }
    /*
     * This method returns is a nation is already in a position
     * @ param x, x is the x coordinate of the nation
     * @ param y, y is the y coordinate of the nation
     * @ param nations, nations are the nations in the world
     * @ return true, true if there is already a nation in that position
     */
    private boolean searchCollisions(int x, int y, ArrayList<Nation> nations){
        for (Nation i: nations){
            if (i.getXPos() == x && i.getYPos() == y)return true;
        }
        return false;
    }
    /*
     * This method adds a broken copy to own routes
     */
    private void copy(){
        copyRoutes.addAll(properRoutes);
    }
}
