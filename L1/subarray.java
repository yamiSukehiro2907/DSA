package L1;
import java.util.*;

public class subarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int j = sc.nextInt();
        // int i = 1;
        // int count = 0;
        // while (j - i >= 0 && j + i <= n) {
        // count += i;
        // i++;
        // }
        // System.out.println(count);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = 0;
        int start = 0;
        while (start < n) {
            int end = start;
            while (end < n) {
                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                    k += arr[i];
                }
                System.out.println();
                end++;
            }
            start++;
        }
        System.out.println(k);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] * (n - i) * (i + 1);
        }
        System.out.println(sum);

        int l = 0;
        for (int i = 0; i < n; i++) {
            int g = 0;
            for (int j = i; j < n; j++) {
                g += arr[j];
                System.out.println(g);
            }
            l += g;
        }
        System.out.println(l);
    }
}
