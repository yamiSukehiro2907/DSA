package L24;

import java.util.*;

public class InfixToPostfixExpression {
    private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String expression = "10/(4-2)*6+9";
        String ans = solve(expression);
        System.out.println(ans);
    }

    private static String solve(String expression) {
        initialize();
        StringBuilder sb = new StringBuilder();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                sb.append(" ");
                i--;
            } else if (isOperator(ch)) {
                while (!operator.isEmpty() && operator.peek() != '(' && precedence(ch) < precedence(operator.peek())) {
                    sb.append(operator.pop()).append(" ");
                }
                operator.push(ch);
            } else if (ch == '(') {
                operator.push(ch);
            } else if (ch == ')') {
                while (!operator.isEmpty() && operator.peek() != '(') {
                    sb.append(operator.pop()).append(" ");
                }
                operator.pop();
            }
        }
        while (!operator.isEmpty()) {
            sb.append(operator.pop()).append(" ");
        }
        return sb.toString().trim();
    }

    private static boolean isOperator(char ch) {
        return map.containsKey(ch);
    }

    private static int precedence(char ch) {
        return map.get(ch);
    }

    private static void initialize() {
        map.put('-', 1);
        map.put('+', 2);
        map.put('*', 3);
        map.put('/', 4);
    }
}
