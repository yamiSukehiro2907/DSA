
import java.util.Arrays;

public class Shortest_unique_prefix {

    public static void main(String[] args) {
        String[] words = {"cat", "dog", "rat", "tiger", "racoon"};
        TrieNode root = new TrieNode();
        for (String word : words) {
            fill(word, root, 0);
        }
        String[] ans = new String[words.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = find_shortest_prefix(words[i], root, 0, new StringBuilder());
        }
        System.out.println(Arrays.toString(ans));
    }

    private static class TrieNode {

        TrieNode[] tries;
        int freq;

        public TrieNode() {
            this.tries = new TrieNode[26];
            this.freq = 0;
        }
    }

    private static String find_shortest_prefix(String word, TrieNode root, int index, StringBuilder sb) {
        if (index >= word.length()) {
            return sb.toString();
        }
        if (root.tries[word.charAt(index) - 'a'].freq > 1) {
            return sb.toString();
        }
        sb.append(word.charAt(index));
        return find_shortest_prefix(word, root.tries[word.charAt(index) - 'a'], index + 1, sb);
    }

    private static void fill(String word, TrieNode root, int index) {
        if (index >= word.length()) {
            return;
        }
        if (root.tries[word.charAt(index) - 'a'] == null) {
            root.tries[word.charAt(index) - 'a'] = new TrieNode();
        }
        root.tries[word.charAt(index) - 'a'].freq++;
        fill(word, root.tries[word.charAt(index) - 'a'], index + 1);
    }

}
