import java.util.*;

public class subarray_with_sum_divisible_by_k {
    public static void main(String[] args) {
        int arr[] = {};
        int k = 1;
        System.out.println(solve(arr, k));
    }

    private static int solve(int[] arr, int k) {
        int prefix[] = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
            prefix[i] = prefix[i] % k;
        }
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= arr.length; i++) {
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
            ans = Math.max(ans, map.get(prefix[i]));
        }
        return ans - 1;
    }
}
