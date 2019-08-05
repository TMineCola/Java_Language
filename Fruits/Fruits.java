import java.util.Scanner;

public class Fruits {
    private static boolean check = false;

    public static void buyFruit(int money, int need, int[] fruitPrice) {
        if(!buyFruit(money, need, fruitPrice, 0, new int[fruitPrice.length])) {
            System.out.println("無法買滿");
        }
    }
    private static boolean buyFruit(int money, int need, int[] fruitPrice, int pos, int[] result) {
        if(need == 0) {
            for(int i = 0; i < fruitPrice.length; i++) {
                System.out.print(fruitPrice[i] + "元的 " + result[i] + " 個");
                if(i != fruitPrice.length - 1) {
                    System.out.print("、");
                }
            }
            System.out.println();
            check = true;
        }
        for(int i = pos; i < fruitPrice.length; i++) {
            if(fruitPrice[i] <= money) {
                result[i] += 1;
                money -= fruitPrice[i];
                need--;
                buyFruit(money, need, fruitPrice, i, result);
                result[i] -= 1;
                money += fruitPrice[i];
                need++;
            }
        }
        return check;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int money = input.nextInt(), students = input.nextInt(), kinds = input.nextInt();
        int[] fruitPrice = new int[kinds];
        for(int i = 0; i < kinds; i++) {
            fruitPrice[i] = input.nextInt();
        }
        buyFruit(money, students, fruitPrice);
    }
}