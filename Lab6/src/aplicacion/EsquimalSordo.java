package aplicacion;


import java.awt.Color;

public class EsquimalSordo extends Persona implements EnArtico
{
    private Artico artico;
    protected String palabras;

        
    public EsquimalSordo(Artico artico,String _name,int posicionx, int posiciony, Color _color)
    {
        super(_name,posicionx,posiciony,_color);
        this.artico=artico;
        palabras="Qué qué?";
    }
    
    public final String tipo()
    {
        return "Persona";
    }
    
    public void improvise()
    {
        this.corte();
        setColor(Color.YELLOW);
    }
    
    public void corte(){
        int n = 0;
        while(n<5)
        {
            super.avance('S');
            n ++;
        }
        palabras="";
    }
    @Override
    public final void accion()
    {
        if (! artico.enPoloNorte(this))
        {
            actue();
        }    
    }

    public void actue(){
        muevaBrazo('I','S'); 
        muevaBrazo('D','S'); 
    }
}
