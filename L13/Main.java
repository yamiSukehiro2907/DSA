package L13;

public class Main {
    public static void main(String[] args) {
        int arr[] = { 4, 1, 2, 4, 3 };
        sort(arr, 0, arr.length - 1);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    private static void sort(int arr[], int start, int end) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
        if (start < end) {
            int mid = start + ((end - start) / 2);
            int pivot = arr[mid];
            int low = start;
            int high = end;
            while (start <= end) {
                while (arr[start] < pivot)
                    start++;
                while (arr[end] > pivot)
                    end--;
                if (start <= end) {
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }
            }
            sort(arr, start, high);
            sort(arr, low, end);
        }
    }
}
