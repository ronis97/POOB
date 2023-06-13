import java.util.ArrayList;

public class Flota {
    public final String CODIGO = "Aqui flotas!"; 
    private String nombre;
    private ArrayList<Avion> aviones;
    private ArrayList<PortaAviones> portaAviones;
    private ArrayList<Barco> barcos;
    private ArrayList<Marino> marinos;
    private Tablero tablero;
    public Flota(){}
    /**
     * 
     */
    public int disponibilidadEnPortaAviones(){
        int total = 0;
        for (PortaAviones i: portaAviones){
            total += i.getCapacidad();
        }
        return total;
    }
    /**
     * 
     */
    public ArrayList<String> enAire(){
        ArrayList<String> enAire = new ArrayList<String>();
        for (String i: tablero.avionesEnAire()){
            if (!this.enAire().contains(i)) enAire.add(i);
        }
        return enAire;
    }
    public boolean esBuenAtaque(int longitud, int latitud){
        return false;
    }
    /**
     * 
     */
    public void muevase(int deltaLongitud, int deltaLatitud){
        for (Barco i: barcos){
            i.muevase(deltaLongitud,deltaLatitud);
        }
    }
    /**
     * 
     */
    public boolean problemaEnAire(){
        
        return false;
    }
    /**
     * 
     */
    public ArrayList<Object> seranDestruidas(int longitud, int latitud){
        return null;
    }
    public ArrayList<String> avionesEnAire(){
        ArrayList<String> volando = new ArrayList<String>();
        for(Avion i: aviones){
            if (i.getEnAire()) volando.add(i.getPlaca());
        }
        return volando;
    }
}
