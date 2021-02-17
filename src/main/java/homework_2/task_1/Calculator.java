package homework_2.task_1;

import java.util.ArrayList;
import java.util.Arrays;

import static homework_2.task_1.Operations.*;

public class Calculator {

    private double a;
    private double b;
    private Operations operation;
    private double result;
    private String fiboResult;

    public void calculateResult() {
        switch (operation) {
            case MINUS:
                result = a - b;
                break;
            case PLUS:
                result = a + b;
                break;
            case MULTIPLICATION:
                result = a * b;
                break;
            case EXPONENTIATION:
                int i = (int) b;
                result = 1;
                while (i > 0) {
                    result *= a;
                    i--;
                }
                break;
            case FIBONACCI:
                fiboResult = fibonacci((int) a);
                break;
            case FACTORIAL:
                result = factorial((int) a);
        }
    }

    public Calculator(double a, double b, Operations operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
        calculateResult();
    }

    public Calculator(double a, Operations operation) {
        this.a = a;
        this.operation = operation;
        calculateResult();
    }

    @Override
    public String toString() {
        if (operation == FACTORIAL) {
            return String.format("%s(%d) = %d", operation.toString(), (int) a, (int) result);
        } else if (operation == FIBONACCI) {
            return String.format("%s(%d) = %s", operation.toString(), (int) a, fiboResult);
        }
        return String.format("%.2f %s %.2f = %.2f", a, operation.toString(), b, result);
    }

    public int factorial(int num) {
        int result = 1;
        while (num >= 1) {
            result *= num;
            num--;
        }
        return result;
    }

    public String fibonacci(int size) {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(1, 1));
        int n0 = 1;
        int n1 = 1;
        int n2;
        while (result.size() <= size) {
            n2 = n0 + n1;
            result.add(n2);
            n0 = n1;
            n1 = n2;
        }
        return result.toString();
    }
}
