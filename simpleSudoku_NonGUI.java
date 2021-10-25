

/**
 * Program that solves a given valid sudoku puzzle using backtracking algorithm.
 * This version is purely text based, for purposes of learning the logic.
 */

public class simpleSudoku_NonGUI {

    /**
     * Copies a given sudoku board.
     * @param board The given sudoku board to copy.
     * @return A new 2D array, with the copied contents.
     */
    public static int[][] copySudoku(int[][] board) {
        int[][] copy = new int[9][9];

        // iterates through columns
        for (int i = 0;i < 9; i++) {
            // iterates through row
            for (int j = 0;j < 9;j++) {
                copy[i][j] = board[i][j];
            }
        }

        return copy;
    }

    /**
     * Finds an empty spot on the sudoku board.
     * @param board The given sudoku board.
     * @return A integer array(size 2), has cords for empty spot on board.
     */
    private static int[] locateEmpty(int[][] board) {
        int[] cords = new int[2];

        // iterates through columns
        for (int i = 0;i < 9; i++) {
            // iterates through row
            for (int j = 0;j < 9;j++) {
                if (board[i][j] == 0) {
                    cords[0] = i;
                    cords[1] = j;
                    return cords;
                }
            }
        }

        return null;
    }

    /**
     * Prints the given sudoku board (two dimensional array)
     */
    public static void printSudokuBoard(int[][] board) {

        // iterates through rows
        for (int i = 0;i < 9; i++) {
            // iterates through columns
            for (int j = 0;j < 9;j++) {
                if (j == 0){
                    System.out.print("|");
                }

                if (board[i][j] != 0) {
                    System.out.print(board[i][j] + "|");
                } else {
                    System.out.print(" |");
                }
                
            }
            System.out.println();
            if (i % 3 == 2) {
                System.out.println("-------------------");
            }
        }

    }


    /**
     * Solves a given sudoku board, using backtracking algorithm.
     * @param unsolved The given unsolved sudoku board.
     * @return A 2D array, the solved sudoku board.
     */
    private static boolean solveSudoku_Recursive(int[][] sudokuBoard) {
        int row = 0;
        int col = 0;
        
        int[] boardCords = locateEmpty(sudokuBoard);
        
        if (locateEmpty(sudokuBoard) == null) {
            return true;
        } else {
            row = boardCords[0];
            col = boardCords[1];
        }


        for(int i = 1;i < 10; i++) {
            sudokuBoard[row][col] = i;

            if (checkIfValid_SudokuNum(sudokuBoard, row, col)) {
                if (solveSudoku_Recursive(sudokuBoard)) {
                    return true;
                }
            }

        }
        sudokuBoard[row][col] = 0;

        return false;
    }



    /**
     * 
     * @param testBoard
     * @param row
     * @param col
     * @return
     */
    public static boolean checkIfValid_SudokuNum(int[][] testBoard, int row, int col) {
        boolean validNum = true;
        int num = testBoard[row][col];


        // Compare num to entire row
        for (int i = 0; i < 9; i++) {
            if (i != col) {
                if (testBoard[row][i] == num) {
                    validNum = false;
                    break;
                }
            }
        }

        if (validNum == true) {
            // Compare num to entire colum
            for(int i = 0; i < 9; i++) {
                if (i != row) {
                    if (testBoard[i][col] == num) {
                        validNum = false;
                        break;
                    }
                }
            }
        }

        if (validNum == true) {
            // Compare num to entire 3x3 grid (row/3)*3 and (col/3)*3 to get start of 3x3
            int startRow = (row/3)*3;
            int startCol = (col/3)*3;

            for (int i = startRow; i < startRow + 3;i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (i != row || j != col) {
                        if (testBoard[i][j] == num) {
                        validNum = false;
                        break;
                        } 
                    }
                }
            }

        }
            
        return validNum;
    }
    
    public static void main(String []args) {

        // 2D Integer Array sudoku board, zeroes are empty spaces
        int[][] sudokuBoard = 
        {{4,0,6,5,0,2,8,0,9}
        ,{0,0,0,0,4,0,0,3,0}
        ,{0,0,0,0,0,0,0,0,5}
        ,{6,0,0,8,0,0,1,0,0}
        ,{5,0,0,0,7,0,0,8,0}
        ,{3,0,2,9,0,4,0,6,0}
        ,{0,2,0,6,0,0,0,0,1}
        ,{0,0,0,0,5,3,9,4,0}
        ,{8,3,0,0,9,0,0,0,2}};

        System.out.println("The unsolved sudoku board: ");
        printSudokuBoard(sudokuBoard);
        System.out.println();
        
        System.out.println("The solved sudoku board: ");
        solveSudoku_Recursive(sudokuBoard);
        printSudokuBoard(sudokuBoard);
        System.out.println();

        
    }

}
