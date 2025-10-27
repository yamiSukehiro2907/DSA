public class reverseknodes {
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
        return node;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Node head = new Node(11);
        for (int i = 10; i > 0; i--) {
            head = insert(head, new Node(i));
        }
        print(head);
        Node reverse_groups_k = reversekgroups(clone(head), 3);
        print(reverse_groups_k);
        print(head);
        Node first_k_reversed = reverse_first_k(clone(head), 3);
        print(first_k_reversed);
        print(head);
    }

    private static Node clone(Node head) {
        if (head == null)
            return null;
        Node temp = head;
        Node newNode = new Node(temp.val);
        Node ans = newNode;
        temp = temp.next;
        while (temp != null) {
            newNode.next = new Node(temp.val);
            temp = temp.next;
            newNode = newNode.next;
        }
        return ans;
    }

    private static Node reverse_first_k(Node head, int k) {
        if (head == null)
            return null;
        Node temp = head, prev = null;
        for (int i = 0; i < k && temp != null; i++) {
            Node right = temp.next;
            temp.next = prev;
            prev = temp;
            temp = right;
        }
        head.next = temp;
        return prev;
    }

    private static Node reversekgroups(Node head, int k) {
        if (head == null)
            return null;
        Node temp = head, prev = null;
        for (int i = 0; i < k && temp != null; i++) {
            Node right = temp.next;
            temp.next = prev;
            prev = temp;
            temp = right;
        }
        head.next = (temp != null) ? reversekgroups(temp, k) : null;
        return prev;
    }
}
