import java.util.Arrays;

public class merge_sort_algo {
    public static void main(String[] args) {
        int arr[] = { 1, 5, 4, 3, 2, 8, 7, 9 };
        sort(0, arr.length - 1, arr);
    }

    private static void sort(int start, int end, int[] arr) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            sort(start, mid, arr);
            sort(mid + 1, end, arr);
            merge(start, mid, end, arr);
        }
        return;
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

    private static void merge(int start, int mid, int end, int arr[]) {
       
    }
}
