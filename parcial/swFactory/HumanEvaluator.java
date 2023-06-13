import java.util.ArrayList;
public class HumanEvaluator {    
    /**
     * Evaluate the fulfillment of a requirement
     * @param r requirement to evaluate
     * @param appUrl url of the application
     * @return points achieved
     */
    private ArrayList<AcceptanceTest> acceptanceTests;
    public int evaluate(Requirement r, String appUrl) {
        return 0;
    }
    /**
     * Borra el evaluador
     * @return si el evaluador fue borrado exitosamente
     */
    public boolean deletedEvaluator(){
        for (AcceptanceTest at: acceptanceTests){
            at.deleteATest();
        }
        return true;
    }
}
