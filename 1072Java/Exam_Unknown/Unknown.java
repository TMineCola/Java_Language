import java.math.BigInteger;
import java.util.Scanner;

public class Unknown {
    static int[][] qmIndex = new int[3][];
    public static void getStart(StringBuilder[] source) {
        // 處理位置
        for(int i = 0; i < 3; i++) {
            // 計算問號, 總長度減掉問號被抽掉後的長度
            qmIndex[i] = new int[source[i].length() - source[i].toString().replace("?", "").length()];
            // 記住問號的位置
            int index = 0;
            for(int j = 0; j < source[i].length(); j++) {
                if(source[i].charAt(j) == '?') {
                    // 把問號抽換為 0
                    source[i].setCharAt(j, '0');
                    // 紀錄問號所在索引值
                    qmIndex[i][index] = j;
                    index++;
                }
            }
        }
        // 開始測試
        goTest(source[0], source[1], source[2]);
    }
    public static StringBuilder mergeNumber(StringBuilder input, int[] index, int number) {
        if(index.length == 0) {
            return input;
        }
        String formatNumber = String.valueOf(number);
        for(int i = index.length - 1; i >= index.length - formatNumber.length(); i--) {
            input.setCharAt(index[i], formatNumber.charAt(index.length - i - 1));
        }
        return input;
    }
    public static void goTest(StringBuilder x, StringBuilder y, StringBuilder z) {
        // 窮舉找解
        for(int i = 0; i < Math.pow(10, qmIndex[0].length); i++) {
            x = mergeNumber(x, qmIndex[0], i);
            for(int j = 0; j < Math.pow(10, qmIndex[1].length); j++) {
                y = mergeNumber(y, qmIndex[1], j);
                for(int k = 0; k < Math.pow(10, qmIndex[2].length); k++) {
                    z = mergeNumber(z, qmIndex[2], k);
                    if(new BigInteger(x.toString()).multiply(new BigInteger(y.toString())).equals(new BigInteger(z.toString())) && x.toString().charAt(0) != '0' && y.toString().charAt(0) != '0' && z.toString().charAt(0) != '0') {
                        System.out.println(x.toString() + " * " + y.toString() + " = " + z.toString());
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder[] source = new StringBuilder[3];
        // 讀取原始資料
        for(int i = 0; i < 3; i++) {
            source[i] = new StringBuilder();
            source[i].append(input.next());
        }
        // 計算
        getStart(source);
    }
}