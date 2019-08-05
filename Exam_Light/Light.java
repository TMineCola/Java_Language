import java.util.Scanner;

public class Light {
    private int[][] map;
    private int n;

    public Light(int n) {
        this.n = n;
        map = new int[n][n];
    }

    public boolean bright() {
        int[][] room = new int[n + 2][n + 2];
        // 設定邊界
        for(int i = 0; i < n + 2; i++) {
            for(int j = 0; j < n + 2; j++) {
                room[i][j] = (i > 0 && j > 0 && i < n + 1 && j < n + 1) ? 0 : -1;
            }
        }
        // 點亮房間
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(map[i - 1][j - 1] == 1) {
                    room[i][j] = (room[i][j] == 0) ? 1 : 0;
                    room[i - 1][j] = (room[i - 1][j] == -1) ? -1 : (room[i - 1][j] == 0) ? 1 : 0;
                    room[i + 1][j] = (room[i + 1][j] == -1) ? -1 : (room[i + 1][j] == 0) ? 1 : 0;
                    room[i][j - 1] = (room[i][j - 1] == -1) ? -1 : (room[i][j - 1] == 0) ? 1 : 0;
                    room[i][j + 1] = (room[i][j + 1] == -1) ? -1 : (room[i][j + 1] == 0) ? 1 : 0;
                }
            }
        }
        // 檢查情況
        int count = 0;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(room[i][j] == 1) {
                    count++;
                }
            }
        }
        if(count == n * n) {
            return true;
        } else {
            return false;
        }
    }

    public void myPrint() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void press(int pos) {
        if(pos >= n * n) {
            if(this.bright()) {
                this.myPrint();
            }
            return;
        }
        for(int i = 0; i < 2; i++) {
            map[pos / n][pos % n] = i;
            press(pos + 1);
            map[pos / n][pos % n] = 0;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Light roomA = new Light(input.nextInt());
        roomA.press(0);
    }
}