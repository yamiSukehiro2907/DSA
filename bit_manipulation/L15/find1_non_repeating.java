package bit_manipulation.L15;

public class find1_non_repeating {
    public static void main(String[] args) {
        int arr[] = { 10, 3, 10, 5, 8, 3, 10, 8, 8, 3 };
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : arr) {
                if (checkbit(num, i) == 1) count++;
            }
            if (count % 3 == 1) ans += Math.pow(2, i);
        }
        System.out.println(ans);
    }

    private static int checkbit(int n, int i) {
        int k = (1 << i);
        if ((n & k) == 0) return 0;
        return 1;
    }
}
