package aplicacion;

import java.awt.Color;

public class Refugio extends Persona implements EnArtico {
    private Artico artico; 
    private int posX = 0;
    private int posY = 0;
    private Color color;
    protected String mensaje;
    private String improvisar = "";
    
    public Refugio(Artico _artico, String _name, int _posicionx, int _posiciony){
        super(_name,_posicionx,_posiciony);
        this.posX = _posicionx;
        this.posY = _posiciony;
        artico = _artico;
        color= Color.RED;
    }
    
    public String tipo()
    {
        return "Cuadrado";
    }
    
    public Color getColor(){
        return color;
    }
    
    public void accion()
    {
        mensaje = "DISPONIBLE";
        setColor(Color.MAGENTA);
        mensaje();
        improvisar = "Accion";
    }
    
    public void corte()
    {
        mensaje = "OCUPADO";
        setColor(Color.GREEN);
        mensaje();
        improvisar = "Corte";
    }
    
    public void improvise()
    {
        if(improvisar == "Accion")
        {
            accion();
        }
        else if(improvisar == "Corte")
        {
            corte();
        }
    }
    
    public void setColor(Color _color)
    {
        this.color = _color;        
    }
    
    public int getPosX(){
        return this.posX;
    }
    
    public int getPosY(){
        return this.posY;
    }
    
    public void esquinas(String _s)
    {
        if(_s == "superiorDerecha")
        {
            posX = this.getPosicionX()+450;
            posY = this.getPosicionY()+450;
        }
        else if(_s == "superiorIzquierda")
        {
            posX = this.getPosicionX();
            posY = this.getPosicionY()+450;
        }
        else if(_s == "inferiorDerecha")
        {
            posX = this.getPosicionX()+450;
            posY = this.getPosicionY();
        }
        else if(_s == "inferiorIzquierda")
        {
            posX = this.getPosicionX();
            posY = this.getPosicionY();
        }
    }
    
    public final String mensaje() {
        return super.mensaje()+": "+(artico.enPoloNorte(this) ? "¡ENCONTRE EL POLO NORTE! ": mensaje);
    }
}
