package L23.getMIn;

import java.util.*;

public class brute {
    private Stack<Integer> stack;

    brute() {
        this.stack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
    }

    public int peek() {
        return stack.peek();
    }

    public int pop() {
        return stack.pop();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        Stack<Integer> newStack = new Stack<>();
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            if (min > value)
                min = value;
            newStack.push(value);
        }
        while (!newStack.isEmpty()) {
            int value = newStack.pop();
            if (min > value)
                min = value;
            stack.push(value);
        }
        return min;
    }
}
