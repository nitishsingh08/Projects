package Projects.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };
        if(solve(board)){
            display(board);
        } else {
            System.out.println("It is not a valid sudoku");
        }
    }
    private static boolean solve(int [][] board){
       int n = board.length;
       int row = -1;
       int col = -1;
       boolean isEmpty = false; // we have to find empty cells
       for(int i = 0; i < n; i++){
           for (int j = 0; j < n ; j++) {
               if(board[i][j] == 0) { // we've found the empty cell
                   // store the pos of this empty cell
                   row = i;
                   col = j;
                   isEmpty = true;
                   // we've found so now
                   break;
               }
           }
           // if you find some empty in row then break;
           if(isEmpty == true){
               break;
           }
       }
       if (isEmpty == false){
           return  true;
           // sudoku is solved
       }
       // backtrack
        for (int i = 1; i < 10; i++) {
            if(isSafe(board, row, col, i)){
                board[row][col] = i;
                if (solve(board)){

                    // found an ans
                    return true;
                } else {
                    // backtrack
                    board[row][col] = 0;
                }
            }

        }
        return false;
    }

    private static boolean isSafe(int [][] board, int row, int col, int num){
       // check the row;
        for (int i = 0; i < board.length; i++){
            // check the row that it doesn't contains num
            if (board[row][i] == num){
                return false;
            }
        }

        // check the col;
        for (int [] nums : board){
            // check the row that it doesn't contains num
            if (nums[col] == num){
                return false;
            }
        }
        int sqrt = (int)(Math.sqrt(board.length));
        int rStart = row - (row % sqrt);
        int cStart = col - (col % sqrt);
        for (int r = rStart; r < (rStart + sqrt); r++){
            for (int c = cStart; c < (cStart + sqrt) ; c++) {
                if (board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
    private static void display(int [] [] board){
        for(int row [] : board){
            for(int num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
