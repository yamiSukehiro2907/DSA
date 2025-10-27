package subarray;

import java.util.*;

public class range_sum_odd_even_subarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int prefix[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (arr[i - 1] % 2 == 0) {
                prefix[i] = prefix[i - 1] + 1; // ek aur even mil gaya 
            } else {
                prefix[i] = prefix[i - 1]; // yahan tak bhai itne hee even they 
            }
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(prefix[end] - prefix[start]);
        }
        sc.close();
    }
}
