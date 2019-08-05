import java.util.Scanner;
public class ReverseAndAdd {
    public static int reverse(int source) {
        int result = 0;
        while(source != 0) {
            result = result * 10 + source % 10;
            source /= 10;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int source = input.nextInt();
        int add = 0;
        do {
            source += reverse(source);
            add++;
        } while(source != reverse(source));
        System.out.println("Result: " + source + ", for " + add + " times");
    }
}