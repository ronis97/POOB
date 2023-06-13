
import java.util.*;
/**
 * Laboratorio 1 POOB
 * Autores: Michael Perilla - Ronaldo Henao
 */
public class Dicese
{
    
    private ArrayList<Dice> Dices;
    private ArrayList<Integer> numeros;
    private int numero_ganadas = 0;
    private int numero_partidas = 0;
    private boolean isVisible = false;
    /**
     * Constructor
     */
    public Dicese(int n)
    {
        Dices = new ArrayList<Dice>();
        numeros = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            Dice dice = new Dice();
            moveDice(dice, i);
            Dices.add(dice);
            numeros.add(0);
        }
        //
    }
    /**
     * Extrae los numeros de la fila de dados
     */
    public ArrayList<Integer> getnumeros(){
        return this.numeros;
    }
    public ArrayList<Dice> getDices(){
        return this.Dices;
    }
    /**
     * Toma los valores de los dados y los reune en
     * un array de enteros.
     */
    private void asignar(){
       
        for (int i = 0; i < Dices.size(); i++){
            numeros.set(i, Dices.get(i).getValue());          
        }
        //System.out.println(numeros);
    }
    /**
     * Mueve el dado una cantidad "times" de veces
     */
    private void moveDice(Dice dice, int times){
        for(int i = 0; i<times; i++){
            dice.moveHorizontal(100);
        }
    }
    /**
     * Hace visible la fila de dados
     */
    public void makeVisible(){
        for (Dice i: Dices){
            i.makeVisible();
        }
        asignar();
        isVisible = true;
    }
    /**
     * Hace invisible la fila de dados
     */
    public void makeInvisible(){
        for (Dice i: Dices){
            i.makeInvisible();
        }
        isVisible = false;
    }
    /**
     * Hace rodar los dados de la fila
     */
    public void play(){
        //makeVisible();
        for (Dice i: Dices){
            i.roll();
        }
        asignar();
        if (isWinningState()) numero_ganadas ++;
        numero_partidas ++;
    }
    /**
     * Define si los dados estan ordenados ascendente
     * o descendentemente, en tal caso se dice que estamos
     * en un estado ganador
     */
    public boolean isWinningState(){
        ArrayList<Integer> antiguo = new ArrayList<Integer>(numeros);
        ArrayList<Integer> reves = new ArrayList<Integer>(numeros);
        //System.out.println(antiguo);
        Collections.sort(reves, Collections.reverseOrder());
        //System.out.println(reves);             
        Collections.sort(numeros);
        //System.out.println(numeros);   
        if (antiguo.equals(numeros) || reves.equals(numeros)) return true;
        return false;
    }
    /**
     * Lanza una cantidad "times" de veces los dados
     */
    public void play(int times){
        Canvas canvas = Canvas.getCanvas();
        for (int i = 0; i < times; i++){
            play();
            //canvas.wait(2000);
        }
    }
    /**
     * Saca un dado de la fila, usado en el Bidicese
     */
    public Dice extraerDado (int posicion){
        return this.Dices.get(posicion);
    }
    /**
     * Juega un dado indicado la posicion del dado en la fila
     */
    public void jugarDice(int posicion){
        play(Dices.get(posicion));
    }
    private void play(Dice dado){
        dado.roll();
    }
    /**
     * Devuelve el porcentaje de partidas ganadas del numero
     * de partidas jugadas
     */
    public int percentageOfWinningStates(){        
        return (int)((numero_ganadas*100)/numero_partidas);        
    }
    /**
     * Resetea el contador de partidas jugadas y ganadas
     */
    public void reset(){
        numero_ganadas = 0;
        numero_partidas = 0;
    }
    /**
     * Mueve la fila de dados, vertical u horizontalmente
     */
    public void move(int horizontal, int vertical){
        for (Dice i: Dices){
            i.moveHorizontal(horizontal);
            i.moveVertical(vertical);
        }
    }   
}
