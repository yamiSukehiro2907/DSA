
public class number_of_unique_rows {

    private static int uniqueCount = 0;

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        int[][] matrix = {{0, 1, 0}, {1, 0, 1}, {0, 1, 1}};
        for (int[] temp : matrix) {
            fill(temp, 0, root);
        }
        System.out.println(uniqueCount);
    }

    private static class TrieNode {

        TrieNode[] tries;
        boolean isEnd;
        boolean duplicate;

        public TrieNode() {
            this.tries = new TrieNode[2];
            this.isEnd = false;
            this.duplicate = false;
        }
    }

    private static void fill(int[] arr, int index, TrieNode root) {
        if (index >= arr.length) {
            if (root.isEnd) {
                if (!root.duplicate) { // visiting second time
                    uniqueCount--;
                    root.duplicate = true;
                } // if visiting third time no change
            } else {
                root.isEnd = true;
                uniqueCount++; // visiting first time
            }
            return;
        }
        if (root.tries[arr[index]] == null) {
            root.tries[arr[index]] = new TrieNode();
        }
        fill(arr, index + 1, root.tries[arr[index]]);
    }

}
