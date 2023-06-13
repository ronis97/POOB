import java.time.LocalDate;
import java.util.Collection;

public class Project implements Feedbacker {

    private String id;

    private String urlFormulation;

    private String client;

    private LocalDate start;

    private LocalDate end;

    private int prize;

    private SwFactory swFactory;

    private Inscription inscription;

    private Collection<Requirement> requirements;

    private Inscription winner;

    private Project project;

    private Requirement requirement;

    private Certificates certificates;


    /**
     * @see Feedbacker#calculateExperience()
     * 
     *  
     */
    public static int calculateExperience() {
        return 0;
    }
    public String getId(){
        return this.id;
    }
    public Inscription getWinner(){
        return this.winner;
    }
    public int evaluateProject(String urlApp){
        int percentage = 0;
        for (Requirement r: requirements){
            percentage += r.evaluate(r, urlApp);
        }
        percentage = percentage / requirements.size();
        return percentage;
    }
}
