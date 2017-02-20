package mco364;

/**
 *
 * @author yrobi
 */
public class GameOfLife {

    Board board;

    public GameOfLife(int i) {
        board = new Board(Board.Oscillator.values()[i]);
    }

    /**
     * We will do a nested for loop to go through all the 8 neighbors around the
     * cell we are looking at. Now we will be counting the cell we are looking
     * at, so if that cell is already alive, we will subtract 1 from the counter
     * at the end. Also I will not rely on the padding that was laid out for the
     * Oscillators, so I will add an if statement to check that the neighbor is
     * on the board. As well, I am not relying on the padding that is around the
     * image, as I will be including every cell for scrutiny, and so I need to
     * make sure that I am not going to be running into a array out of bounds
     * error.
     *
     * @param row
     * @param col
     * @return
     */
    public int neighborCount(int row, int col) {
//    System.out.println("we are looking at row " + row + " and col " + col);
        int counter = 0;
        for (int i = row - 1; i <= row + 1; i++) { //the rows
            for (int j = col - 1; j <= col + 1; j++) { //the col
                if (i >= 0 && i <= board.getBlnBoard().length - 1
                        && j >= 0 && j <= board.getBlnBoard()[i].length - 1) { //its in bounds
                    if (board.getBlnBoard()[i][j]) { //it is true
                        ++counter;
                    }
                }
            }
        }

        if (board.getBlnBoard()[row][col] == true) {
            --counter;//this avoids counting the cell itself
        }
        return counter;
    }

    /**
     * This cell will be alive if either it was Alive and has neighbor Count of
     * 2 or 3, or it was dead and count of 3.
     *
     * @param row
     * @param col
     * @return
     */
    public boolean isAliveNextGeneration(int row, int col) {

        int counter = neighborCount(row, col);
//System.out.println(counter);
        if (counter == 3 || (board.getBlnBoard()[row][col] == true) && counter == 2) {
            return true;
        } else {
            return false;
        }
    }

    public Board getBoard() {
        return board;
    }

}
