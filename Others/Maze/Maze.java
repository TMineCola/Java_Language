import java.util.Scanner;

public class Maze {
    public static void print(int[][] maze) {
        System.out.println("===============");
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[0].length; j++) {
                System.out.printf("%d ", maze[i][j]);
            }
            System.out.println();
        }
    }
    public static void findPath(int[][] maze, int currentX, int currentY, int endX, int endY) {
        int[][] dir = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        if(currentX == endX && currentY == endY) {
            maze[currentX][currentY] = 1;
            print(maze);
            return;
        }
        for(int i = 0; i < dir.length; i++) {
            if(currentX >= 0 && currentX < maze.length && currentY >= 0 && currentY < maze.length && maze[currentX][currentY] == 0) {
                maze[currentX][currentY] = 1;
                findPath(maze, currentX + dir[i][0], currentY + dir[i][1], endX, endY);
                maze[currentX][currentY] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int[][] maze = new int[size][size];
        // 讀取地圖
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                maze[i][j] = input.nextInt();
            }
        }
        int sx = input.nextInt(), sy = input.nextInt(), ex = input.nextInt(), ey = input.nextInt();
        findPath(maze, sx, sy, ex, ey);
    }
}