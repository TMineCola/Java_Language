class Node {
    int data;
    Node next;
}

public class Queue {
    private int size;
    private Node head, tail;
    public synchronized void append(int x) {
        Node tmp = new Node();
        tmp.data = x;
        if (tail == null) {
            head = tmp;
        } else {
            tail.next = tmp;
        }
        tail = tmp;
        size++;
    }
    public synchronized int remove() {
        Node tmp = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return tmp.data;
    }
    public synchronized boolean isEmpty() {
        return size == 0;
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i = 0; i <= 10; i++) {
            q.append(i);
        }
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}