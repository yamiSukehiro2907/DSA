public class RainWaterTrapping2 {

}

class Solution {
    public int trapRainWater(int[][] h) {
        int m = h.length;
        int n = h[0].length;
        if (m <= 2 || n <= 2)
            return 0;
        int ans = 0;
        int level[][] = new int[m][n];
        // filling level matrix except last and first row
        for (int i = 1; i < m - 1; i++) {
            // filling the level matrix first col element with their initial heights
            level[i][0] = h[i][0];
            for (int j = 1; j < n - 1; j++) {
                level[i][j] = 20_000; // assigned them the max amount of water they can take
            }
            // filling the level matrix last col element with their initial heights
            level[i][n - 1] = h[i][n - 1];
        }
        // filling first and last row of level matrix
        for (int i = 0; i < n; i++) {
            level[0][i] = h[0][i];
            level[m - 1][i] = h[m - 1][i];
        }
        boolean drain = true;
        while (drain) {
            drain = false;
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < m - 1; j++) {
                    if (level[j][i] > level[j][i - 1]) {
                        // here we are assigning level of water on the basis of their upper building
                        level[j][i] = Integer.max(level[j][i - 1], h[j][i]);
                    }
                    if (level[j][i] > level[j - 1][i]) {
                        // here we are assigning the level of water on the basis of their left building
                        level[j][i] = Integer.max(level[j - 1][i], h[j][i]);
                    }
                }
            }
            for (int i = n - 2; i > 0; i--) {
                for (int j = m - 2; j > 0; j--) {
                    if (level[j][i] > level[j][i + 1]) {
                        // here we are assigning the level of water on the basis of their below building
                        level[j][i] = Integer.max(level[j][i + 1], h[j][i]);
                    }
                    // here we are assigning the level of water on the basis of their right building
                    if (level[j][i] > level[j + 1][i]) {
                        level[j][i] = Integer.max(level[j + 1][i], h[j][i]);
                    }
                    // reducing the excess water until possible
                    if (level[j][i] < level[j][i + 1] && level[j][i + 1] > h[j][i + 1]
                            || level[j][i] < level[j + 1][i] && level[j + 1][i] > h[j + 1][i]) {
                        drain = true;
                    }
                }
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                ans += level[i][j] - h[i][j];
            }
        }
        return ans;
    }
}