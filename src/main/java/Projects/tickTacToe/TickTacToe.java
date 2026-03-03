package Projects.tickTacToe;

import java.util.Scanner;

public class TickTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + ", enter your move (row and column between 0 and 2):");

            int row, col;
            try {
                row = sc.nextInt();
                col = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter numbers between 0 and 2.");
                sc.nextLine(); // clear the invalid input
                continue;
            }

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid move! Row and column must be between 0 and 2.");
                continue;
            }

            if (board[row][col] == ' ') {
                board[row][col] = player;
                if (haveWon(board, player)) {
                    printBoard(board);
                    System.out.println("🎉 Player " + player + " wins!");
                    gameOver = true;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("😐 It's a draw!");
                    gameOver = true;
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Cell already taken! Try again.");
            }
        }
        sc.close();
    }

    public static void printBoard(char[][] board) {
        System.out.println("\n  0   1   2");
        for (int row = 0; row < board.length; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
                if (col < 2) System.out.print(" | ");
            }
            System.out.println();
            if (row < 2) System.out.println("  ---------");
        }
        System.out.println();
    }

    public static boolean haveWon(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
