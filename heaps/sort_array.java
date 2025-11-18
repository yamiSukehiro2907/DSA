
import java.util.Arrays;

public class sort_array {

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 2, 7, 1};
        PriorityQueue queue = new PriorityQueue(arr);
        System.out.println(Arrays.toString(queue.getArray()));
    }

    private static final class PriorityQueue {

        private final int[] arr;
        private int index;

        public PriorityQueue(int[] arr) {
            this.arr = arr;
            this.index = arr.length;
            for (int i = arr.length / 2 - 1; i >= 0; i--) {
                heapifyDown(i);
            }
            while (!this.isEmpty()) {
                this.poll();
            }
        }

        private void heapifyDown(int parentIndex) {
            int leftChildIndex = 2 * parentIndex + 1, rightChildIndex = 2 * parentIndex + 2;
            int parentElement = arr[parentIndex];
            if (leftChildIndex < index && rightChildIndex < index) {
                int leftChild = arr[leftChildIndex], rightChild = arr[rightChildIndex];
                if (parentElement < leftChild && parentElement < rightChild) {
                    if (leftChild > rightChild) {
                        swap(leftChildIndex, parentIndex);
                        heapifyDown(leftChildIndex);
                    } else {
                        swap(rightChildIndex, parentIndex);
                        heapifyDown(rightChildIndex);
                    }
                } else if (parentElement < leftChild) {
                    swap(leftChildIndex, parentIndex);
                    heapifyDown(leftChildIndex);
                } else if (parentElement < rightChild) {
                    swap(rightChildIndex, parentIndex);
                    heapifyDown(rightChildIndex);
                }
            } else if (leftChildIndex < index) {
                int leftChild = arr[leftChildIndex];
                if (parentElement < leftChild) {
                    swap(leftChildIndex, parentIndex);
                    heapifyDown(leftChildIndex);
                }
            }
        }

        public int poll() {
            if (this.isEmpty()) {
                throw new RuntimeException("Queue is Empty!");
            }
            int element = arr[0];
            --index;
            if (index > 0) {
                swap(index, 0);
                heapifyDown(0);
            }
            return element;
        }

        private boolean isEmpty() {
            return index == 0;
        }

        private void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        private int[] getArray() {
            return arr;
        }
    }
}
