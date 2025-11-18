
import java.util.*;

public class median_of_stream {

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 2, 6, 1, 9, 10};
        Helper helper = new Helper();
        for (int num : arr) {
            System.out.println(helper.add(num));
        }
    }

    private static class Helper {

        private final PriorityQueue<Integer> left;
        private final PriorityQueue<Integer> right;

        public Helper() {
            this.left = new PriorityQueue<>((a, b) -> b - a);
            this.right = new PriorityQueue<>();
        }

        public double add(int num) {
            if (left.isEmpty() || num < left.peek()) {
                left.add(num);
            } else {
                right.add(num);
            }
            fix();
            int totalElement = left.size() + right.size();
            if (totalElement % 2 == 0) {
                return (double) (left.peek() + right.peek()) / (double) 2;
            } else {
                if (left.size() > right.size()) {
                    return left.peek();
                } else {
                    return right.peek();
                }
            }
        }

        private void fix() {
            if (left.size() - right.size() > 1) {
                right.add(left.poll());
            }
            if (right.size() - left.size() > 1) {
                left.add(right.poll());
            }
        }
    }
}
