package bit_manipulation.L16;

import java.util.Arrays;

public class minimizeXOR {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 5, 2 };
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            ans = Math.min(ans, arr[i] ^ arr[i - 1]);
        }
        System.out.println(ans);
    }
}
