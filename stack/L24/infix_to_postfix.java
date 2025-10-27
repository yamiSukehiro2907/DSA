package stack.L24;

import java.util.*;

public class infix_to_postfix {
    private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('/', 1);
        map.put('*', 2);
        map.put('+', 3);
        map.put('-', 4);
        String s = "3+10*(3-4/2)+3";
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isOperator(ch)) {
                if (!stack.isEmpty() && isGreater(stack.peek(), ch)) {
                    sb.append(stack.pop());
                    stack.push(ch);
                } else {
                    stack.push(ch);
                }
            } else {
                if (ch == '(')
                    stack.push(ch);
                else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                } else
                    sb.append(ch);
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb.toString());
    }

    private static boolean isGreater(char ch1, char ch2) {
        if (!map.containsKey(ch1))
            return false;
        return map.get(ch1) < map.get(ch2);
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '*' || ch == '-' || ch == '/';
    }

}
