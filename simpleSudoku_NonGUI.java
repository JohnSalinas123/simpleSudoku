/**
 * Program that solves a given valid sudoku puzzle using backtracking algorithm.
 * This version is purely text based, for purposes of learning the logic.
 */

public class simpleSudoku_NonGUI {

    // Will complete if needed.
    /**
     * Copies a given sudoku board.
     * @param board The given sudoku board to copy.
     * @return A new 2D array, with the copied contents.
     */
    public static int[][] copySudoku(int[][] board) {


        return null;
    }

    /**
     * Prints the given sudoku board (two dimensional array)
     */
    public static void printSudokuBoard(int[][] board) {

        // iterates through columns
        for (int i = 0;i < 9; i++) {
            // iterates through row
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
        }

    }

    /**
     * Calls solveSudokuBoard_Recursive, initializing to first spot on sudoku board.
     * @param unsolved THe given unsolved sudoku board.
     */
    public static void solveSudokuBoard(int[][] unsolved) {
        
        solveSudoku_Recursive(unsolved,0,0);
        
    }

    /**
     * Solves a given sudoku board, using backtracking algorithm.
     * @param unsolved The given unsolved sudoku board.
     * @return A 2D array, the solved sudoku board.
     */
    private static boolean solveSudoku_Recursive(int[][] sudokuBoard, int row, int col) {
        System.out.println("(" + row + "," + col + ")");

        if (col >= 8) {
            if (row != 8) {
                solveSudoku_Recursive(sudokuBoard, row + 1, 0);
            } else {
                return false;
            }
        }

        for(int i = 1;i < 10; i++) {
            sudokuBoard[row][col] = i;

            if (checkIfValid_SudokuNum(sudokuBoard, row, col)) {
                if (solveSudoku_Recursive(sudokuBoard, row, col + 1)) {
                    return true;
                }
            }

        }

        sudokuBoard[row][col] = 0;


        return false;
    }

    /**
     * Find out if given spot is one of the original ignored numbers
     * @param testBoard
     * @param row
     * @param col
     * @return
     */
    public static boolean ignoredSpot(int[][] testBoard, int row, int col) {


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
        solveSudokuBoard(sudokuBoard);
        printSudokuBoard(sudokuBoard);
        System.out.println();

        
        //System.out.println(checkIfValid_SudokuNum(sudokuBoard, 8,6));
        
    }

}
