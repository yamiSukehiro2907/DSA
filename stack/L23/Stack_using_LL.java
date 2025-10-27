package L23;

class Node {
    Node next;
    int val;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Stack_using_LL {
    private Node head;

    Stack_using_LL(int capacity) {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return head.val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        int value = head.val;
        head = head.next;
        return value;
    }

    public void push(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }
}
