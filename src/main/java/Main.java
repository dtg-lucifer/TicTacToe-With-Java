import java.util.Scanner;

public class Main {
    static int[][] board = new int[3][3];
    static Scanner sc = new Scanner(System.in);
    static Integer player = 1;
    static Integer winner = 0;

    public static void main(String[] args) {
        while (winner == 0) {
            if (player == 1) {
                System.out.println("Player X's Move");
            } else {
                System.out.println("Player O's Move");
            }
            System.out.println("Enter the row for your move");
            int row = sc.nextInt();
            System.out.println("Enter the column for your move ");
            int col = sc.nextInt();
            int rowCount = 0, colCount = 0, diagonalCount = 0, crossDiagonalScore = 0;
            if (board[row][col] == 0) {
                board[row][col] = player;
            } else {
                System.out.println("Place is already occupied...!");
                continue;
            }
            for (int i = 0; i < board[0].length; i++) {
                if (board[row][i] == player) {
                    rowCount++;
                }
            }
            for (int j = 0; j < board.length; j++) {
                if (board[j][col] == player) {
                    colCount++;
                }
            }
            for (int i = 0, j = 0; i < board.length && j < board[0].length; i++, j++) {
                if (board[i][j] == player) {
                    diagonalCount++;
                }
            }
            for (int i = 0, j = board[0].length - 1; i < board.length && j >= 0; i++, j--) {
                if (board[i][j] == player) crossDiagonalScore++;
            }
            if (rowCount == 3 || colCount == 3 || diagonalCount == 3 || crossDiagonalScore == 3) {
                winner = player;
                if (winner == 1) {
                    System.out.println("Game has ended.... The winner is X");
                } else {
                    System.out.println("Game has ended.... The winner is O");
                }
            } else {
                player = player == 1 ? -1 : 1;
            }
            printBoard(board);
        }
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    System.out.print(" X ");
                } else if (board[i][j] == -1) {
                    System.out.print(" O ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
