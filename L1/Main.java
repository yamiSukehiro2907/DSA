package L1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println((n - i) * (i + 1));
            sum += arr[i] * (n - i) * (i + 1);
        }
        System.out.println(sum);
        System.out.println("Mohit's Approach: ");
        int y = 0;
        int a = n;
        for (int i = 0; i < n / 2; i++) {
            System.out.println(a);
            y += arr[i] * a;
            System.out.println(y);
            y += arr[n - 1 - i] * a;
            System.out.println(y);
            a += n - 2 * (i + 1);
        }
        System.out.println(y);
        int l = 0;
        for (int i = 0; i < n; i++) {
            int g = 0;
            int k = 0;
            System.out.println("Subarrays starting with " + arr[i]);
            for (int j = i; j < n; j++) {
                g += arr[j];
                k += g;
                System.out.print(g + " ");
            }
            System.out.println();
            l += k;
        }
        System.out.println("Total sum: " + l);
    }
}