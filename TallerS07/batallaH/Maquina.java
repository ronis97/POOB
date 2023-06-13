 

public class Maquina {
    private Ubicacion ubicacion;
    private boolean esDebil;
    private String causaAutodestruccion;
    /**
     * 
     */
    public void avance(int dLon, int dLat){
        
    }
    /**
     * 
     */
    public boolean seraDestruida(int longitud, int latitud){
        if (ubicacion.getLongitud() == longitud 
            && ubicacion.getLongitud() == latitud) return true;
        return false;
    }
    /**
     * 
     */
    public boolean maquinaDebil(){
        return false;
    }
    public boolean autoDestruccion(){
        return false;
    }
    public void alNorte() throws BatallaNavalExcepcion{
        ubicacion.alNorte();
    }
}
