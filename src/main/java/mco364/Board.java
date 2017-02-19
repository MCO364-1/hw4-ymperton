package mco364;

public class Board {

    private static String[] strBoard;

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
                            "--xxx-",
                            "-xxx--",
                            "------",
                            "------"};
                    }
                },
        BEACON {

                    public String[] getStrBoard() {
                        return new String[]{"------",
                            "-xx---",
                            "-xx---",
                            "---xx-",
                            "---xx-",
                            "------"};
                    }
                },
        PULSAR {

                    public String[] getStrBoard() {
                        return new String[]{"-----------------",
                            "-----------------",
                            "----xxx---XXX----",
                            "-----------------",
                            "--X----X-X----X--",
                            "--X----X-X----X--",
                            "--X----X-X----X--",
                            "----xxx---XXX----",
                            "-----------------",
                            "----xxx---XXX----",
                            "--X----X-X----X--",
                            "--X----X-X----X--",
                            "--X----X-X----X--",
                            "-----------------",
                            "----xxx---XXX----",
                            "-----------------",
                            "-----------------"};
                    }
                },
        PENTADECATHLON {

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
                };

//        Oscillator2(String[] array) {
//            strBoard = array;
//        }
        public String[] getStrBoard() {
            return strBoard;
        }

    };

    private boolean[][] blnBoard;

    public Board(Oscillator o) {

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
        for (boolean[] bs : blnBoard) {
            for (boolean elt : bs) {
                if (elt) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public void setBoard(boolean[][] oldBoard) {
        blnBoard = oldBoard;
    }

    public boolean[][] getBlnBoard() {
        return blnBoard;
    }

}
