package matrix_problems;
import java.util.*;

public class matrix_range_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int prefix[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            prefix[i][0] = arr[i][0];
            for (int j = 1; j < n; j++) {
                prefix[i][j] = prefix[i][j - 1] + arr[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(prefix[i][j] + " ");
            }
        }
        int q = sc.nextInt();
        int ans[] = new int[q];
        for (int i = 0; i < q; i++) {
            int startrow = sc.nextInt();
            int startcol = sc.nextInt();
            int endrow = sc.nextInt();
            int endcol = sc.nextInt();
            int sum = 0;
            // q*(no.of rows)
            for (int j = startrow; j <= endrow; j++) {
                sum += prefix[j][endcol];
                if (startcol > 0)
                    sum -= prefix[j][startcol - 1];
            }
            ans[i] = sum;
        }
        System.out.println(Arrays.toString(ans));
    }
}
