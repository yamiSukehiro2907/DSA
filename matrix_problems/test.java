package matrix_problems;

import java.util.*;

public class test {
    private static class Solution {
        public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
            List<Integer>[] connected = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                connected[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                int n1 = edge[0];
                int n2 = edge[1];
                connected[n1].add(n2);
                connected[n2].add(n1);
            }
            int[] ans = new int[1];
            dfs(0, -1, connected, values, k, ans);
            return ans[0];
        }

        private int dfs(int cur, int parentNode, List<Integer>[] connected, int[] values, int k, int[] ans) {
            int sum = 0;
            for (int point : connected[cur]) {
                if (point != parentNode) {
                    sum += dfs(point, cur, connected, values, k, ans);
                    sum %= k;
                }
            }
            sum += values[cur];
            sum %= k;
            if (sum == 0) {
                ans[0]++;
            }
            return sum;
        }
    }

    public static void main(String[] args) {

    }
}
