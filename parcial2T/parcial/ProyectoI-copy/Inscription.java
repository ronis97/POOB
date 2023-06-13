import java.time.LocalDate;
import java.util.Collection;

public class Inscription {

    private LocalDate date;

    private String appUrl;

    private SwFactory swFactory;

    private Team team;

    private Project project;

    private Collection<Evaluation> evaluations;

 

    private Collection<Notification> notifications;
    
    public String getIdProject(){
        return project.getId();
    }
    public int evaluatePercentage() throws SwFactoryException{
        Inscription winner = project.getWinner();
        int percentage = 0;
        if (winner != null){
            percentage = project.evaluateProject(appUrl);
            if (percentage > 0){
                Evaluation evaluation = new Evaluation(date, percentage);
            }
            return percentage;
        }
        else{
            throw new SwFactoryException(SwFactoryException.PROJECT_HAS_WINNER);
        }
    }
    public Team getWinner(){
        return this.team;
    }
}
