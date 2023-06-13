 import java.util.ArrayList;
/**
 * The Flota class contains all own ships
 * 
 */
public class Flota {
    private Tablero tablero;
    private String nombre;
    private ArrayList<Marino> marinos;
    private ArrayList<Maquina> maquinas;
    /**
     * This method moves the fleet one position north
     */

    public void alNorte() throws BatallaNavalExcepcion{
        for (Maquina m: maquinas){
            m.alNorte();
        }
    }
    /**
     * This method move all machines the defined distance
     * @ param dLon, dLon is the advance in length
     * @ param dLat, dLat is the advance in latitude
     */
    public void avance(int dLon, int dLat){
        for (Maquina i: maquinas){
            i.avance(dLon, dLat);
        }
    }
    /**
     * This method consult the machines that can be affected by 
     * an explotion in the position of
     * @ param longitud, longitud is the lenght of the fleet
     * @ param latitud, latitud is the latitude of the fleet
     * @ return destruidas, destruidas is the machines destroyed in the fleet
     * Observation....
     * Many machines can be in a coordinate.
     * Airplanes are not destroyed
     */
    public ArrayList<Maquina> seranDestruidas(int longitud, int latitud){
        ArrayList<Maquina> destruidas = new ArrayList<Maquina>();
        for (Maquina i: maquinas){
            if (i.seraDestruida(longitud, latitud)) destruidas.add(i);
        }
        return destruidas;
    }
    /**
     * This method consult weak machines in a fleet
     * @ return debiles, debiles is the weak machines in a fleet
     */
    public ArrayList<Maquina> maquinasDebiles(){
        ArrayList<Maquina> debiles = new ArrayList<Maquina>();
        for(Maquina i: maquinas){
            if (i.maquinaDebil()) debiles.add(i);
        }
        return debiles;
    }
    /**
     * This method attack location verification
     * (Destroy enemy items and never take your own casualites)
     * @ param longitud, longitud is the lenght of the fleet
     * @ param latitud, latitud is the latitude of the fleet
     * @ return boolean, true is attack location verification, false otherwise
     */
    public boolean esBuenAtaque(int longitud, int latitud){
        return false;
    }
    /**
     * This method moves all machines that are not weak step by step 
     * (one by one) towards the indicated position to attack.
     * @ param lon, lon is the lenght the new position to attack.
     * @ param lat, lat is the latitude the new position to attack.
     */
    public void ataquen(int lon, int lat){
        maquinas.removeAll(maquinasDebiles());
        for (Maquina i: maquinas){
            i.avance(lon, lat);
        }
    }
    public ArrayList<Marino> pilotos() throws BatallaNavalExcepcion{
        return null;
    }    
    public int potencia() throws BatallaNavalExcepcion{
        return 0;
    }
    
    //Incluya el contenedor de maquinas
}
