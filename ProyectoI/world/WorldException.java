package world;


/**
 * The class WorldException is the one that
 * contains all the problem conquer the world exceptions
 *
 *  @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (September 2nd, 2021)
 */
public class WorldException extends Exception
{
    public static final String BAD_TYPE_OF_NATION = "El tipo ingresado de nacion es incorrecto";
    public static final String BAD_TYPE_OF_ROUTE = "El tipo ingresado de ruta es incorrecto";
    public static final String BAD_TYPE_OF_ARMY = "El tipo ingresado de army es incorrecto";
    public static final String EXISTING_NATION = "La nacion ya se encuentra";
    public static final String NOT_EXISTING_NATION = "La nacion no existe";
    public static final String SOME_NATION_NOT_FOUND = "Alguna de las naciones no fue encontrada";
    public static final String NATIONS_NOT_CONNECTED = "Las naciones no se encuentran conectadas";
    public static final String NATION_NOT_FOUND = "La nacion no fue encontrada";
    public static final String ROUTE_NOT_FOUND = "La ruta no fue encontrada";
    public static final String NO_PREVIOUS_ACTIONS = "No hay acciones anteriores";
    public static final String ROUTE_FOUND_OR_NATIONS_NOT_FOUND = "La ruta ya se encuentra o las naciones no fueron localizadas";
    public static final String NATION_WITHOUT_ARMIES = "La nacion no tiene ejercitos";
    public WorldException(String message){
        super(message);
    }
}
