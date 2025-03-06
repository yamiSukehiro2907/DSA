package L12;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 1 };
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num : arr)
            list.add(num);
        Collections.sort(list, (a, b) -> {
            if (a < b)
                return -1;
            return 1;
        });
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
            for (int num : arr)
                System.out.print(num + " ");
            System.out.println();
        }
    }

    private static void merge(int arr[], int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int L[] = new int[n1];
        for (int i = start; i <= mid; i++)
            L[i - start] = arr[i];
        int R[] = new int[n2];
        for (int i = mid + 1; i <= end; i++)
            R[i - mid - 1] = arr[i];
        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (L[i] < R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }
}
