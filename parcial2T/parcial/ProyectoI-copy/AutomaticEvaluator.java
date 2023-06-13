import java.util.Collection;

public class AutomaticEvaluator extends Evaluator {

    private static Collection<UnitTest> unitTests;
    
    public static int evaluate(Requirement r, String appUrl){
        int percentage = 0;
        for (UnitTest ut: unitTests){
            ut.runTest(appUrl, r);
        }
        return percentage;
    } 
}
