import java.util.*;

public class DeletingIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {4, 3, 2, 7, 6, -2};
        System.out.println(solve(arr));
    }

    static int solve(int[] arr) {
        int n = arr.length;
        int[] odd = new int[n + 1];
        int[] even = new int[n + 1];
        int o = 0;
        int e = 0;

        // Build prefix sums for odd and even indices
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) { // even index (1-based)
                e += arr[i - 1];
            } else { // odd index (1-based)
                o += arr[i - 1];
            }
            odd[i] = o;
            even[i] = e;
        }

        int count = 0;

        // Iterate to calculate the sums after deleting each index
        for (int i = 0; i < n; i++) {
            // Remove the current index
            int evensum = even[i] + odd[n] - odd[i + 1];
            int oddsum = odd[i] + even[n] - even[i + 1];

            if (evensum == oddsum) {
                count++;
            }
        }

        return count;
    }
}
