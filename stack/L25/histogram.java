package stack.L25;
import java.util.*;

public class histogram {
    public static void main(String[] args) {
        int arr[] = { 4, 2, 6, 8, 3, 1, 5 };
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        int left[] = leftside(arr);
        int right[] = rightside(arr);
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int area = arr[i] * (right[i] - left[i] - 1);
            ans = Math.max(ans, area);
        }
        return ans;
    }

    private static int[] leftside(int[] arr) {
        int ans[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }

    private static int[] rightside(int[] arr) {
        int ans[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
