
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class merge_sorted_linkedlist {

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
        System.out.println("NULL");
    }

    public static Node merge(Node l1, Node l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Node ans;
        if (l1.val < l2.val) {
            ans = l1;
            l1 = l1.next;
        } else {
            ans = l2;
            l2 = l2.next;
        }
        Node head = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ans.next = l1;
                l1 = l1.next;
            } else {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        if (l1 != null)
            ans.next = l1;
        if (l2 != null)
            ans.next = l2;
        return head;
    }

    public static void main(String[] args) {
        Node l1 = new Node(48);
        l1 = insert(l1, new Node(23));
        Node l2 = new Node(24);
        for (int i = 10; i > 0; i--) {
            if (i % 2 == 0)
                l2 = insert(l2, new Node(i));
            else
                l1 = insert(l1, new Node(i));
        }
        print(l1);
        print(l2);
        Node merged = merge(l1, l2);
        print(merged);
    }
}
