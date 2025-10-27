package stack.L24;

import java.util.*;

public class delete_pair_of_consecutive_duplicates {
    public static void main(String[] args) {
        String s = "aabcddcb";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                while (!stack.isEmpty() && stack.peek() == s.charAt(i))
                    stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty())
            return;
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
