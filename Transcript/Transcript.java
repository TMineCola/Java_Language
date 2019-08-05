import java.util.Scanner;

class Student {
    String name;
    String id;
    int engScore;
    int mathScore;
    public double avg() {
        return (double)(this.engScore + this.mathScore) / 2.0;
    }
    public Student(String name, String id, int engScore, int mathScore) {
        this.name = name;
        this.id = id;
        this.engScore = engScore;
        this.mathScore = mathScore;
    }
}
// 成績單物件
// n 個學生
// 將學生依照成績平均排序
public class Transcript {
    String className;
    Student[] stuList;

    // 輸入學號找學生的方法
    public void find(String id) {
        for(int i = 0; i < this.stuList.length; i++) {
            if(this.stuList[i].id.equals(id)) {
                System.out.println(stuList[i].id + "\t" + stuList[i].name + "\t" + stuList[i].engScore + "\t" + stuList[i].mathScore);
                return;
            }
        }
    }

    // 排序成績單
    public void sort() {
        int i, j;
        Student tmp;
        for(i = 1; i < this.stuList.length; i++) {
            tmp = this.stuList[i];
            for(j = i; j > 0 && tmp.avg() > this.stuList[j - 1].avg(); j--) {
                this.stuList[j] = this.stuList[j - 1];
            }
            this.stuList[j] = tmp;
        }
    }

    // 印出成績單
    public void print() {
        System.out.println("-------- " + this.className + " Transcript --------");
        System.out.println("姓名\t英文\t數學\t平均");
        for(int i = 0; i < this.stuList.length; i++) {
            System.out.println(stuList[i].name + "\t" + stuList[i].engScore + "\t" + stuList[i].mathScore + "\t" + stuList[i].avg());
        }
        System.out.println("-------- " + this.className + " Transcript --------");
    }

    // 成績單建構子
    public Transcript(String className, Student[] initData) {
        this.className = className;
        this.stuList = initData;
    }

    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        // 輸入 n 表示有幾個學生要加入成績單
        int n = input.nextInt();
        // 建立成績單的陣列
        Student[] stuList = new Student[n];

        // 輸入學生的資料
        String name, id;
        int engScore, mathScore;
        for(int i = 0; i < n; i++) {
            name = input.next();
            id = input.next();
            engScore = input.nextInt();
            mathScore = input.nextInt();
            stuList[i] = new Student(name, id, engScore, mathScore);
        }

        // 產生成績單
        Transcript myClass = new Transcript("資管系", stuList);
        myClass.sort();
        myClass.print();
        String findId = input.next();
        myClass.find(findId);
    }
}