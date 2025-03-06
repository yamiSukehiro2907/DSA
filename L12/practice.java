package L12;

public class practice {
    public static void main(String[] args) {
        int[] arr = { 6, 8, 9 };
        int[] ans = solve(arr);
        for (int num : ans)
            System.out.print(num + " ");
        System.out.println();
    }

    private static int[] solve(int[] A) {
        sort(A, 0, A.length - 1);
        return A;
    }

    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
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
            int f1 = factor(L[i]);
            int f2 = factor(R[j]);
            System.out.println(f1 + " " + L[i]);
            System.out.println(f2 + " " + R[j]);
            if (f1 < f2 || (f1 == f2 && L[i] < R[j]))
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    private static int factor(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i)
                    count++;
            }
        }
        return count;
    }
}
