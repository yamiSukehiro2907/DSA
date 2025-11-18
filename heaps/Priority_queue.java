
import java.util.Arrays;

public class Priority_queue {

    private static final int INITIAL_CAPACITY = 2;
    private int arr[];
    private int index;

    public Priority_queue() {
        this.arr = new int[INITIAL_CAPACITY];
        this.index = 0;
    }

    public Priority_queue(int[] temp) {
        this.arr = new int[temp.length * 2];
        System.arraycopy(temp, 0, this.arr, 0, temp.length);
        this.index = temp.length;
        for (int i = (temp.length - 1) / 2; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    public Priority_queue(int capacity) {
        this.arr = new int[capacity];
        this.index = 0;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int poll() {
        if (index == 0) {
            throw new NullPointerException("Queue is Empty!");
        }
        int element = arr[0];
        index--;
        if (index > 0) {
            swap(0, index);
            heapifyDown(0);
        }
        return element;
    }

    public void offer(int num) {
        add(num);
    }

    public void add(int num) {
        arr[index] = num;
        heapifyUp(index);
        index++;
        if (index == arr.length) {
            expand();
        }
        System.out.println(Arrays.toString(arr));
    }

    private void heapifyUp(int childIndex) {
        int parent = (childIndex - 1) / 2;
        if (parent >= 0 && arr[childIndex] < arr[parent]) {
            swap(childIndex, parent);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int parent) {
        int leftChildIndex = 2 * parent + 1, rightChildIndex = 2 * parent + 2;
        int parentElement = arr[parent];
        if (leftChildIndex < index && rightChildIndex < index) {
            int leftChild = arr[leftChildIndex];
            int rightChild = arr[rightChildIndex];
            if (parentElement > leftChild && parentElement > rightChild) {
                if (leftChild < rightChild) {
                    swap(leftChildIndex, parent);
                    heapifyDown(leftChildIndex);
                } else {
                    swap(rightChildIndex, parent);
                    heapifyDown(rightChildIndex);
                }
            } else if (parentElement > leftChild) {
                swap(leftChildIndex, parent);
                heapifyDown(leftChildIndex);
            } else if (parentElement > rightChild) {
                swap(rightChildIndex, parent);
                heapifyDown(rightChildIndex);
            }
        } else if (leftChildIndex < index) {
            int leftChild = arr[leftChildIndex];
            if (parentElement > leftChild) {
                swap(parent, leftChildIndex);
                heapifyDown(leftChildIndex);
            }
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void expand() {
        int[] temp = new int[arr.length * 2];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        this.arr = temp;
    }

}
