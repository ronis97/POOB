package aplicacion;

import java.util.*;
import java.awt.Color;
import java.lang.Math.*;

public class EsquimalExplorador extends Persona implements EnArtico
{
    private Artico artico;
    protected String palabras;
    private ArrayList<EnArtico> elementos = new ArrayList<EnArtico>();
    int posiX ;
    int posiY;
        
    public EsquimalExplorador(Artico artico,String name,int posicionx, int posiciony, Color color,ArrayList<EnArtico> elementos )
    {
        super(name, posicionx,posiciony,color);
        this.artico=artico;
        this.posiX = posicionx;
        this.posiY = posiciony;
        palabras = "Qué qué?";
        color = Color.RED;
        elementos = elementos;
    }
    
    public String tipo()
    {
        return "Persona";
    }
    
    public void corte()
    {
        int xcerca = 1000;
        int ycerca = 1000;
        int distancia = 0;
        for(EnArtico esquimal : elementos)
        {
            if((esquimal instanceof Esquimal) || ( esquimal instanceof EsquimalSordo)) 
            {
                double d = Math.sqrt(Math.pow((double)esquimal.getPosicionX()-(double)posiX,2) +
                                     Math.pow((double)esquimal.getPosicionY()-(double)posiY,2) );
                if( (esquimal.getPosicionX()-posiX) < xcerca && (esquimal.getPosicionY()-posiX) < ycerca )
                { 
                    xcerca = esquimal.getPosicionX();
                    ycerca = esquimal.getPosicionY();
                }
            }
        }
        super.setPositionx(xcerca + 10);
        super.setPositiony(ycerca + 10);
    }    
    
    public void accion()
    {
        for(int i=0 ; i < 100 ; i++)
        {
            actue();
        }
    }
        
    public void actue()
    {
        if(this.getPosicionX()<500 && this.getPosicionY() == 0 )
        {
            this.avance('E');
        }
        else if(this.getPosicionY()<500 && this.getPosicionX()==500)
        {
            this.avance('S');
        }
        else if(this.getPosicionX()> 0 && this.getPosicionY()==500)
        {
            this.avance('O');            
        }
        else if (this.getPosicionY() > 0 && this.getPosicionX() == 0)
        {            
            this.avance('N');
        }
    }
    
    public void improvise()
    {
        this.getPosicionX();
        this.getPosicionY();
    }
}
