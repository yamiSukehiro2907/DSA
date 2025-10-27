package array.rain_trap;

public class brute_rain_trap {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int[] water = new int[arr.length - 1];
        System.out.println(solvefront(water, arr) + solvereverse(arr));
    }

    static int solvefront(int water[], int[] arr) {
        int ans = 0;
        int index = 0;
        int b1 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= b1) {
                if (i - index > 1) {
                    int value = Math.min(arr[index], arr[i]);
                    for (int j = index; j <= i; j++) {
                        if (value - arr[j] > 0) {
                            ans += value - arr[j];
                        }
                    }
                }
                b1 = arr[i];
                index = i;
            }
        }
        return ans;
    }

    static int solvereverse(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int index = n - 1;
        int b1 = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= b1) {
                if (index - i > 1) {
                    int value = Math.min(arr[index], arr[i]);
                    for (int j = i; j <= index; j++) {
                        if (value - arr[j] > 0) {
                            ans += value - arr[j];
                        }
                    }
                }
                b1 = arr[i];
                index = i;
            }
        }
        return ans;
    }
}
