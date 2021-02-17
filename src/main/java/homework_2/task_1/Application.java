package homework_2.task_1;

import java.util.Scanner;

public class Application {

    private static Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.printf("Введите тип операции из %s:\n", Operations.toStringAllOperationSigns());
        Operations userOperation = Operations.getOperationBySign(scanner.next());
        switch (userOperation) {
            case MINUS:
            case PLUS:
            case MULTIPLICATION:
            case EXPONENTIATION:
                System.out.print("Введите 2 числа:\n");
                System.out.println(new Calculator(scanner.nextDouble(), scanner.nextDouble(), userOperation));
                break;
            case FIBONACCI:
            case FACTORIAL:
                System.out.print("Введите число:\n");
                System.out.println(new Calculator(scanner.nextInt(), userOperation));
                break;
            default:
                System.out.println("Некорректная операция");
        }
    }
}


class CalculatorAppDemo {
    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
