package mco364;

import java.awt.Robot;
import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Please enter a number for the corresponding Oscillator.\n"
                + "Blinker - 0\n"
                + "Frog - 1\n"
                + "Beacon - 2\n"
                + "Pulsar - 3\n"
                + "Pentadecathlon - 4");
        int choice = scn.nextInt(); //not worrying about validating input right now
        GameOfLife c = new GameOfLife(choice);
        c.getBoard().printBoard();
        
        System.out.print("If you would like for the generations to appear automaticaly with .5 second intervals input 1"
                + " and if you would like to do it yourself, input 2. ");
        choice = scn.nextInt(); //not worrying about validating input.
        clearConsole();
        if (choice == 1) {
            for (int gen = 0; gen < 10; gen++) {

                //create a boolean array with the same dimenstions as old, for next generation.
                MyThread.nextGeneration(c); //creats the thread for this board.
                c.board.printBoard(); //prints it out.

                System.out.println(gen);
                sleep(500);
                clearConsole();
            }
        } else if (choice == 2) {
            int counter = 0;
            System.out.println("Input 1 to get to the next generation, when finished input 0");
            choice = scn.nextInt();
            while (choice != 0) {
                clearConsole();
                MyThread.nextGeneration(c); //creats the thread for this board.
                c.board.printBoard(); //prints it out.
                System.out.println(counter++); //the generation
                choice = scn.nextInt();
            }
            
        }
        
        System.out.println("\nProgtam Terminated");
//        for (int gen = 0; gen < 10; gen++) {
//
//            //create a boolean array with the same dimenstions as old, for next generation.
//            MyThread.nextGeneration(c); //creats the thread for this board.
//            c.board.printBoard(); //prints it out.
//
//            System.out.println(gen);
//            sleep(500);
//            clearConsole();
//        }

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
