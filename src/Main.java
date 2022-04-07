import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static void Menu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose option: ");
    }
    private static void operations(){
        System.out.println("add");
        System.out.println("sub");
        System.out.println("mul");
        System.out.println("div");
        System.out.println("power");
        System.out.println("log");
    }
    private static void calculation(double first, double second){
        System.out.println("Numbers: "+first+" "+second+"\n");
        System.out.println("Select an operation: ");
        Scanner option=new Scanner(System.in);
        String operation;
        operation=option.next();
        switch(operation){
            case "addition":
                AddCalculatorOperation addition=new AddCalculatorOperation();
                System.out.println("Result:"+addition.calculate(first,second));
                break;
            case "substraction":
                SubtractCalculatorOperation substraction=new SubtractCalculatorOperation();
                System.out.println("Result:"+substraction.calculate(first,second));
                break;
            case "multiplication":
                MultiplyCalculatorOperation multiplication=new MultiplyCalculatorOperation();
                System.out.println("Result:"+multiplication.calculate(first,second));
                break;
            case "division":
                DivideCalculatorOperation division=new DivideCalculatorOperation();
                System.out.println("Result:"+division.calculate(first,second));
                break;
            case "power":
                PowerCalculatorOperation power=new PowerCalculatorOperation();
                System.out.println("Result:"+power.calculate(first,second));
                break;
            case "logarithm":
                LogarithmCalculatorOperation logarithm=new LogarithmCalculatorOperation();
                System.out.println("Result:"+logarithm.calculate(first,second));
                break;
        }
    }

    private static void help() {
        System.out.println("file: read from file");
        System.out.println("console: read from the console");
        System.out.println("exit: exit");
    }

    public static void main(String[] args) {
        Scanner scanner;
        String option = "";
        while (!option.equals("exit")) {
            scanner = new Scanner(System.in);
            System.out.println("Type help for command list");
            System.out.println("Type operations for math operations");
            System.out.println("Command: ");
            try {
                option = scanner.next();
                switch (option) {
                    case "operations":
                        operations();
                        break;
                    case "help":
                        help();
                        break;
                    case "file":
                        double[] results;
                        OpenFile test = new OpenFile();
                        String data = test.getData();
                        Pattern pattern = Pattern.compile(" |,");
                        results = pattern.splitAsStream(data)
                                .mapToDouble(Double::parseDouble)
                                .toArray();
                        calculation(results[0],results[1]);
                        break;

                    case "console":
                        Scanner a = new Scanner(System.in);
                        System.out.println("First number: ");
                        double first=a.nextDouble();
                        System.out.println("Second number: ");
                        a= new Scanner(System.in);
                        double second=a.nextDouble();
                        calculation(first, second);
                        break;

                }
            } catch (Exception ex) {
                System.out.println("Please enter a valid command");
                scanner.next();
            }

        }
    }
}
