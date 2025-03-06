public class reverse_even_nodes {
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

    public static void main(String[] args) {
        Node head = new Node(10);
        for (int i = 9; i > 0; i--) {
            head = insert(head, new Node(i));
        }
        print(head);
        Node ans = reverse_even(clone(head));
        print(ans);
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

    private static Node reverse_even(Node head) {
        if (head == null || head.next == null)
            return head;
        Node prev = null;
        Node temp = head;
        while (temp != null && temp.next != null) {
            Node right = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            right.next = prev;
            prev = right;
        }
        temp = head;
        print(temp);
        print(prev);
        while (prev != null) {
            Node temp_right = temp.next;
            temp.next = prev;
            Node prev_right = prev.next;
            temp.next.next = temp_right;
            temp = temp_right;
            prev = prev_right;
        }
        return head;
    }
}
