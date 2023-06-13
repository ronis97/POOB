import java.time.LocalDate;
import java.util.ArrayList;

public class Project {
    private String id;
    private String urlFormulation;
    private String client;
    private LocalDate start;
    private LocalDate end;
    private int prize;
    private ArrayList<Requirement> requirements;
    private Inscription winner;
    private HumanEvaluator evaluator;
    /**
     * Borra el proyecto, los requerimientos y notifica 
     * a los desarrolladores
     * @return si el proyecto fue borrado exitosamente.
     */
    public boolean deleteProject(){
        boolean deletedRe = false;
        for (Requirement r: requirements){
            deletedRe = r.deleteRequirements();
        }
        boolean deletedEva = evaluator.deletedEvaluator();
        if (winner != null && deletedRe && deletedEva){
            winner.notifyDevelopers();
        }
        return true;
    }
}
