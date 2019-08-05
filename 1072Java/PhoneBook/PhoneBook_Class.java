import java.util.Scanner;
public class PhoneBook_Class {
    private PhoneData[] allData;
    private int num;
    public PhoneBook_Class() {
        this.allData = new PhoneData[1000];
        this.num = 0;
    }
    public void show() {
        for(int i = 0; i < num; i++) {
            System.out.println("Name: " + allData[i].name + ", Phone: " + allData[i].number) ;
        }
    }
    public void find(String target) {
        for(int i = 0; i < num; i++) {
            if(allData[i].name.equals(target)) {
                System.out.println("Name: " + allData[i].name + ", Phone: " + allData[i].number);
                return;
            }
        }
        System.out.println("查無此人");
    }
    public void add(String name, String number) {
        if (num >= allData.length) {
            PhoneData[] tmp = allData.clone();
            allData = new PhoneData[num + 100];
            System.arraycopy(tmp, 0, allData, 0, tmp.length);
        }
        // now we can add data happily
        allData[num] = new PhoneData(name, number);
        num++;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        PhoneBook_Class pb = new PhoneBook_Class();
        for (int i = 0; i < n; i++) {
            pb.add(input.next(), input.next());
        }
        while (input.hasNext()) {
            String command = input.next();
            if (command.equals("show")) {
                pb.show();
            } else if (command.equals("find")) {
                pb.find(input.next());
            } else {
                System.out.println("無此指令");
            }
        }
    }
}

class PhoneData {
    String name;
    String number;
    public PhoneData(String name, String number) {
        this.name = name;
        this.number = number;
    }
}