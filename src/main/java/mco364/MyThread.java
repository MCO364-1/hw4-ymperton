package mco364;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThread implements Runnable {

    static GameOfLife g;
    static final int TOTAL_NUMBER_THREADS = 25;
    static boolean[][] nextBoard;
    static int quotient, remainder;

    private int threadIndex;
    private int startIndex, endIndex;
    private static int totalNumberOfCells;

    public MyThread(int i) {
        this.threadIndex = i;
    }

    /**
     * This will solve the problem we had in class, which is how to have the
     * slots evenly distributed across the threads.
     */
    @Override
    public void run() {
        if (threadIndex < remainder) { //it will have an extra cell to do
            startIndex = threadIndex * (quotient + 1);
            endIndex = (threadIndex + 1) * (quotient + 1);
        } else {
            startIndex = threadIndex * quotient + remainder;
            endIndex = (threadIndex + 1) * quotient + remainder;
        }
//        System.out.println("Thread " + threadIndex + " will be start: " + startIndex + " and end before: " + endIndex + "\tlength: " + (endIndex - startIndex));

        int row, col; //turn the index of the cells into coordinates
        //will for loop between the start and end that this thread is responsible for.
        for (int i = startIndex; i < endIndex; i++) {
            row = i / nextBoard[0].length;
            col = i % nextBoard[0].length;
//            System.out.println("Working on row: " + row + " col: " + col);
            nextBoard[row][col] = g.isAliveNextGeneration(row, col);
//            System.out.println("row: " + row + " col: " + col + " is now " + g.isAlive);
        }

    }

    static void nextGeneration(GameOfLife g) {
        MyThread.g = g;
        MyThread.totalNumberOfCells = g.getBoard().getBlnBoard().length * g.getBoard().getBlnBoard()[0].length;
        MyThread.quotient = totalNumberOfCells / TOTAL_NUMBER_THREADS;
        MyThread.remainder = totalNumberOfCells % TOTAL_NUMBER_THREADS;

        MyThread.nextBoard = new boolean[g.getBoard().getBlnBoard().length][g.getBoard().getBlnBoard()[0].length];


        ArrayList<Thread> threadList = new ArrayList<>(TOTAL_NUMBER_THREADS);
        for (int i = 0; i < TOTAL_NUMBER_THREADS; i++) {
            Thread t = new Thread(new MyThread(i));
            threadList.add(t);
        }
        
        ScheduledThreadPoolExecutor pool;
        pool = new ScheduledThreadPoolExecutor(10);
        for (int i  = 0; i < TOTAL_NUMBER_THREADS; i++) {
            pool.execute(new MyThread());
        }
        pool.shutdown();
        //finished updating the board
        g.getBoard().setBoard(nextBoard); //resets the original board to next Genearation
    }

}
