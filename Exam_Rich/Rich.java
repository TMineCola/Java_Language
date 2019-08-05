import java.util.Scanner;

public class Rich {
    public static int inArray(int[] source, int data) {
        for(int i = 0; i < source.length; i++) {
            if(source[i] == data) {
                return 1;
            }
        }
        return 0;
    }
    public static void comb(int n, int m, int[] shouldGet, int shouldUse, int from, int got, int[] result) {
        if (m == got && shouldUse == 0) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        if (m < got || m - (got + shouldUse) < 0) {
            return;
        }
        for(int i = from; i < n + 1; i++) {
            result[got++] = i;
            comb(n, m, shouldGet, shouldUse - inArray(shouldGet, i), i + 1, got, result);
            got--;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt(), k = input.nextInt();
        int[] shouldGet = new int[k];
        for(int i = 0; i < k; i++) {
            shouldGet[i] = input.nextInt();
        }
        comb(n, m, shouldGet, shouldGet.length, 1, 0, new int[m]);
    }
}