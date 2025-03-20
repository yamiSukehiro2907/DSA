package L23;

public class Stack_using_array {
    private int[] stack;
    private int index;
    private int capacity;

    Stack_using_array(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.index = -1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new Error("Stack Overflow");
        }
        stack[++index] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new Error("Stack Underflow");
        }
        return stack[index--];
    }

    public int peek() {
        if (isEmpty())
            throw new Error("Stack is Empty");
        return stack[index];
    }

    public boolean isEmpty() {
        return index == -1;
    }

    public int size() {
        return index + 1;
    }

    public boolean isFull() {
        return index + 1 >= capacity;
    }
}
