package bit_manipulation.L16;

public class sum_of_hamming_distance_of_all_pairs {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 1 };
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count1 = 0;
            for (int num : arr) {
                if (checkbit(num, i) == 1)
                    count1++;
            }
            ans += (arr.length - count1) * count1;
        }
        System.out.println(ans);
    }

    private static int checkbit(int n, int i) {
        int k = (1 << i);
        if ((n & k) == 0)
            return 0;
        return 1;
    }
}
