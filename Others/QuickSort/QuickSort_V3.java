import java.util.Scanner;

// Insertion Sort -> 處理少、快排好的資料 (32/64 左右差不多, > 100 慢)
// Quick Sort -> 大資料好處理

public class QuickSort_V3 {
    // public static void showData(int[] data, int left, int right, int l, int r) {
    //     System.out.println("-----------------------");
    //     for(int i = 0; i < data.length; i++) {
    //         System.out.println(data[i] + " ");
    //     }
    //     System.out.print("\n");
    //     System.out.println("Left: " + left + "\tRight: " + right);
    //     System.out.println("l: " + l + "\tr: " + r);
    //     System.out.println("-----------------------");
    // }
    public static void qSort(int[] data) {
        qSort(0, data.length - 1, data);
        // inserrtion sort
        //iSort(0, data.length - 1, data);
    }
    private static void qSort(int left, int right, int[] data) {
        /*
        if(left + 32 >= right) {
            return;
        }
        */
        int mid = (left + right) / 2;
        if(data[left] > data[mid]) {
            int tmp = data[left];
            data[left] = data[mid];
            data[mid] = tmp;
        }
        if(data[left] > data[right]) {
            int tmp = data[right];
            data[right] = data[left];
            data[left] = tmp;
        }
        if(data[mid] > data[right]) {
            int tmp = data[right];
            data[right] = data[mid];
            data[mid] = tmp;
        }
        if(left + 2 >= right) {
            return;
        }
        int v = data[mid];
        data[mid] = data[right - 1];
        data[right - 1] = v;
        // partition
        int l = left, r = right - 1;
        while(true) {
            // find l side value > v
            while(l < right - 1 && data[++l] <= v);
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
        // swap data[l] and data[right - 1]
        data[right - 1] = data[l];
        data[l] = v;
        if(l - left < right - l) {
            qSort(left, l - 1, data);
            qSort(l + 1, right, data);
        } else {
            qSort(l + 1, right, data);
            qSort(left,  l - 1, data);
        }
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