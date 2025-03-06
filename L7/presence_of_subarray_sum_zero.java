import java.util.*;

public class presence_of_subarray_sum_zero {
    public static void main(String[] args) {
        int arr[] = { 7, -3, -2, 1, -3, 4, 5, 10, -7 };
        int k = 0;
        System.out.println(solve(arr, k));
    }

    private static int solve(int arr[], int k) {
        int prefix[] = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= arr.length; i++) {
            int cur = 0;
            if(map.containsKey(prefix[i] + k)){
                
            }
        }
        return ans - 1;
    }
}
