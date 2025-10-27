package recursion.L13;

public class quick_sort {
    public static void main(String[] args) {
        int arr[] = { 38, 27, 43, 3, 9, 82, 10, 55, 23, 7, 6, 11, 99, 2 };
        sort(arr, 0, arr.length - 1);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    private static void sort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int p = partition(arr, start, end);
        sort(arr, start, p);
        sort(arr, p + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int mid = start + ((end - start) / 2);
        int pivot = arr[mid];
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start - 1;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
