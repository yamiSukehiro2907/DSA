
import java.util.*;

public class k_smallest_elements {

    public static void main(String[] args) {
        int[] arr = {6, 5, 2, 1, 3, 4, 7};
        System.out.println(Arrays.toString(smallest_elements(arr, 5)));
    }

    private static int[] smallest_elements(int[] arr, int k) {
        int[] temp = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            if (queue.isEmpty() || queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() > num) {
                queue.poll();
                queue.add(num);
            }
        }
        for (int i = 0; i < k; i++) {
            temp[i] = queue.poll();
        }
        return temp;
        /// optimize this further custom pq impl
    }
}
