public class PowerCalculatorOperation implements CalculatorOperation{

    @Override
    public double calculate(double numA, double numB) {
        return Math.pow(numA,numB);
    }
}
