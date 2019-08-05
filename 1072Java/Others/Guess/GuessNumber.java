import java.util.Scanner;

public class GuessNumber {
    private int[] answer;
    private int guessTimes;

    public GuessNumber(int words) {
        // 初始化變數
        guessTimes = 0;
        answer = new int[words];

        // 產生答案
        boolean[] numberPool = new boolean[10];
        for(int i = 0; i < words; i++) {
            // int randIndex = (i == 0) ? (int)(Math.random() * 9 + 1) : (int)(Math.random() * 10);
            int randIndex = (int)(Math.random() * 10);
            while(numberPool[randIndex]) {
                randIndex = (int)(Math.random() * 10);
            }
            answer[i] = randIndex;
            numberPool[randIndex] = true;
        }
    }

    public boolean checkRepeat(String guess) {
        boolean[] numberPool = new boolean[10];

        for(int i = 0; i < guess.length(); i++) {
            if(numberPool[Character.getNumericValue(guess.charAt(i))]) {
                return false;
            }
            numberPool[Character.getNumericValue(guess.charAt(i))] = true;
        }

        return true;
    }

    public boolean checkWin(String guess) {
        int countA = 0, countB = 0;
        for(int i = 0; i < answer.length; i++) {
            if(answer[i] == Character.getNumericValue(guess.charAt(i))) {
                countA++;
            }
            for(int j = 0; j < answer.length; j++) {
                if(i == j) {
                    continue;
                }
                if(answer[i] == Character.getNumericValue(guess.charAt(j))) {
                    countB++;
                }
            }
        }

        System.out.println(countA + "A" + countB + "B");

        if(countA == answer.length) {
            return true;
        }
        return false;
    }

    public void play() {
        Scanner input = new Scanner(System.in);
        String guess;
        do {
            System.out.print("Please guess a number: ");
            guess = input.next();
            if(guess.length() != answer.length || !checkRepeat(guess)) {
                System.out.println("Guess error, please change another");
                continue;
            }
            if(checkWin(guess)) {
                break;
            }
        } while(true);
        System.out.println("You Win!");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Choose your number size: ");
            size = input.nextInt();
            if(size > 0 && size <= 10) {
                break;
            }
            System.out.println("Size error");
        } while(true);
        GuessNumber game = new GuessNumber(size);
        game.play();
    }
}