import java.util.Scanner;

public class ThreeNadd1 {
    public static int compute(int input, int times) {
        if(input == 1) {
            return times;
        }
        if(input % 2 == 1) {
            input = input * 3 + 1;
            times++;
            return compute(input, times);
        } else {
            input /= 2;
            times++;
            return compute(input, times);
        }
    }
    public static void execute(int a, int b) {
        int max = Integer.MIN_VALUE;
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        for(int i = a; i < b; i++) {
            if(compute(i, 1) > max) {
                max = compute(i, 1);
            }
        }
        System.out.println(a + " " + b + " " + max);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextInt()) {
            execute(input.nextInt(), input.nextInt());
        }
    }
}