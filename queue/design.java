package L26_Queue;

class Node {
    Node next;
    int val;

    Node(int val) {
        this.next = null;
        this.val = val;
    }
}

public class design {
    // Queue works on the principle of FIFO first in first out

    static class Queue {
        private Node head;
        private Node tail;

        Queue() {
            this.head = null;
            this.tail = null;
        }

        public void add(int val) {
            Node newNode = new Node(val);
            if (tail == null) {
                head = newNode;
                tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = tail.next;
            return;
        }

        public int remove() {
            if (head == null)
                return -1;
            int value = head.val;
            head = head.next;
            return value;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("Null");
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(3);
        q.add(7);
        q.add(12);
        q.add(8);
        q.add(3);
        q.print();
        q.remove();
        q.remove();
        q.print();
    }
}
