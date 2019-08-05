import java.util.Scanner;

class PhoneData {
    String name, phone;
    public PhoneData(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class PhoneBook {
    public static void show(PhoneData[] book) {
        for(int i = 0; i < book.length; i++) {
            System.out.println("Name: " + book[i].name + ", Phone: " + book[i].phone) ;
        }
    }
    public static void find(PhoneData[] book, String target) {
        for(int i = 0; i < book.length; i++) {
            if(book[i].name.equals(target)) {
                System.out.println("Name: " + book[i].name + ", Phone: " + book[i].phone);
                return;
            }
        }
        System.out.println("查無此人");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PhoneData[] book = new PhoneData[input.nextInt()];
        for(int i = 0; i < book.length; i++) {
            book[i] = new PhoneData(input.next(), input.next());
        }
        while(true) {
            String cmd = input.next();
            if(cmd.equals("find")) {
                find(book, input.next());
            } else if (cmd.equals("show")) {
                show(book);
            } else {
                System.out.println("無此指令");
            }
        }
    }
}