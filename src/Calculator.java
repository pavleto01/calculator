public class Calculator {

    public double calculate(double numA, double numB, CalculatorOperation operation){
        return operation.calculate(numB, numB);
    }
}