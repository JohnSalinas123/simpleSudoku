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
     * Solves a given sudoku board, using backtracking algorithm.
     * @param unsolved The given unsolved sudoku board.
     * @return A 2D array, the solved sudoku board.
     */
    public static int[][] solveSudokuBoard(int[][] unsolved) {
        // For now, references the same object as input parameter
        int[][] result = unsolved;

        
        

        return result;
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
        int [][] solvedSudoku = solveSudokuBoard(sudokuBoard);
        printSudokuBoard(solvedSudoku);
        System.out.println();



        
    }

}
