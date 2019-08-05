import java.util.Scanner;

class Children {
    String name;
    Children next;
}

public class LineUp{
    private int size;
    private Children head, tail;

    public boolean isEmpty() {
        return size == 0;
    }

    public void printLine() {
        Children tmp = head;
        while(tmp != null) {
            System.out.print(tmp.name);
            if(tmp.next != null) {
                System.out.print(" -> ");
            }
            tmp = tmp.next;
        }
    }

    // 增加一筆到尾巴
    public void append(String name) {
        Children tmp = new Children();
        tmp.name = name;
        if (tail == null) {
            head = tmp;
        } else {
            tail.next = tmp;
        }
        tail = tmp;
        size++;
    }

    // 增加一筆到指定位置
    public void append(String name, int site) {
        Children tmp = new Children();
        tmp.name = name;
        // 加到頭
        if(site == 0 && size != 0) {
            Children oldHead = head;
            head = tmp;
            tmp.next = oldHead;
            return;
        }
        // 超過 Size 或原本是空隊伍就加到尾巴
        if(site >= size) {
            this.append(name);
            return;
        }
        // 其餘插入
        Children currentC = head, nextC = head.next;
        for(int i = 1; i < site; i++) {
            currentC = currentC.next;
            nextC = nextC.next;
        }
        currentC.next = tmp;
        tmp.next = nextC;
    }

    public void remove(String name) {
        Children tmp = head;
        while(tmp.next != null) {
            if(tmp.next.name.equals(name)) {
                if(tmp.next.next != null) {
                    tmp.next = tmp.next.next;
                } else {
                    tail = tmp;
                }
                size--;
            }
            tmp = tmp.next;
        }
    }

    public static void move(LineUp oldLine, String name, LineUp newLine, int site) {
        if(oldLine.remove(name)) {
            newLine.append(name, site);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        // 初始化隊伍
        LineUp[] lines = new LineUp[n];
        for(int i = 0; i < n; i++) {
            lines[i] = new LineUp();
        }

        while(true) {
            String command = input.next();
            // 新增
            if(command.equals("add")) {
                int lineNum = input.nextInt();
                String name = input.next();
                lines[input.nextInt()].append(input.next());
            }
            // 刪除
            if(command.equals("remove")) {
                int lineNum = input.nextInt();
                String name = input.next();
                lines[lineNum].remove(name);
            }
            // 修改
            if(command.equals("move")) {
                int lineNum = input.nextInt();
                String name = input.next();
                int newLineNum = input.nextInt();
                int site = input.nextInt();
                move(lines[lineNum], name, lines[newLineNum], site);
            }
            // 結束
            if(command.equals("end")) {
                for(int i = 0; i < n; i++) {
                    System.out.print("[" + i + "] ");
                    lines[i].printLine();
                    System.out.println();
                }
                break;
            }
        }
    }
}