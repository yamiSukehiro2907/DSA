import java.util.Arrays;

public class merge_sorted_array {
    public static void main(String[] args) {
        int arr1[] = { 1, 3, 4, 6, 8, 9 };
        int arr2[] = { 2, 3, 5, 7 };
        int ans[] = solve(arr1, arr2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] solve(int[] arr1, int arr2[]) {
        int ans[] = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                ans[k++] = arr1[i++];
            else
                ans[k++] = arr2[j++];
        }
        while (i < arr1.length)
            ans[k++] = arr1[i++];
        while (j < arr2.length)
            ans[k++] = arr2[j++];
        return ans;
    }
}
