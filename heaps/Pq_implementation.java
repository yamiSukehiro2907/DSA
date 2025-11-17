
import java.util.*;

public class Pq_implementation {

    public static void main(String[] args) throws Exception {
        Priority_queue queue = new Priority_queue();
        int[] nums = {2, 1, 4, 10, 3};
        for (int num : nums) {
            queue.add(num);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    private static class Priority_queue {

        private final ArrayList<Integer> list;

        public Priority_queue() {
            this.list = new ArrayList<>();
        }

        public void add(int num) {
            list.add(num);
            fixUp(list.size() - 1);
        }

        private void fixUp(int index) {
            int parentIndex = (index - 1) / 2;
            if (list.get(parentIndex) > list.get(index)) {
                int temp = list.get(parentIndex);
                list.set(parentIndex, list.get(index));
                list.set(index, temp);
                fixUp(parentIndex);
            }
        }

        public int poll() throws Exception {
            if (this.isEmpty()) {
                throw new Exception("Queue is Empty!");
            }
            if (list.size() == 1) {
                return list.remove(0);
            }
            int element = list.get(0);
            int lastElement = list.get(list.size() - 1);
            list.set(0, lastElement);
            list.remove(list.size() - 1);
            fixDown(0);
            return element;
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        private void fixDown(int index) {
            int leftChildIndex = 2 * index + 1, rightChildIndex = 2 * index + 2;
            int parent = list.get(index);
            if (leftChildIndex < list.size() && parent > list.get(leftChildIndex)) {
                int temp = parent;
                list.set(index, list.get(leftChildIndex));
                list.set(leftChildIndex, temp);
                fixDown(leftChildIndex);
            } else if (rightChildIndex < list.size() && parent > list.get(rightChildIndex)) {
                int temp = parent;
                list.set(index, list.get(rightChildIndex));
                list.set(rightChildIndex, temp);
                fixDown(rightChildIndex);
            }
        }

    }
}
