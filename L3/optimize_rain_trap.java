import java.util.*;

public class optimize_rain_trap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(solve(arr));
    }

    static int solve(int[] arr) {
        int ans = 0;
        int left = 0;
        int n = arr.length;
        int right = n - 1;
        int leftmax = 0;
        int rightmax = 0;
        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > leftmax)
                    leftmax = arr[left];
                else
                    ans += leftmax - arr[left];
                left++;
            } else {
                if (arr[right] > rightmax)
                    rightmax = arr[right];
                else
                    ans += rightmax - arr[right];
                right--;
            }
        }
        return ans;
    }
}
