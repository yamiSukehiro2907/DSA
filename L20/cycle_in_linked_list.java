package L20;

public class cycle_in_linked_list {
    public static void main(String[] args) {
        Node head = new Node(5);
        Node k = null;
        for (int i = 4; i > 0; i--) {
            Node node = new Node(i);
            node.next = head;
            head = node;
            if (i == 2) {
                k = node;
            }
        }
        Node temp = head;
        for (int i = 4; i > 0; i--)
            temp = temp.next;
        temp.next = k;
        System.out.println(k.val);
        print(head);
        Node ans = cycle(head);
        System.out.println(ans.val);
    }

    private static Node cycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    private static void print(Node head) {
        Node temp = head;
        for (int i = 0; i < 5; i++) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
}
