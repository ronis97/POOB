public class Avion {
    private final int MIN_TRIPULANTES = 2;
    private String placa;
    private boolean enAire;
    private Posicion ubicacion;
    private Marino piloto;
    private Marino copiloto;
    public boolean getEnAire(){
        return enAire;
    }
    public String getPlaca(){
        return placa;
    }
}
