package mco364;

public class Board {

    public interface BoardCreator {

        public String[] getStrBoard();
    }

    public enum Oscillator implements BoardCreator {

        BLINKER {
                    @Override
                    public String[] getStrBoard() {
                        return new String[]{"-----",
                            "-----",
                            "-XXX-",
                            "-----",
                            "-----"};
                    }
                },
        TOAD {
                
                    @Override
                    public String[] getStrBoard() {
                        return new String[]{"------",
                            "------",
                            "--XXX-",
                            "-XXX--",
                            "------",
                            "------"};
                    }
                },
        BEACON {

                    @Override
                    public String[] getStrBoard() {
                        return new String[]{"------",
                            "-XX---",
                            "-XX---",
                            "---XX-",
                            "---XX-",
                            "------"};
                    }
                },
        PULSAR {
                    @Override
                    public String[] getStrBoard() {
                        return new String[]{"-----------------",
                            "-----------------",
                            "----XXX---XXX----",
                            "-----------------",
                            "--X----X-X----X--",
                            "--X----X-X----X--",
                            "--X----X-X----X--",
                            "----XXX---XXX----",
                            "-----------------",
                            "----XXX---XXX----",
                            "--X----X-X----X--",
                            "--X----X-X----X--",
                            "--X----X-X----X--",
                            "-----------------",
                            "----XXX---XXX----",
                            "-----------------",
                            "-----------------"};
                    }
                },
        PENTADECATHLON {
                    @Override
                    public String[] getStrBoard() {
                        return new String[]{"-----------",
                            "-----------",
                            "-----------",
                            "-----------",
                            "-----X-----",
                            "-----X-----",
                            "----X-X----",
                            "-----X-----",
                            "-----X-----",
                            "-----X-----",
                            "-----X-----",
                            "----X-X----",
                            "-----X-----",
                            "-----X-----",
                            "-----------",
                            "-----------",
                            "-----------",
                            "-----------"};
                    }
                }
    };

    private boolean[][] blnBoard;
    String[] strBoard;

    public Board(Oscillator o) {
        strBoard = o.getStrBoard(); //it's own unique board
        createBoard();
    }

    /**
     * Will interpret the X's in the strArray to a boolean array for simplicity.
     */
    private void createBoard() {
        blnBoard = new boolean[strBoard.length][strBoard[0].length()];
        
        for (int row = 0; row < strBoard.length; row++) {
            for (int col = 0; col < strBoard[row].length(); col++) {
                if (strBoard[row].charAt(col) == 'X') {
                    blnBoard[row][col] = true;
                }
            }
        }
    }

    public void printBoard() {
        String horizontalLine = new String(new char[blnBoard[0].length + 2]).replace("\0", "-");
        
        System.out.println(horizontalLine); //top line
        for (boolean[] bs : blnBoard) {
            System.out.print("|");
            for (boolean elt : bs) {
                if (elt) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println(horizontalLine);
    }

    public void setBoard(boolean[][] oldBoard) {
        blnBoard = oldBoard;
    }

    public boolean[][] getBlnBoard() {
        return blnBoard;
    }
    
    public String[] getStrBoard() {
        return strBoard;
    }

}
