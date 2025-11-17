
public class find_max_xor_subarray {

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 12, 7, 6};
        TrieNode root = new TrieNode();
        for (int i = 0; i < nums.length; i++) {
            insert(root, nums[i], i, 31);
        }
    }

    private static int findBit(int num, int position) {
        return ((num >> position) & 1);
    }

    private static class TrieNode {

        TrieNode[] tries;
        int index;

        public TrieNode() {
            this.tries = new TrieNode[2];
            this.index = -1;
        }
    }

    private static void insert(TrieNode root, int num, int index, int position) {
        if (position < 0) {
            root.index = index;
            return;
        }
        int bit = findBit(num, position);
        if (root.tries[bit] == null) {
            root.tries[bit] = new TrieNode();
        }
        insert(root.tries[bit], num, index, position - 1);
    }
}
