import java.util.Scanner;
class Player {
    private int Iam;
    private int[] mycard = new int[52];
    private int numCard;
    public Player(int x) {
        Iam = x;
    }
    public boolean haveCard() {
        return numCard != 0;
    }
    public void add(int c) {
        // 先檢查有沒有一樣的
        int i = 0;
        for (; i < numCard; i++) {
            if (mycard[i] % 13 == c % 13)
                break;
        }
        if (i < numCard) { // 有一樣的
            mycard[i] = mycard[--numCard];
        } else {
            mycard[numCard++] = c;
        }
    }
    public int delete() { // 抽走一張牌
        int index = (int)(Math.random()*numCard);
        int c = mycard[index];
        mycard[index] = mycard[--numCard];
        return c;
    }
    public void print() {
        char[] color = new char[]{'S','H','D','C'};
        char[] num = new char[]{'A','K','Q','J','T','9','8','7','6','5','4','3','2'};
        System.out.print(Iam + " have ");
        for (int i = 0; i < numCard; i++) {
            System.out.print(color[mycard[i]/13]+""+num[mycard[i]%13]);
            if (i == numCard-1)
                System.out.println();
            else
                System.out.print(" ");
        }
    }
}
public class PlayCard {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] allCard = new int[52];
        for (int i = 0; i < 52; i++) // 產生52張牌
            allCard[i] = i;
        // shuffle allCard
        for (int i = 0; i < 1000; i++) {
            int x = (int)(Math.random()*52);
            int y = (int)(Math.random()*52);
            int tmp = allCard[x];
            allCard[x] = allCard[y];
            allCard[y] = tmp;
        }
        // 最後一張當鬼牌
        Player[] players= new Player[n];
        for (int i = 0; i < n; i++)
            players[i] = new Player(i+1);
        // 把51張牌依序給player
        for (int i = 0, assign=0; i < 51; i++, assign++) {
            assign = assign % n;
            players[assign].add(allCard[i]);
        }
        for (int i = 0; i < n; i++)
            players[i].print();
        // begin playing
        int whoplay = 0;
        while (true) {
            // 找下一個要抽牌的
            while (!players[whoplay].haveCard()) {
                whoplay = (whoplay+1) % n;
            }
            // 找要被抽的
            int toGet = (whoplay+1) %n;
            while (!players[toGet].haveCard()) {
                toGet = (toGet+1) % n;
            }
            if (toGet == whoplay) { // 找不到人抽, 那我就輸了
                System.out.println("Loser: " + (toGet + 1));
                break;
            }
            players[whoplay].print();
            int got = players[toGet].delete();
            players[whoplay].add(got);
            players[whoplay].print();
            whoplay = toGet;
        }
    }
}