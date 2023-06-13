package world;
import shapes.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 * The world class have on its canvas the nations 
 * with their armies and routes berween them
 *
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
 */
public class World
{
    private Rectangle world;
    private ArrayList<Nation> nations = new ArrayList<Nation>();
    private ArrayList<Route> routes = new ArrayList<Route>();
    private ArrayList<String> conqueredNtions = new ArrayList<String>();
    private boolean isVisible;
    private boolean completado;
    private boolean conquered;
    private int costs;
    private int nNation = 1;
    private Stack<Action> redo;
    private Stack<Action> undo;
    private boolean lastAction;
    private boolean velocity = false;
    private boolean fromAction = false;
    //Start mini-cycle one
    /**
     * Create a rectangle given the height and width
     * @ param lenght, lenght is the lenght of the rectangle
     * @ param width, width is the width of the rectangle
     */
    public World(int lenght, int width){
        world = new Rectangle(lenght,width);
        costs = 0;
        completado = true;
        makeStacks();
    }
    /**
     * Create the canvas of the world with
     * specific nations, routes and armies
     * @ param nations, nations is the number of nations in the world
     * @ param routes, routes are the respective routes between nations y their cost
     * @ param armies, armies are the current navies and the ones that a nation needs to be conquered
     */
    public World(int nations, int routes[][], int armies[][]){
        world = new Rectangle(500,500);
        makeStacks();
        for (int i = 0; i < nations; i++){
            addNation(armies[i][1], armies[i][0]);
        }
        for (int j = 0; j < routes.length; j++){
            addRoute(routes[j][0], routes[j][1], routes[j][2]);
        }
        costs = 0;        
        completado = true;
    }
    
    //End mini-cycle one
    
    //Start mini-cycle two
    /**
     * This method adds a nation
     * @ param color, color is the color of the nation
     * @ param x, x is the x position for the nation is rectangle
     * @ param y, y is the y position for the nation is rectangle
     * @ param armies, armies is the number of armies that 
     * the nation has at the beginning
     */
    public void addNation(String color, int x, int y, int armies){
        try{
            Nation nation = new Nation(color,x,y,armies,0,world,nNation);
            saveNation(nation);  
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    /**
     * This method adds a nation
     * @ param type, type is the type of the nation
     * @ param color, color is the color of the nation
     * @ param x, x is the x position for the nation is rectangle
     * @ param y, y is the y position for the nation is rectangle
     * @ param armies, armies is the number of armies that
     * the nation has at the beginning
     */
    public void addNation(String type, String color, int x, int y, int armies)
    throws WorldException{
        try{
            if (type.equals("Walled")){
                Walled nation = new Walled(color,x,y,armies,0,world,nNation);
                saveNation((Nation)nation);
            }
            else if(type.equals("Aggresive")){
                Aggresive nation = new Aggresive(color,x,y,armies,0,world,nNation);
                saveNation((Nation)nation);
            }
            else{
                throw new WorldException(WorldException.BAD_TYPE_OF_NATION);
            }
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    /**
     * This method adds a nation
     * @ param nation, nation is the nation to add
     */
    //Repensarlo
    //public void addNation(Nation nation){
    //    saveNation(nation);
    //}
    /**
     * This method adds a route between two nations and gives a cost
     * @ param locationA, locationA is the location of the nation one
     * @ param locationB, locationB is the location of the nation two
     * @ param cost, cost is the cost of traveling throungh said route
     */
    public void addRoute(String locationA, String locationB, int cost){
        try{
            Nation nation1 = searchNation(locationA);
            Nation nation2 = searchNation(locationB);
            Route route = new Route(nation1,nation2,cost);
            saveRoute(route);
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    /**
     * This method adds a route between two nations and gives a cost
     * @ param type, type is the type of the route
     * @ param locationA, locationA is the location of the nation one
     * @ param locationB, locationB is the location of the nation two
     * @ param cost, cost is the cost of traveling throungh said route
     */
    public void addRoute(String type, String nationA, String nationB, int cost){
        try{
            Nation nation1 = searchNation(nationA);
            Nation nation2 = searchNation(nationB);
            if (type.equals("Weak")){
                Weak weak = new Weak(nation1,nation2,cost);
                saveRoute((Route)weak);
            }
            else if(type.equals("Dealer")){
                Dealer dealer = new Dealer(nation1,nation2,cost);
                saveRoute((Route)dealer);
            }
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    // End mini-cycle two
    
    // Start mini-cycle three
    /**
     * This method puts an army in a nation
     * @ param location, location is the location of the nation 
     */
    public void putArmy(String location){
        try{
            Nation nation = searchNation(location);
            addArmy(nation);
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    /**
     * This method puts an army in a nation
     * @ param type, type is the type of the army
     * @ param location, location is the location of the nation 
     */
    public void putArmy(String type, String nation){
        try{
            Nation n = searchNation(nation);
            if (type.equals("Fearful")){
                addArmy(n);
            }
            else if (type.equals("Friendly")){
                addArmy(n);
            }
            else{
                throw new WorldException(WorldException.BAD_TYPE_OF_ARMY);
            }
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    /**
     * This method decreases the number of armies a nation has by one
     * @ param location, location is the location of the nation 
     * to erase one of his armies
     */
    public void removeArmy(String location){
        try{
            Nation nation = searchNation(location);
            delArmy(nation);
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    /**
     * This method moves an army from one to another
     * @ param locationA, locationA is the location of the nation one
     * @ param locationB, locationB is the location of the nation two
     */
    public void moveArmyOneRoute(String locationA, String locationB){
        try{
            Nation n1 = searchNation(locationA);
            Nation n2 = searchNation(locationB);
            moveArmyOneRoute(n1,n2);
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    /**
     * This method moves an army from one nation to another
     * with the lowest possible cost
     */
    public void moveArmy(String nationA, String nationB){
        Nation n1 = searchNation(nationA);
        Nation n2 = searchNation(nationB);
        //Implementar algoritmo Dijkstra.
                
    }
    // End mini-cycle three
    
    // Start mini-cycle four
    /**
     * This method eliminates a nation
     * @ param color, color is the identifier of the nation so we delete it
     */
    public void delNation(String color){
        try{
            Nation nation = searchNation(color);
            delNation(nation);
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    /**
     * This method eliminates a route 
     * @ param locationA, locationA is the location of the nation one
     * @ param locationB, locationB is the location of the nation two
     */
    public void delRoute(String locationA, String locationB){
        try{
            Route route = searchRoute(locationA, locationB);
            delRoute(route);
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    // End mini-cycle four
    
    // Start mini-cycle five
    /**
     * This method tries to conquer a given nation
     */
    public void tryToConquer(String nation){
        
    }
    public void solve(){
        for (Nation i: nations){
            tryToConquer(i.getColor());
        }
    }
    /**
     * This method returns the nations that are conquered
     * @ returns
     */
    public String[] conqueredNations(){
        conqueredNationsWithA();
        String[] arr = new String[conqueredNtions.size()];
        for (int i = 0; i < conqueredNtions.size(); i++){
            arr[i] = conqueredNtions.get(i);
        }
        return arr;
    }
    /**
     * This method returns returns the total cost when finally conquering the world
     * @ return  
     */
    public int payments(){
        return this.costs;
    }
    /**
     * This method returns if the world has been conquered or not
     * @ return false or true 
     */
    public boolean conquer(){
        conqueredNations();
        for(Nation i: nations){
            if(!i.conquest()) return false;
        }
        world.changeColor("gray");
        world.setString("El mundo ha sido conquistado");
        update();
        return true;
    }
    // End mini-cycle five
    
    // Start mini-cycle six
    /**
     * This method makes the world visible
     */
    public void makeVisible(){
        isVisible = true;
        world.makeVisible();
        for(Route i: routes) i.makeVisible();
        for(Nation i: nations) i.makeVisible();
        addAction("visible", null);
        completado = true;
    }
    /**
     * This method makes the world invisible
     */
    public void makeInvisible(){
        world.makeInvisible();
        for(Nation i: nations)i.makeInvisible();
        for(Route i: routes) i.makeInvisible();
        isVisible = false;
        addAction("Invisible", null);
        completado = true;
    }
    // End mini-cycle six
    /**
     * This method redoes the last action performed in the simulator
     */
    public void redo() throws WorldException{
        try{
            if (redo.size() == 0) throw new 
                WorldException(WorldException.NO_PREVIOUS_ACTIONS);
            else{
                lastAction = false;
                Action act = redo.pop();
                act.invertAction();
                act.takeAction();
                undo.add(act);
            }
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    /**
     * This method undoes the last action performed in the simulator
     */
    public void undo() throws WorldException{
        try{
            if (undo.size() == 0) throw new 
                WorldException(WorldException.NO_PREVIOUS_ACTIONS);
            else {
                lastAction = false;
                Action act = undo.pop();
                act.takeAction();
                redo.add(act);
            }
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    // Start mini-cycle seven
    /**
     * This method ends whatever operation is being performed
     */
    public void finish(){
        System.exit(0);
    }
    /**
     * This method returns if the last action could be done or not
     * @ return completado, completado is the last actión executed or not
     */
    public boolean ok(){
        return completado;
    }
    public void setVelocity(boolean simulate){
        this.velocity = simulate;
    }
    /// End mini-cycle seven
    /*
     * This method displays the message if an operation 
     * is not completed.
     * @ param message, message is the message it will show
     */
    private void presentMessage(WorldException we){
        if (isVisible) JOptionPane.showMessageDialog(null, we.getMessage());
        completado = false;
    }
    /*
     * This method searches for a nation by color
     * @ param color, color is the color for search the nation
     */
    private Nation searchNation(String color){
        for (Nation i: nations){
            if (i.getColor().equals(color)) return i;
        }
        return null;
    }
    /*
     * This method searches for a nation by your identifier
     * @ param idNation, idNation is the identifier for search the nation
     */
    private Nation searchNation(int idNation){
        for (Nation i: nations){
            if (i.getidNation() == idNation) return i;
        }
        return null;
    }
    /*
     * This method lloks for a route thrugh their nations
     * @ param locationA, locationA is the location of the nation one
     * @ param locationB, locationB is the location of the nation two
     */
    private Route searchRoute(String locationA, String locationB){
        for (Route i: routes){
            if (i.searchRoute(locationA, locationB)){ 
                return i;
            }
        }
        return null;
    }
    /*
     * This method updates the simulator
     */
    private void update(){
        completado = true;
        if (isVisible) makeVisible();
    }
    /*
     * this method returns the nations that have already conquered
     * @ return conqueredNtions, conqueredNtions are the conquered nations 
     */
    private ArrayList<String> conqueredNationsWithA(){
        for (Nation i: nations){
            if (i.conquest()) conqueredNtions.add(i.getColor());
        }    
        return conqueredNtions;
    }  
    /*
     * This method saves the nation as long as it is not found.
     * @ param nation, nation is the nation to save
     */
    private void saveNation(Nation nation) throws WorldException{
        if (!nations.contains(searchNation(nation.getColor()))){
            nNation ++;            
            nations.add(nation);
            if (nation.existsCopyRoutes()){
                ArrayList<Route> copies = nation.getCopy();
                for (Route i: copies){
                    String n1 = i.getNation1();
                    String n2 = i.getNation2();
                    addRoute(n1, n2, i.getCost());
                }
            }
            update();
            addAction("add", nation);
        }
        else{
            throw new WorldException(WorldException.EXISTING_NATION);
        }
    }
    /*
     * This method saves a route as long as it is not found or the nations are found
     * and their respective cost
     * @ param nation1, nation1 is the nation one to save the route
     * @ param nation2, nation2 is the nation two to save the route
     * @ param cost, cost is the cost of the route
     */
    private void saveRoute(Route route) throws WorldException{
        if(!routes.contains(searchRoute(route.getNation1(),route.getNation2()))){            
            Nation n1 = searchNation(route.getNation1());
            Nation n2 = searchNation(route.getNation2());
            n1.addRoute(route, routes, n2);
            update();
            addAction("add", route);
        }
        else{
            throw new WorldException(WorldException.ROUTE_FOUND_OR_NATIONS_NOT_FOUND);
        }
    }
    /*
     * This method adds an army to a nation
     * @ param nation, nation is the nation to add the army
     */
    private void addArmy(Nation nation) throws WorldException{
        if (nation != null){
            nation.addArmy();
            update();
            addAction("put", nation);
        }
        else {
            throw new WorldException(WorldException.NATION_NOT_FOUND);
        }
    }
    /*
     * This method removes an army to a nation
     * @ param nation, nation is the nation to remove the army
     */
    private void delArmy(Nation nation) throws WorldException{
        if (nation != null){
            if (nation.getArmies() > 0){
                nation.delArmy();
                update();
                addAction("delete", nation);
            }
            else {
                throw new WorldException(WorldException.NATION_WITHOUT_ARMIES);
            }
        }
        else{
            throw new WorldException(WorldException.NATION_NOT_FOUND);
        }
    }
    /*
     * This method adds a nation
     * @ param actualArmies, actualArmies are the current armies in the nations
     * @ param armiesToConquer, armiesToConquer are the armies that 
     * the nation neds to be conquered
     */
    private void addNation(int actualArmies, int armiesToConquer){
        try{
            Nation nation = new Nation(actualArmies, armiesToConquer,world, nations,nNation);
            saveNation(nation);
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    /*
     * This method adds a route between two nations with respective identifier, and gives a cost
     * @ param idNation1, idNation1 is the identifier of the nation one
     * @ param idNation2, idNation2 is the identifier of the nation two
     * @ param cost, cost is the cost of traveling throungh said route
     */
    private void addRoute(int idNation1, int idNation2, int cost){
        try{
            Nation nation1 = searchNation(idNation1);
            Nation nation2 = searchNation(idNation2);
            Route route = new Route(nation1,nation2,cost);
            saveRoute(route);
        }
        catch(WorldException we){
            presentMessage(we);
        }
    }
    /*
     * This method eliminates a nation
     * @ param nation, nation is the nation to eliminate 
     */
    private void delNation(Nation nation) throws WorldException{
        if (nation != null){
            nation.delNation(routes);
            nations.remove(nation);
            update();
            addAction("delete",nation);
        }
        else {
            throw new WorldException(WorldException.NOT_EXISTING_NATION);
        }
    }
    /*
     * This method eliminates a route
     * @ param route, route is the route to eliminate 
     */
    private void delRoute(Route route) throws WorldException{
        if (route != null){
            //costs -= route.getCost();
            route.delRoute(routes);
            update();
            addAction("delete", route);
        }
        else {
            throw new WorldException(WorldException.ROUTE_NOT_FOUND);
        }
    }
    /*
     * This method moves an army from one to another
     * @ param nation1, nation1 is the nation where is the army
     * @ param nation2, nation2 is the nation where will we move the army
     */
    private void moveArmyOneRoute(Nation nation1, Nation nation2)
        throws WorldException{
        if (nation1 == null || nation2 == null){
            throw new WorldException(WorldException.SOME_NATION_NOT_FOUND);
        }
        else{
            if (nation1.isConnected(nation2.getColor())){
                if (velocity){
                    Canvas canvas = Canvas.getCanvas();
                    canvas.wait(2000);
                }
                addArmy(nation1);
                delArmy(nation2);
                completado = true;
            }
            else{
                throw new WorldException(WorldException.NATIONS_NOT_CONNECTED);
            }
        }
    }
    /*
     * This method performs the stacks for the last actions done in the simulator
     */
    private void makeStacks(){
        redo = new Stack<Action>();
        undo = new Stack<Action>();
        lastAction = true;
    }
    /*
     * This method adds an action to the redo and undo stacks
     */
    private void addAction(String accion,Object object){
        if(lastAction) {
            Action act = new Action(accion,object,this);
            if (undo.size() != 0){
                if (!undo.peek().equals(act)) undo.add(act);
            }
            else{
                undo.add(act);
            }
        }
        lastAction = true;
    }
}
/** Retrospectiva Ciclo # Final
 * 1. ¿Cuáles fueron los mini-ciclos definidos? Justifíquenlos.
 *    Los mini-ciclos elegidos fueron:
 *    1. Construción: con estos construimos el lienzo del mundo
 *    2. Agragación: con estos podeos adicionar nuevos elementos al lienzo del mundo
 *    3. Modificación: con estos podemos modificar lo que se haya agregado al lienzo del mundo
 *    4. Eliminación: con estos pidemos eliminar los que se hayan agregado al lienzo del mundo
 *    5. Retornación: con esto podemos conseguir datos 
 *    6. Visualización: con estos podemos ver o no el lienzo del mundo
 *    7. Sistema: con estos podemos verificar cada accion del sistema
 *    
 * 2. ¿Cuál es el estado actual del laboratorio en términos de mini-ciclos? ¿por qué?
 *    En el estado actual del laboatorio logramos llegar hasta el mini-ciclo numero 7.
 *    Es decir, que hemos finalizado por completo el segundo ciclo de entrega del 
 *    proyecto the conquer world.
 *    
 * 3. ¿Cuál fue el tiempo total invertido por cada uno de ustedes? (Horas/Hombre)
 *    El tiempo total invertido para la entrega del primer ciclo de laboratorio es:
 *    (15 Horas - Ronaldo Henao)
 *    (15 Horas - Cesar Vásquez)
 *    
 * 4. ¿Cuál consideran fue el mayor logro? ¿Por qué?
 *    El mayor logro es hacer de una manera interactiva la interfaz para así lograr entender el problema
 *    de una mejor manera donde lo asimilamos mucho con el tema de grafos. Creemos que entendiendo bien 
 *    graficamente lo que está sucediendo podemos codificar de una buena forma probando y resolviendo lo
 *    que se quiere.
 *    
 * 5. ¿Cuál consideran que fue el mayor problema técnico? ¿Qué hicieron para resolverlo?
 *    El mayor problema técnico para nosotros fue en cierta parte usar de manera correcta Git, 
 *    pues se nos ha dificultado trabajar por comandos que no conocemos y demás, pero es algo que
 *    solucionamos a lo largo del trabajo.
 * 
 * 6. ¿Qué hicieron bien como equipo? ¿Qué se comprometen a hacer para mejorar los resultados?
 *    Lo que hicimos bien como equipo fue entender el problema, o explicarnos mutuamente si el otro no
 *    entendia. Aparte de eso realizamos el diseño y codificación de manera ordenada y aportando.
 *    Para mejorar resultados claramente hay que dedicarle más tiempo, trabajar más unidos, consultar
 *    dudas con el monitor y profesores que nos puedan ayudar, tambien leer mucho para enteder como 
 *    funcionan nuevas cosas y demás.
 *    
 * 7. Considerando las prácticas XP del laboratorio. ¿cuál fue la más útil? ¿por qué? 
 *    La practica más util fue la de All production code is pair programmed.
 *    Ya que codificamos de manera correcta juntos, aportando, diciendo, dando ideas, entre
 *    otras cosas que se trabajan en equipo.
 *    
 */
// Entrada estandar



