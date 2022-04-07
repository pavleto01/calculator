import jdk.dynalink.Operation;

public class LogarithmCalculatorOperation implements CalculatorOperation {

    @Override
    public double calculate(double numA, double numB) {
        return Math.log(numA)/Math.log(numB);
    }
}
