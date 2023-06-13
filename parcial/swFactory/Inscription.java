import java.time.LocalDate;
import java.util.ArrayList;

public class Inscription {
    private LocalDate date;
    private String appUrl;
    private Team team;
    private Project project;
    private ArrayList<Evaluation> evaluations;
    private ArrayList<Notification> notifications;
    /**
     * Notifica a los desarrolladores
     * @return si los desarrolladores fueron notificados 
     * exitosamente
     */
    public boolean notifyDevelopers(){
        return team.notifyDevelopers();
    }
}
