

public class BatallaNavalExcepcion extends Exception
{
    public static final String NO_SE_PUDO_MOVER = "La maquina no se pudo mover";
    public static final String 
        PILOTO_ASIGNACION_INCORRECTA = "Un piloto de avion no esta asignado o este ha sido asignado a mas de un avion";
    public static final String MENOS_MARINOS_QUE_MAQUINAS = "Existen menor marinos que maquinas en la flota";
    public static final String NO_MARINOS_EN_FLOTA = "La flota no tiene marinos asignados";
    public static final String POTENCIA_FLOTAS = "Mas de la mitad de las flotas tienen problemas de potencia";
    public BatallaNavalExcepcion(String message){
        super(message);
    }
    
}