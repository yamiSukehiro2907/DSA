package L1;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int arr[] = { 25, 64, 9, 4, 100 };
        int k = 4;
        System.out.println(pickGifts(arr, k));
    }

    static long pickGifts(int[] gifts, int k) {
        Arrays.sort(gifts);
        int j = 1;
        int n = gifts.length;
        while (j <= k) {
            int num = gifts[n - 1];
            int r = (int) Math.sqrt(num);
            place(gifts, r);
            j++;
        }
        long sum = 0;
        for (int i = 0; i < gifts.length; i++) {
            sum += gifts[i];
        }
        return sum;
    }

    static void place(int[] nums, int num) {
        int n = nums.length;
        int index = n - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= num && num <= nums[i + 1]) {
                index = i + 1;
            }
        }
        int temp = nums[index];
        nums[index] = num;
        while (index < n - 1) {
            index++;
            int t = nums[index];
            nums[index] = temp;
            temp = t;
        }
    }
}
