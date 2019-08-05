import java.util.Scanner;

class Poly {
    float coeff;
    int exp;
    public Poly(float coeff, int exp) {
        this.coeff = coeff;
        this.exp = exp;
    }
}

public class PolyMul {
    public static void print(Poly a) {
        System.out.println(a.coeff + "^" + a.exp);
    }
    // 顯示結果
    public static void print(Poly[] src) {
        System.out.print(src[0].coeff + "^" + src[0].exp);
        for(int i = 1; i < src.length; i++) {
            System.out.print(((src[i].coeff >= 0) ? ("+" + src[i].coeff) : (src[i].coeff)) + "^" + src[i].exp);
        }
        System.out.println();
    }
    // 後移
    public static void move(Poly[] src, int from) {
        Poly tmp = src[from];
        for(int i = from + 1; i < src.length; i++) {
            src[i - 1] = src[i];
        }
        src[src.length - 1] = tmp;
    }
    // 合併
    public static Poly[] merge(Poly[] src) {
        // 計算長度
        int size = src.length;
        // 檢查合併項目
        for(int i = 0; i < size; i++) {
            for(int j = i + 1; j < size; j++) {
                // 指數相同
                if(src[i].exp == src[j].exp) {
                    // 合併
                    src[i].coeff += src[j].coeff;
                    // 後移
                    move(src, j);
                    size--;
                }
            }
        }
        Poly[] result = new Poly[size];
        for(int i = 0; i < size; i++) {
            result[i] = src[i];
        }
        return result;
    }
    // 相加
    public static void add(Poly[] src, Poly[] dest) {
        // 先合併
        merge(src);
        merge(dest);
        // 檢查有多少不同的指數
        // 排列指數
        // 相加
    }
    // 排列
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 讀入兩多項式
        String[] poly_src1 = input.nextLine().split(" ");
        String[] poly_src2 = input.nextLine().split(" ");
        // 產生多項式
        Poly[] poly_data = new Poly[poly_src1.length / 2 + poly_src2.length / 2];
        for(int i = 0; i < poly_data.length; i++) {
            poly_data1[i] = new Poly(Integer.parseInt(poly_src1[i * 2]), Integer.parseInt(poly_src1[i * 2 + 1]));
        }
        // 多項式合併
        print(merge(poly_data1));
    }
}