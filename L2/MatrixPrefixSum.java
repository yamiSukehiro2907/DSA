public class MatrixPrefixSum {
    // Function to compute the prefix sum matrix
    public static int[][] computePrefixSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] prefixSum = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefixSum[i][j] = matrix[i][j];
                if (i > 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }
                if (j > 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];
                }
            }
        }
        return prefixSum;
    }

    // Function to query the sum of a submatrix
    public static int querySubmatrixSum(int[][] prefixSum, int r1, int c1, int r2, int c2) {
        int total = prefixSum[r2][c2];
        if (r1 > 0) {
            total -= prefixSum[r1 - 1][c2];
        }
        if (c1 > 0) {
            total -= prefixSum[r2][c1 - 1];
        }
        if (r1 > 0 && c1 > 0) {
            total += prefixSum[r1 - 1][c1 - 1];
        }
        return total;
    }

    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // Compute prefix sum matrix
        int[][] prefixSum = computePrefixSum(matrix);
        int ans = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum[0].length; j++) {
                ans+= prefixSum[i][j];
                System.out.print(prefixSum[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(ans);

        // Query the sum of a submatrix (1, 1) to (2, 2)
        int result = querySubmatrixSum(prefixSum, 0, 0, 2, 2);

        // Output the result
        System.out.println("Sum of submatrix: " + result); // Output: 28
    }
}
