package uttt.game;

import java.util.Scanner;

import uttt.game.BoardInterface;
import uttt.game.SimulatorInterface;
import uttt.utils.Move;
import uttt.utils.Symbol;

public class GUI implements UserInterface {

    private Scanner scanner;

    public GUI() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Move getUserMove() {
        System.out.print("Enter your move (row column): ");
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        return new Move(row, column);
    }

    @Override
    public void showGameOverScreen(Symbol winner) {
        System.out.println("Game Over");
        if (winner == Symbol.EMPTY) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Player " + winner + " wins!");
        }
    }

    @Override
    public void updateScreen(SimulatorInterface game) {
        System.out.println("Current Board State:");
        BoardInterface[] boards = game.getBoards();
        for (int i = 0; i < 9; i++) {
            System.out.print("Board " + i + ": ");
            MarkInterface[] marks = boards[i].getMarks();
            for (int j = 0; j < 9; j++) {
                System.out.print(marks[j].getSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void updateScreen(BoardInterface game) {
        System.out.println("Current Board State:");
        MarkInterface[] marks = game.getMarks();
        for (int i = 0; i < 9; i++) {
            System.out.print(marks[i].getSymbol() + " ");
            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    @Override
    public String getUserInput(String string, String[] possibleAnswers) {
        System.out.println(string);
        System.out.print("Possible answers: ");
        for (String answer : possibleAnswers) {
            System.out.print(answer + " ");
        }
        System.out.println();
        System.out.print("Enter your answer: ");
        String userInput = scanner.next();
        while (!isValidAnswer(userInput, possibleAnswers)) {
            System.out.print("Invalid answer. Enter your answer: ");
            userInput = scanner.next();
        }
        return userInput;
    }

    private boolean isValidAnswer(String userInput, String[] possibleAnswers) {
        for (String answer : possibleAnswers) {
            if (answer.equalsIgnoreCase(userInput)) {
                return true;
            }
        }
        return false;
    }
}