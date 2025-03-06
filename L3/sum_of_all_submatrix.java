import java.util.*;

public class sum_of_all_submatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(solve(matrix));
    }

    static long solve(int[][] matrix) {
        int MOD = 1_000_000_007;
        int m = matrix.length;
        int n = matrix[0].length;
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += (matrix[i][j] * (i + 1) * (j + 1) * (m - i) * (n - j) + MOD) % MOD;
            }
        }

        return (int) ans;
    }
}
