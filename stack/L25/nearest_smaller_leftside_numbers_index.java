package stack.L25;
import java.util.*;

public class nearest_smaller_leftside_numbers_index {
    public static void main(String[] args) {
        int arr[] = { 4, 6, 10, 11, 7, 8, 5 };
        int ans[] = solve(arr);
        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : ans) {
            if (num != -1)
                System.out.print(arr[num] + " ");
            else System.out.print(-1 + " ");
        }

    }

    private static int[] solve(int[] arr) {
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
}
