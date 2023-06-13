    import java.util.*;
    /**
     * Laboratorio 1 POOB
     * Autores: Michael Perilla - Ronaldo Henao
     */
    public class BiDicese
    {

        private ArrayList<Dicese> filasS;
        private ArrayList<ArrayList<Integer>> numeros;
        private int numero_jugadas = 0;
        private int numero_ganadas = 0;
        /**
         * Constructor
         */
        public BiDicese(int size)
        {
            filasS = new ArrayList<Dicese>();
            numeros = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < size; i++){
                Dicese fila = new Dicese(size);
                moveDicese(fila, i);
                filasS.add(fila);
                numeros.add(fila.getnumeros());
            }
        }
    private void moveDicese(Dicese fila, int times){
            for(int i = 0; i<times; i++){
                fila.move(0, 100);
            }
    }
    /**
     * Hace visible la matriz de dados
     */
    public void makeVisible(){
        for (Dicese i: filasS){
            i.makeVisible();
        }        
    }
    /**
     * Hace invisible la matriz de dados
     */
    public void makeInvisible(){
        for (Dicese i: filasS){
            i.makeInvisible();
        }  
    }
    private void asignar(){
        for(int i = 0; i < numeros.size(); i++){
            numeros.set(i, filasS.get(i).getnumeros());
        }
    }
    /**
     * Juega toda la matriz de dados
     */
    public void play(){
        for (Dicese i:filasS){
            i.play();
        }
        asignar();
        numero_jugadas ++;
        if (isWinningState()) numero_ganadas ++;
    }
    /**
     * Juega una cantidad n de veces la matriz 
     * de dados
     */
    public void play (int times){
        for (int i = 0; i < times; i++) play();
        
    }
    /**
     * Juega una fila de la matriz de dados
     */
    public void playfila(int numerofila){
        filasS.get(numerofila-1).play();
        asignar();
        numero_jugadas ++;
        if (isWinningState()) numero_ganadas ++;
    }
    /**
     * Juega una columna de la matriz de dados
     */
    public void playcolumna(int numerocolumna){
        for (int i = 0; i < filasS.size(); i++){
            filasS.get(i).jugarDice(numerocolumna-1);
        }
        asignar();
        numero_jugadas ++;
        if (isWinningState()) numero_ganadas ++;
    }
    /**
     * Juega un solo dado de la matriz
     */
    public void play(int fila, int columna){
        filasS.get(fila-1).jugarDice(columna-1);
        asignar();
        numero_jugadas ++;
        if (isWinningState()) numero_ganadas ++;
    } 

    private boolean verificarVertical(){
        for (int i = 0; i < filasS.size(); i++){
            if (!verificarOrden(numerosVertical(i))) return false;
        }
        return true;
    }
    private boolean verificarHorizontal(){
        for (int i = 0; i < filasS.size(); i++){
            if (!filasS.get(i).isWinningState()) return false;
        }
        return true;
    }
    private boolean verificarDiagonales(){
        if (verificarOrden(numerosDiagonalder()) && verificarOrden(numerosDiagonalizq())) return true;
        else return false;
    }
    /**
     * Verifica que las filas, columnas y diagonales esten ordenadas
     */
    public boolean isWinningState(){
        if (verificarHorizontal() && verificarVertical() && verificarDiagonales()) {
            numero_ganadas ++; return true;
        } 
        else return false;
    }
    private boolean verificarOrden(ArrayList<Integer> array){
        ArrayList<Integer> antiguo = new ArrayList<Integer>(array);
        ArrayList<Integer> reves = new ArrayList<Integer>(array);
        Collections.sort(reves, Collections.reverseOrder());
        Collections.sort(array);           
        if (antiguo.equals(array) || reves.equals(array)) return true;
        return false;
    }
    private ArrayList<Integer> numerosDiagonalizq(){
        ArrayList<Integer> numerosDizq = new ArrayList<Integer>();
        for (int i = 0; i < filasS.size(); i++){
            numerosDizq.add(filasS.get(i).extraerDado(i).getValue());
        }
        return numerosDizq;
    }
    private ArrayList<Integer> numerosDiagonalder(){
        ArrayList<Integer> numerosDder = new ArrayList<Integer>();
        int cont = 1;
        int n = filasS.size();
        for (int i = 0; i < n; i++){
            numerosDder.add(filasS.get(i).extraerDado(n-cont).getValue());
            cont++;
        }
        return numerosDder;
    }
    private ArrayList<Integer> numerosVertical(int columna){
        ArrayList<Integer> numerosV = new ArrayList<Integer>();
        for (Dicese i:filasS){
            numerosV.add(i.extraerDado(columna).getValue());
        }
        return numerosV;
    }
    public void reset(){
        numero_ganadas = 0;
        numero_jugadas = 0;
    }
    public void changeColor(String color){
        for (Dicese i:filasS){
            for(Dice j: i.getDices()){
                j.changeColor(color);
            }
        }
    }
}
