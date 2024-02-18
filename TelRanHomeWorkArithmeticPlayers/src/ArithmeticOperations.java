import java.util.Random;

public class ArithmeticOperations {
    private Random random = new Random();
    private int number1;
    private int number2;

    public void getRandomNumbers() {
        number1 = random.nextInt(10) + 1;
        number2 = random.nextInt(10) + 1;
    }

    public char getRandomOperation() {
        int operationIndex = random.nextInt(4);
        switch (operationIndex) {
            case 0:
                return '+';
            case 1:
                return '-';
            case 2:
                return '*';
            case 3:
                return '/';
            default:
                return '+';
        }
    }

    public int addition() {
        System.out.print(number1 + " + " + number2 + " = ");
        return number1 + number2;
    }

    public int subtraction() {
        System.out.print(number1 + " - " + number2 + " = ");
        return number1 - number2;
    }

    public int multiplication() {
        System.out.print(number1 + " * " + number2 + " = ");
        return number1 * number2;
    }

    public int division() {
        if (number2 == 0) {
            number2 = 1;
        }
        System.out.print(number1 + " / " + number2 + " = ");
        return number1 / number2;
    }
}
