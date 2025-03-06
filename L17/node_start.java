public class node_start {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private static Node head;

    public static Node insert(Node node, int k) {
        if (k == 0) {
            node.next = head;
            head = node;
            return head;
        }
        Node temp = head;
        while (temp != null && k > 1) {
            temp = temp.next;
            k--;
        }
        if (temp == null)
            return head;
        node.next = temp.next;
        temp.next = node;
        return head;
    }

    public static Node remove(int k) {
        if (head == null)
            return null;
        if (k == 0) {
            head = head.next;
            return head;
        }
        Node temp = head;
        while (temp != null && k > 1) {
            k--;
            temp = temp.next;
        }
        if (temp == null || temp.next == null)
            return head;
        temp.next = temp.next.next;
        return head;
    }

    public static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        insert(new Node(10), 0);
        insert(new Node(20), 1);
        insert(new Node(15), 1);
        printList(); // 10 -> 15 -> 20 -> NULL

        remove(1);
        printList(); // 10 -> 20 -> NULL
    }

}