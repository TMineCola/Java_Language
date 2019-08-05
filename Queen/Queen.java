import java.util.Scanner;

public class Queen {
    static int solutions = 0;
    /**
     * @param n board size
     */
    public static void queen(int n) {
        queen(n, new int[n][n], new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], 0);
        if(solutions == 0) {
            System.out.println("找不到解");
        }
    }
    /**
     *
     * @param n mean n * n size board
     * @param board record board status
     * @param col check column lock
     * @param ur check up right lock
     * @param dr check down right lock
     * @param row now select row
     */
    private static void queen(int n, int[][] board, boolean[] col, boolean[] ur, boolean[] dr, int row) {
        if(n == row) {
            solutions++;
            System.out.println("第 " + solutions + " 解：");
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("----------------");
        }
        for (int c = 0; c < n; c++) {
            if (col[c] == false && ur[row + c] == false && dr[row - c + n - 1] == false) {
                col[c] = ur[row + c] = dr[row - c + n - 1] = true;
                board[row][c] = 1;
                queen(n, board, col, ur, dr, row + 1);
                board[row][c] = 0;
                col[c] = ur[row + c] = dr[row - c + n - 1] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        queen(n);
    }
}