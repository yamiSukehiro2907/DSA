package L26_Queue;

import java.util.*;

public class queue_using_stack {
    // 6 7 8 6 5 6
    public static void main(String[] args) {
        class Queue {
            private Stack<Integer> main;

            Queue() {
                this.main = new Stack<>();
            }

            public void add(int val) {
                main.push(val);
            }
            public int remove(){
                Stack<Integer> temp = new Stack<>();
                while(!main.isEmpty()) temp.push(main.pop());
                int value = temp.pop();
            }
        }
    }
}
