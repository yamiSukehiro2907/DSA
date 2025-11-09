
import java.util.Arrays;

public class GFG {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSquares(43));
    }

    private static class Solution {

        private static int[] dp;

        static {
            dp = new int[10001];
            for (int i = 1; i < 101; i++) dp[i * i] = 1;
            int lastSquare = 1;
            for (int i = 1; i < 10001; i++) {
                if (dp[i] == 1) lastSquare = i;
                else dp[i] = dp[i - lastSquare] + 1;
            }
            System.out.println(Arrays.toString(dp));
        }

        public int minSquares(int n) {
            return dp[n];
        }
    }
}
