import java.util.Scanner;
public class Horse {
    // count for total solution
    static int count = 0;
    // print Answer
    public static void print(int[][] horse) {
        count++;
        for(int i = 0; i < horse.length; i++) {
            for(int j = 0; j < horse[0].length; j++) {
                System.out.printf("%2d ", horse[i][j]);
            }
            System.out.println();
        }
    }

    public static void horseRun(int[][] horse, int currentX, int currentY, int step) {
        int[][] dir = new int[][]{{-2,1},{-2,-1},{-1,2},{-1,-2},{1,2},{1,-2},{2,1},{2,-1}};
        // Join step
        horse[currentX][currentY] = step;
        // go around the map
        if(step == horse.length * horse[0].length) {
            print(horse);
            return;
        }
        for(int i = 0; i < dir.length; i++) {
            // if next X, Y not over map and it is empty (0), then go
            if(currentX + dir[i][0] >= 0 && currentX + dir[i][0] < horse.length && currentY + dir[i][1] >= 0 && currentY + dir[i][1] < horse[0].length && horse[currentX + dir[i][0]][currentY + dir[i][1]] == 0) {
                horseRun(horse, currentX + dir[i][0] , currentY + dir[i][1], step + 1);
                horse[currentX + dir[i][0]][currentY + dir[i][1]] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt(), y = input.nextInt(), x = input.nextInt();
        horseRun(new int[n][m], x, y, 1);
        System.out.println("Total: " + count);
    }
}