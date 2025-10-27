package L26_Queue;

import java.util.*;

public class queue_using_stack {
    static class queue {
        private Stack<Integer> reverse;
        private Stack<Integer> rightOrder;

        queue() {
            this.reverse = new Stack<>();
            this.rightOrder = new Stack<>();
        }

        public void add(int val) {
            reverse.push(val);
        }

        public int remove() {
            if (reverse.isEmpty() && rightOrder.isEmpty())
                throw new RuntimeException("Queue is Empty!");
            if (rightOrder.isEmpty()) {
                while (!reverse.isEmpty())
                    rightOrder.push(reverse.pop());
            }
            return rightOrder.pop();
        }
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(6);
        q.add(5);
        q.add(6);
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
