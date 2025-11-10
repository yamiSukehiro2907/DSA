
import java.util.Arrays;

public class word_can_be_formed_by_exactly_one_modification {

    public static void main(String[] args) {
        String[] words = {"abc", "akc", "abcd"};
        String[] queries = {"amc" , "ak"};
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word);
        }
        boolean[] canBeFormed = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            canBeFormed[i] = root.isPossibleToForm(queries[i]);
        }
        System.out.println(Arrays.toString(canBeFormed));
    }

    private static class TrieNode {

        private final TrieNode[] tries;
        private boolean isEnd;

        public TrieNode() {
            this.tries = new TrieNode[26];
            this.isEnd = false;
        }

        public void insert(String word) {
            insert2(this, word, 0);
        }

        private void insert2(TrieNode root, String word, int index) {
            if (index >= word.length()) {
                root.isEnd = true;
                return;
            }
            if (root.tries[word.charAt(index) - 'a'] == null) {
                root.tries[word.charAt(index) - 'a'] = new TrieNode();
            }
            insert2(root.tries[word.charAt(index) - 'a'], word, index + 1);
        }

        public boolean isPossibleToForm(String word) {
            return canBeFormed(word, 0, this, false);
        }

        private boolean canBeFormed(String word, int index, TrieNode root, boolean modified) {
            if (index >= word.length()) {
                return modified && root.isEnd;
            }
            if (root.tries[word.charAt(index) - 'a'] == null) {
                if (modified) {
                    return false;
                }
                for (TrieNode node : root.tries) {
                    if (node == null) {
                        continue;
                    }
                    if (canBeFormed(word, index + 1, node, true)) {
                        return true;
                    }
                }
                return false;
            } else {
                return canBeFormed(word, index + 1, root.tries[word.charAt(index) - 'a'], modified);
            }
        }
    }
}
