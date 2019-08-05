import java.util.Scanner;

public class QuickSort {
    public static void qSort(int left, int right, int[] data) {
        if(left >= right) {
            return;
        }
        // partition
        int v = data[left]; // 當標的物
        int l = left, r = right + 1;
        while(true) {
            // find l side value > v
            while(l <= right && data[++l] <= v);
            // find r side value <= v
            while(data[--r] > v);
            // if l < r, change data[l] and data
            if(l >= r) {
                break;
            }
            int tmp = data[l];
            data[l] = data[r];
            data[r] = tmp;
        }
        // swap data[0] and data[r]
        data[left] = data[r];
        data[r] = v;
        qSort(left, r - 1, data);
        qSort(r + 1, right, data);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] data = new int[input.nextInt()];
        for(int i = 0; i < data.length; i++) {
            data[i] = input.nextInt();
        }
        qSort(0, data.length - 1, data);
        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}