import java.util.*;

public class rangesum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int prefix[] = new int[n];
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            if (end + 1 < n) {
                prefix[end + 1] -= value;
            }
            prefix[start] += value;
        }
        System.out.print(prefix[0] + " ");
        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i - 1];
            System.out.print(prefix[i] + " ");
        }
    }
}
