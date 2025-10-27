package stack.L25;
import java.util.*;

public class nearest_left_smaller_element {
    public static void main(String[] args) {
        int arr[] = { 4, 6, 10, 11, 7, 8, 5 };
        int ans[] = solve(arr);
        for (int num : ans)
            System.out.print(num + " ");
    }

    private static int[] solve(int[] arr) {
        // for any smaller element we get , the leftside elements of that number can
        // never be answer for the future elements
        int ans[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int call = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
                call++;
            }
            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();
            stack.push(arr[i]);
            call++;
        }
        System.out.println(call);
        return ans;
    }
}