import java.util.Collection;

public class Requirement {

    private String urlDetail;

    private int maxPoints;

    private Project project;


    private Collection<Evaluator> evaluators;
    public String getUrl(){
        return this.urlDetail;
    }
    public int evaluate(Requirement r, String appUrl){
        int percentage = 0;
        for (Evaluator i: evaluators){
            percentage += i.evaluate(r, appUrl);
        }
        percentage = percentage / evaluators.size();
        return percentage;
    }
}
