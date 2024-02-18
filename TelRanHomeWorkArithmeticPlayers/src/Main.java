import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько игроков будет играть в игру: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        Player[] players = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.printf("Введите имя игрока %d: ", i + 1);
            String playerName = scanner.nextLine();
            players[i] = new Player(playerName);
        }

        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        Points[] points = new Points[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            points[i] = new Points(players[i].getName());
        }

        boolean gameInProgress = true;

        while (gameInProgress) {
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("Игра начинается для игрока " + players[i].getName());
                int score = 0;
                for (int j = 0; j < 4; j++) {
                    arithmeticOperations.getRandomNumbers();
                    char operation = arithmeticOperations.getRandomOperation();
                    int result = 0;
                    switch (operation) {
                        case '+':
                            result = arithmeticOperations.addition();
                            break;
                        case '-':
                            result = arithmeticOperations.subtraction();
                            break;
                        case '*':
                            result = arithmeticOperations.multiplication();
                            break;
                        case '/':
                            result = arithmeticOperations.division();
                            break;
                    }
                    System.out.print("Ваш ответ: ");
                    if (scanner.hasNextInt()) {
                        int userAnswer = scanner.nextInt();
                        if (userAnswer == result) {
                            System.out.println("Правильно! Вы заработали 5 очков.");
                            score = score + 5;
                        } else {
                            System.out.println("Неправильно! Вы потеряли 5 очков.");
                            score = score - 5;
                        }
                    } else {
                        String input = scanner.next();
                        if (input.equalsIgnoreCase("exit")) {
                            gameInProgress = false;
                            break;
                        }
                    }
                }
                if (!gameInProgress) {
                    break;
                }
                points[i].setScore(score);
            }
        }

        System.out.println("Результаты игры:");
        for (int i = 0; i < numPlayers; i++) {
            System.out.println(players[i].getName() + ", ваш итоговый счет: " + points[i].getScore() + " очков.");
        }

    }
}
