
import java.util.Arrays;

public class GFG_17 {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 7, 9, 8, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.maxSumIS(arr));
    }

    private static class Solution {

        public int maxSumIS(int arr[]) {
            int n = arr.length;
            int[][] nums = new int[n][2];
            for (int i = 0; i < arr.length; i++) {
                nums[i][0] = arr[i];
                nums[i][1] = i;
            }
            Arrays.sort(nums, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });
            boolean[] visited = new boolean[n];
            int maxSum = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (!visited[i]) {
                    visited[i] = true;
                    int sum = nums[i][0], j = i - 1, last = i;
                    while (j >= 0) {
                        if (nums[j][1] < nums[last][1] && nums[j][0] < nums[last][0]) {
                            sum += nums[j][0];
                            visited[j] = true;
                            last = j;
                        }
                        j--;
                    }
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
            return maxSum;
        }
    }
}
