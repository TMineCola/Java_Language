import java.util.Scanner;

public class Marathon {
    public static void findSum(int[]data, int target) {
        findSum(data, target, 0, 0, new int[data.length]);
    }
    private static void findSum(int[] data, int target, int from, int got, int[] result) {
        if (target == 0) {
            for(int i = 0; i < got; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        if(got == data.length) {
            return;
        }

        for(int i = from; i < data.length; i++) {
            result[got] = data[i];
            findSum(data, target - data[i], i + 1, got + 1, result);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int target = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        findSum(data, target);
    }
}