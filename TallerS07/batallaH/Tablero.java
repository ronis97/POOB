import java.util.ArrayList;

public class Tablero {
    private ArrayList<Flota> flotas;
    public int alNorte(){
        int contador = 0;
        try{           
            for(Flota i: flotas){
                i.alNorte();
                contador += 1;
            }
        }
        catch(BatallaNavalExcepcion BNE){
            System.err.print(BNE);
        }
        return contador;
    }
    public ArrayList<Flota> infiltrados() throws BatallaNavalExcepcion{
        return null;
    }
    public int potencia() throws BatallaNavalExcepcion{
        return 0;
    }
}
