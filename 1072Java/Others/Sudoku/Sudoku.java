import java.util.Scanner;

public class Sudoku {
    private static void put(int v, int i, int j, boolean[][] row, boolean[][] col, boolean[][] area) {
        row[i][v - 1] = true;
        col[j][v - 1] = true;
        area[i / 3 * 3 + j / 3][v - 1] = true;
    }
    private static void unput(int v, int i, int j, boolean[][] row, boolean[][] col, boolean[][] area) {
        row[i][v - 1] = false;
        col[j][v - 1] = false;
        area[i / 3 * 3 + j / 3][v - 1] = false;
    }
    public static void findAns(int[][] data) {
        boolean[][] row = new boolean[9][9]; // false: can put, true: forbidden
        boolean[][] col = new boolean[9][9];
        boolean[][] area = new boolean[9][9];
        // now set ups constraint from input data
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(data[i][j] != 0) {
                    put(data[i][j], i, j, row, col, area);
                }
            }
        }
        findAns(data, 0, 0, row, col, area);
    }
    private static void findAns(int[][] data, int r, int c, boolean[][] row, boolean[][] col, boolean[][] area) {
        if(r == 9) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
            }
            return;
        }

        int nextc = (c + 1) % 9;
        int nextr = r;
        if(nextc == 0) {
            nextr = r + 1;
        }
        if(data[r][c] != 0) {
            findAns(data, nextr, nextc, row, col, area);
        } else {
            for(int v = 1; v <= 9; v++) {
                if(row[r][v - 1] == false && col[c][v - 1] == false && area[r / 3 * 3 + c / 3][v - 1] == false) {
                    data[r][c] = v;
                    put(v, r, c, row, col, area);
                    findAns(data, nextr, nextc, row, col, area);
                    unput(v, r, c, row, col, area);
                    data[r][c] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] data = new int[9][9];
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                data[i][j] = input.nextInt();
            }
        }
        findAns(data);
    }
}