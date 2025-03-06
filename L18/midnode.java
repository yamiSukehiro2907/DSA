
public class midnode {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node insert(Node head, Node node) {
        node.next = head;
        head = node;
        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static Node mid_node(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(14);
        for (int i = 11; i > 0; i--) {
            head = insert(head, new Node(i));
        }
        print(head);
        Node mid = mid_node(head);
        print(mid);
        Node rev = reverse(head);
        print(rev);
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node right = temp.next;
            temp.next = prev;
            prev = temp;
            temp = right;
        }
        return prev;
    }
}
