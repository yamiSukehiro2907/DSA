public class merge_sort {
    public static void main(String[] args) {
        Node head = new Node(45);
        Node temp = head;
        for (int i = 10; i >= 0; i--) {
            Node node = new Node(i);
            temp.next = node;
            temp = temp.next;
        }
        print(head);
        Node sorted = sort(head);
        print(sorted);
        print(head);
    }

    private static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    private static Node sort(Node head) {
        if (head == null || head.next == null)
            return head;
        Node second_part = midNode(head);
        head = sort(head);
        second_part = sort(second_part);
        return merge(head, second_part);
    }

    private static Node merge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

    private static Node midNode(Node head) {
        if (head == null || head.next == null)
            return head;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node part2 = slow.next;
        slow.next = null;
        return part2;
    }
}

/*
 * public ListNode sortList(ListNode A) {
 * return sort(A);
 * }
 * private ListNode sort(ListNode head){
 * if(head == null || head.next == null) return head;
 * ListNode second_part = divide(head);
 * head = sort(head);
 * second_part = sort(second_part);
 * return merge(head , second_part);
 * }
 * private ListNode divide(ListNode head){
 * ListNode slow = head , fast = head;
 * while(fast != null && fast.next != null){
 * fast = fast.next.next;
 * if(fast != null) slow = slow.next;
 * }
 * ListNode part2 = slow.next;
 * slow.next = null;
 * return part2;
 * }
 * private ListNode merge(ListNode temp1 , ListNode temp2){
 * if(temp1 == null) return temp2;
 * if(temp2 == null) return temp1;
 * if(temp1.val < temp2.val){
 * temp1.next = merge(temp1.next , temp2);
 * return temp1;
 * }else{
 * temp2.next = merge(temp1 , temp2.next);
 * return temp2;
 * }
 * }
 */