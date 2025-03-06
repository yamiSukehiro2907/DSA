package L20;

import java.util.*;

public class start_node_cyclic_linkedlist {
    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = this.random = null;
        }
    }

    public static void main(String[] args) {
        Node h1 = new Node(1);
        Node h2 = new Node(2);
        Node h3 = new Node(3);
        Node h4 = new Node(4);
        Node h5 = new Node(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h1.random = h3;
        h2.random = h1;
        h3.random = h5;
        h5.random = h3;
        h4.random = h3;
        Node ans = copy(h1);
    }

    private static Node copy(Node head) {
        if (head == null)
            return head;
        Node COPY = new Node(head.val);
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        temp = temp.next;
        while (temp != null) {
            Node node = temp;
            temp = temp.next;
            temp.next = COPY;
            COPY = node;
        }
        temp = head;
        return COPY;
    }
}
