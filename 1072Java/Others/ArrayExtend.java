import java.util.Scanner;

public class ArrayExtend {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;
        int[] data = new int[5];
        while(true) {
            if(num >= data.length) {
                int[] tmp = data.clone();
                data = new int[num + 5];
                System.arraycopy(tmp, 0, data, 0, tmp.length);
                System.out.println("Now array length is: " + data.length);
            }
            data[num] = input.nextInt();
            num++;

            for(int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.print("\n");
        }
    }
}