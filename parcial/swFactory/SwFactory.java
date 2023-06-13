import java.util.*;
public class SwFactory {
    private ArrayList<Client> clients;
    private ArrayList<Inscription> inscriptions;
    private HashMap<String,Team> teams;
    private HashMap<String,Project> projects;
    /**
     * Remueve el proyecto del sistema si ya finalizo
     * Invariante del metodo: El hashMap projects no puede ser vacio
     * @ param projectName El nombre del proyecto dado como una cadena
     * @ return Si el proyecto fue borrado exitosamente.
     */
    public boolean deleteFinishProject(String projectName){
        for (Client cliente: clients){
            return cliente.deleteProject(projectName);
        }
        return false;
    }
}
/**
 * Conceptos:
 * 1. Explique alguna practica XP ¿Como la utilizaria en SwFactory?
 * Simplicidad. El codigo del proyecto es simple y facil de entender, de esta manera 
 * nos aeguramos que tome menos tiempo de realizar.
 * 2. Sobrecarga es la creacion de varios metodos con el mismo nombre pero con diferentes 
 * parametros. Esto permite tener variedad de funcionalidades que permiten la 
 * crecion de un codigo mas flexible.
 */