
public class maximumXOR {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        TrieNode root = new TrieNode();
        int max = 0;
        for (int num : nums) {
            fill(num, root, 31);
            max = findMax(root, 31, num);
        }
        System.out.println(max);
    }

    private static int findMax(TrieNode root, int position, int num) {
        if (position < 0) {
            return 0;
        }
        int bit = ((num >> position) & 1) == 0 ? 0 : 1;
        int oppositeBit = 1 - bit;
        if (root.tries[oppositeBit] != null) {
            return (1 << position) | findMax(root.tries[oppositeBit], position - 1, num);
        }
        return findMax(root.tries[bit], position - 1, num);
    }

    private static void fill(int num, TrieNode root, int position) {
        if (position < 0) {
            return;
        }
        int bit = ((num >> position) & 1) == 0 ? 0 : 1;
        if (root.tries[bit] == null) {
            root.tries[bit] = new TrieNode();
        }
        fill(num, root.tries[bit], position - 1);
    }

    private static class TrieNode {

        TrieNode[] tries;

        public TrieNode() {
            this.tries = new TrieNode[2];
        }
    }
}
