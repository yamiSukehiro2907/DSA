
import java.util.Arrays;
import java.util.PriorityQueue;

public class k_distance_sorted {

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        sort(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            queue.add(arr[i]);
        }
        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[index++] = queue.poll();
            queue.add(arr[i]);
        }
        while (index < arr.length) {
            arr[index++] = queue.poll();
        }
    }
}
