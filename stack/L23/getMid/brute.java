package L23.getMid;

public class brute {
    private class Node {
        Node next;
        Node prev;
        int val;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private Node fast;
    private Node slow;
    private int size;

    brute() {
        this.fast = null;
        this.slow = null;
        this.size = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            fast = newNode;
            slow = newNode;
        } else {
            fast.next = newNode;
            newNode.prev = fast;
            fast = newNode;
            if (size % 2 == 0) {
                slow = slow.next;
            }
        }
        size++;
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Stack is Empty");
        int value = fast.val;
        if (fast == slow) {
            fast = slow = null;
        } else {
            fast = fast.prev;
            fast.next = null;
            if (size % 2 == 1) {
                slow = slow.prev;
            }
        }
        size--;
        return value;
    }

    public int getMid() {
        if (isEmpty())
            throw new RuntimeException("Stack is Empty!");
        return slow.val;
    }

    public int popMid() {
        if (isEmpty())
            throw new RuntimeException("Stack is Empty!");
        int value = slow.val;
        if (slow == fast) {
            slow = fast = null;
        } else if (slow.prev == null) {
            slow = slow.next;
            slow.prev = null;
        } else if (slow.next == null) {
            slow = slow.prev;
            slow.next = null;
        } else {
            slow.prev.next = slow.next;
            slow.next.prev = slow.prev;
            if (size % 2 == 0) {
                slow = slow.next;
            } else {
                slow = slow.prev;
            }
        }
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
