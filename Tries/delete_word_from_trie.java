
import java.util.LinkedList;
import java.util.Queue;

public class delete_word_from_trie {

    public static void main(String[] args) {
        String[] words = {"abc", "abcd" ,"akc"};
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(word, 0, root);
        }
        print(root);
        System.out.println(isPresent("abc", 0, root));
        delete(root, "abc", 0);
        System.out.println(isPresent("abc", 0, root));
        print(root);
    }

    private static class TrieNode {

        TrieNode[] tries;
        boolean isEnd;
        int freq;

        public TrieNode() {
            this.tries = new TrieNode[26];
            this.isEnd = false;
            this.freq = 0;
        }

    }

    private static void print(TrieNode root) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TrieNode node = queue.poll();
                for (int j = 0; j < 26; j++) {
                    if (node.tries[j] != null) {
                        System.out.print((char) (j + 'a') + " ");
                        queue.add(node.tries[j]);
                    }
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    private static boolean delete(TrieNode root, String word, int index) {
        if (index >= word.length()) {
            root.isEnd = false;
            return !root.isEnd && root.freq == 0;
        }
        char ch = word.charAt(index);
        TrieNode child = root.tries[ch - 'a'];
        if (child == null) {
            return false;
        }
        child.freq--;
        boolean shouldDeleteChild = delete(child, word, index + 1);
        if (shouldDeleteChild && child.freq == 0 && NoMapping(child.tries)) {
            root.tries[ch - 'a'] = null;
        }
        return !root.isEnd && root.freq == 0 && NoMapping(root.tries);
    }

    private static boolean NoMapping(TrieNode[] root) {
        for (TrieNode node : root) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPresent(String word, int index, TrieNode root) {
        if (index >= word.length()) {
            return root.isEnd;
        }
        if (root.tries[word.charAt(index) - 'a'] == null) {
            return false;
        }
        return isPresent(word, index + 1, root.tries[word.charAt(index) - 'a']);
    }

    private static void insert(String word, int index, TrieNode root) {
        if (index >= word.length()) {
            root.isEnd = true;
            return;
        }
        if (root.tries[word.charAt(index) - 'a'] == null) {
            root.tries[word.charAt(index) - 'a'] = new TrieNode();
        }
        root.tries[word.charAt(index) - 'a'].freq++;
        insert(word, index + 1, root.tries[word.charAt(index) - 'a']);
    }
}
