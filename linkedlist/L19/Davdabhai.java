import java.util.BitSet;
public class Davdabhai {
    static class Node {
        int value;
        Node next;

        Node(int v) {
            this.value = v;
        }
    }

    private static Node head;
    private static Node tail;
    private static int size = 1;

    public static void insert_node(int position, int value) {

        if (position > size)
            return;

        if (position == 1) {
            Node a = new Node(value);
            a.next = head;
            head = a;

            if (tail == null) {
                tail = head;
            }

            size++;
            return;
        } else if (position == size + 1) {
            Node a = new Node(value);
            tail.next = a;
            tail = a;
            size++;
            return;
        }
        Node temp = head; // 1 is this itself, hence loop from 1 //// 1 indexing dude
        for (int i = 2; i < position - 1; i++) {
            temp = temp.next;
        }
        Node a = new Node(value);
        a.next = temp.next;
        temp.next = a;
        size++;
        return;
    }

    public static void delete_node(int position) {

        if (position > size)
            return;

        // @params position, integer
        if (position == 1) {
            head = head.next;
            size--;
            return;
        } else if (position == size) {
            Node node = head;

            for (int i = 1; i < size - 1; i++) {
                node = node.next;
            }

            tail = node;
            node.next = null;
            size--;
            return;
        } else {
            Node node = head;

            for (int i = 0; i < position - 1; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            size--;
            return;
        }

    }

    public static void print_ll() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value);
            if (temp.next != null) {
                System.out.print(" ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BitSet set = new BitSet();
        set.set(1);
        
        insert_node(1, 22);
        insert_node(2, 78);
        print_ll();
    }
}