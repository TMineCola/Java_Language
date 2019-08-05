import java.util.Scanner;

public class Segment {
    public static void sort(int amount, int[][] data) {
        for(int sortedLen = 1; sortedLen < amount; sortedLen++) {
            int temp[] = data[sortedLen];
            int pos = sortedLen - 1;
            while(pos >= 0 && data[pos][0] > temp[0]) {
                data[pos + 1] = data[pos];
                pos--;
            }
            data[pos + 1] = temp;
        }
        // System.out.println("----- Afer sorting -----");
        // for(int i = 0; i < amount; i++) {
        //     System.out.println(data[i][0] + " " + data[i][1]);
        // }
        // System.out.println("------- End -------");
        compute(amount, data);
    }
    public static void compute(int amount, int[][] data) {
        int end = 0, total = 0;
        // System.out.println("----- Start computing -----");
        for(int i = 0; i < amount; i++) {
            // System.out.println("Now end: " + end + ", total: " + total);
            if(data[i][0] >= end) {
                total += data[i][1] - data[i][0];
                end = data[i][1];
            }
            if(data[i][0] < end && data[i][1] > end) {
                total += data[i][1] - end;
                end = data[i][1];
            }
        }
        // System.out.println("------- End -------");
        System.out.println(total);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int amount = input.nextInt();
        int dataArray[][] = new int[amount][];
        for(int i = 0; i < amount; i++) {
            dataArray[i] = new int[]{input.nextInt(), input.nextInt()};
        }
        sort(amount, dataArray);
    }
}