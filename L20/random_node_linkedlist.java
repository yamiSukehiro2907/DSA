package L20;

import java.util.*;

public class random_node_linkedlist {
    static class ListNode {
        int val;
        ListNode next;
        ListNode random;

        ListNode(int val) {
            this.val = val;
            this.next = this.random = null;
        }
    }

    private static ListNode deepCopy(ListNode head) {
        if (head == null)
            return null;
        ListNode copy = new ListNode(head.val);
        Map<ListNode, ListNode> map = new HashMap<>();
        map.put(head, copy);
        ListNode temp1 = head;
        ListNode temp2 = copy;
        while (temp1 != null && temp1.next != null) {
            ListNode node = new ListNode(temp1.next.val);
            temp2.next = node;
            temp1 = temp1.next;
            temp2 = temp2.next;
            map.put(temp1, temp2);
        }
        temp1 = head;
        temp2 = copy;
        while (temp1 != null) {
            if (temp1.random != null) {
                temp2.random = map.get(temp1.random);
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return copy;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode arr[] = new ListNode[5];
        arr[0] = head;
        ListNode temp = head;
        for (int i = 2; i <= 5; i++) {
            temp.next = new ListNode(i);
            arr[i - 1] = temp.next;
            temp = temp.next;
        }
        arr[0].random = arr[4];
        arr[1].random = arr[3];
        arr[2].random = arr[2];
        arr[3].random = arr[1];
        arr[4].random = arr[0];
        print(head);
        ListNode copy = deepCopy(head);
        print(copy);
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        System.out.println("Linear connection");
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
        System.out.println("Random Connection");
        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                System.out.print(temp.val + " -> " + temp.random.val + " ");
            } else {
                System.out.print(temp.val + " -> Null ");
            }
            if (temp.next != null)
                System.out.print(" , ");
            temp = temp.next;
        }
        System.out.println();
    }
}
