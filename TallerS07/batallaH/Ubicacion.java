 

public class Ubicacion {
    private int longitud;
    private int latitud;
    public int getLongitud(){
        return longitud;
    }
    public void setLongitud(int longitud){
        this.longitud = longitud;
    }
    public int getLatitud(){
        return latitud;
    }
    public void setLatitud(int latitud){
        this.latitud = latitud;
    }
    public void alNorte() throws BatallaNavalExcepcion{
        if (latitud <= 90){
            latitud ++;
        }
        else{
            throw new BatallaNavalExcepcion(BatallaNavalExcepcion.NO_SE_PUDO_MOVER);
        }
    }
}
