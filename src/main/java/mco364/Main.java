package mco364;

import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        GameOfLife c = new GameOfLife(0);
        c.getBoard().printBoard();

        clearConsole();

        for (int gen = 0; gen < 10; gen++) {
            //create a boolean array with the same dimenstions as old, for next generation.
            boolean[][] nextBoard = new boolean[c.getBoard().getBlnBoard().length][c.getBoard().getBlnBoard()[0].length];
            for (int row = 1; row < c.getBoard().getBlnBoard().length - 1; row++) {
                for (int col = 1; col < c.getBoard().getBlnBoard()[row].length - 1; col++) {
                    nextBoard[row][col] = c.isAliveNextGeneration(row, col); //checks to see if it is alive next gen.
                }
            }
            c.getBoard().setBoard(nextBoard); //resets the original board to next Genearation
            c.board.printBoard(); //prints it out.

            System.out.println(gen);
            sleep(1000);
            clearConsole();
        }
    }

    public final static void clearConsole() {
        for (int i = 0; i < 100; i++) { // safety net since next code only works on console not Netbeans output
            System.out.println();
        }
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
//Handle any exceptions.
        }
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
// ignore
        }
    }
}
