
public class Main {

    public static void main(String[] args) {
        int[] arr = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Priority_queue queue = new Priority_queue(arr);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
