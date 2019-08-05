public class QuickSort_V2 {
    public static void qSort(int left, int right, int[] data) {
        if(left >= right) {
            return;
        }
        // partition
        int v = data[left]; // 當標的物
        int l = left + 1, r = right;
        while(true) {
            // find l side value > v
            while(l <= right && data[l] <= v) {
                l += 1;
            }
            // find r side value <= v
            while(data[r] > v) {
                r -= 1;
            }
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
        qsort(left, r - 1, data);
        qsort(r + 1, right, data);
    }
    public static void main(String[] args) {
        
    }
}