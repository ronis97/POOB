package aplicacion;

import java.awt.Color;

public abstract class Persona {

    public final static int ARRIBA=0;
    public final static int FRENTE=1;
    public final static int ABAJO=2;
    
    private int brazoIzq;
    private int brazoDer;
    private int piernaIzq;
    private int piernaDer;
    private int posicionx,posiciony;
    
    protected String nombre;
    protected Color color;

    /**Crea un nuevo persona en la posicion <i>(posicionx, posiciony)</i> 
    @param nombre nombre de la persona
    @param posicionx coordenada x de la posicion 
    @param posiciony coordenada y de la posicion
     */
    public Persona(String nombre, int posicionx, int posiciony){
        this.posicionx=posicionx;
        this.posiciony=posiciony;
        this.nombre=nombre;
        brazoIzq=ABAJO;
        brazoDer=ABAJO;
        piernaIzq=ABAJO;
        piernaDer=ABAJO;
        color=Color.BLACK;
    }
    
    public Persona(String nombre, int posicionx, int posiciony, Color _color){
        this.posicionx=posicionx;
        this.posiciony=posiciony;
        this.nombre=nombre;
        brazoIzq=ABAJO;
        brazoDer=ABAJO;
        piernaIzq=ABAJO;
        piernaDer=ABAJO;
        color=_color;
    }

    public Color getColor(){
        return color;
    }
    
    public void setColor(Color _color)
    {
        this.color = _color;
    }
    
    public void setPositionx(int _x)
    {
        this.posicionx = _x;
    }
    public void setPositiony(int _y)
    {
        this.posiciony = _y;
    }

    /**Mueve un brazo segun las indicaciones
    @param c el brazo a mover: I(zquierdo) o D(erecho)
    @param d el modo de moverlo: S(ubir) o B(ajar)
     */
    public final void muevaBrazo(char c,char d){
        if ((c=='I') && (d=='S') && ((brazoIzq-1)>=0)) {
            brazoIzq-=1;
        } else if ( (c=='I') && (d=='B') && ((brazoIzq+1)<3)){
            brazoIzq+=1;
        } else if ((c=='D') && (d=='S') && ((brazoDer-1)>=0)){
            brazoDer-=1;
        }  else if ((c=='D') && (d=='B') && ((brazoDer+1)<3)){
            brazoDer+=1;
        } else if((c == 'I') && (d == 'P'))
        {
            brazoIzq = ABAJO;
        }else if((c == 'D') && (d == 'P'))
        {
            brazoDer = ABAJO;
        }
    }

    /**Mueve una pierna segun las indicaciones
    @param c la pierna a mover: I(zquierdo) o D(erecho)
    @param d el modo de moverlo: S(ubir), B(ajar), P(iso)
     */
    public final void muevaPierna(char c,char d){
        if ((c=='I') && (d=='S') && ((piernaIzq-1)>=0)){
            piernaIzq-=1;
        } else if ((c=='I') && (d=='B') && ((piernaIzq+1)<3)){
            piernaIzq+=1;
        } else if ((c=='D') && (d=='S') && ((piernaDer-1)>=0)){
            piernaDer-=1;
        }  else if ((c=='D') && (d=='B') && ((piernaDer+1)<3)){
            piernaDer+=1;
        } else if ((c=='D') && (d=='P')){
            piernaDer=ABAJO;
        } else if ((c=='I') && (d=='P')){
            piernaIzq=ABAJO;
        }
    }

    /**Retorna la posicion de un brazo
    @param c el brazo de interes: I(zquierdo) o D(erecho)
    @return la posicion del brazo indicada
     */
    public final int getPosicionBrazo(char c){
        return (c=='I'? brazoIzq: brazoDer);
    }

    /**Retorna la posicion de una pierna
    @param c la pierna de interes: I(zquierda) o D(erecha)
    @return la posicion de la pierna indicada
     */
    public final int getPosicionPierna(char c){
        return (c=='I'? piernaIzq: piernaDer);
    }

    /**Avanza en la direccion indicada
    @param c indica la direccion. N(orte), S(ur), E(ste), O(este)
     */
    public final void avance(char c){
        if (c=='E') {
            posicionx=getPosicionX()+1;
        } else if (c=='O'){
            posicionx=getPosicionX()-1;    
        } else if (c=='N'){
            posiciony=getPosicionY()-1;
        } else if (c=='S'){
            posiciony=getPosicionY()+1;
        }
    }
    
    /**Mueve su cuerpo cambiando de posicion sus extremidades
     */
    public void muevase(){
        if (getPosicionBrazo('I')==ABAJO && getPosicionBrazo('D')==ABAJO){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } else if  (getPosicionBrazo('I')==FRENTE){
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        } else if (getPosicionBrazo('I')==ARRIBA){
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
        }else if (getPosicionBrazo('D')==FRENTE){
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('D','S'); 
            muevaPierna('D','S');
            muevaBrazo('I','B'); 
            muevaPierna('I','B');
        }else if (getPosicionBrazo('D')==ARRIBA){
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('D','B'); 
            muevaPierna('D','B');
            muevaBrazo('I','S'); 
            muevaPierna('I','S');
        }
    }
        

    /**Retorna la coordenada x de la posicion*/
    public final int getPosicionX(){
        return posicionx;
    }

    /**Retorna la coordenada y de la posicion*/
    public final int getPosicionY(){
        return posiciony;
    }

    /**Retorna el mensaje de la persona*/
    public String mensaje(){
        return "Soy "+nombre;
    }

}

