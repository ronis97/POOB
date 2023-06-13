import java.util.ArrayList;
public class Tablero {
    private ArrayList<Flota> flotas;
    public Tablero(){}
    public ArrayList<String> avionesEnAire(){
        ArrayList<String> enAire = new ArrayList<String>();
        for (Flota i: flotas){
            ArrayList<String> enAireFlota = 
            new ArrayList<String>(i.avionesEnAire());
            for (String j: enAireFlota){
                enAire.add(j);
            }
        }
        return enAire;
    }
    
}
