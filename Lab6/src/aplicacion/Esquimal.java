package aplicacion;

import java.awt.Color;
import java.util.Random;

public class Esquimal extends Persona implements EnArtico{

    private Artico artico;   
    protected String palabras;
    Random r = new Random(1);

    public Esquimal(Artico artico,String name,int posicionx, int posiciony){
        super(name,posicionx,posiciony);
        this.artico=artico;
        palabras="¡Escalando!";
    }
    
    public String tipo()
    {
        return "Persona";
    }
    
    public void improvise()
    {
        if (r.nextBoolean())
        {
            accion();
        }else{
            corte();
        }
    }
    
    public void corte(){
        muevaBrazo('I','P'); 
        muevaPierna('I','P');
        muevaBrazo('D','P'); 
        muevaPierna('D','P');       
        palabras="";
    }

    public final void accion()
    {
        if (! artico.enPoloNorte(this))
        {
            actue();
        }    
    }

    public void actue(){
        char d;
        muevase();
        do{
            d="NSEO".charAt((int)(Math.random() * 4));
        } while (! puedeMoverse(d));
        avance(d);
    }

    public final String mensaje() {
        return super.mensaje()+": "+(artico.enPoloNorte(this) ? "¡ENCONTRE EL POLO NORTE! ": palabras);
    }

}

