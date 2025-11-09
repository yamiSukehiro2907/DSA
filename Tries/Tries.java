
public class Tries {

    public static void main(String[] args) {
        String[] arr = {"RANDOM", "RANK", "FIRST", "FIRE", "FIRED" , "RAN"};
        TrieNode root = new TrieNode();
        for (String word : arr) {
            fill(word, 0, root);
        }
        System.out.println(isPresent(root, "RANK", 0));
        delete(root, "RANK");
        System.out.println(isPresent(root, "RANK", 0));
        System.out.println(isPresent(root, "RAN", 0));
    }

    private static void fill(String word, int index, TrieNode root) {
        if (index >= word.length()) {
            root.isEnd = true;
            return;
        }
        if (!root.map.containsKey(word.charAt(index))) {
            root.map.put(word.charAt(index), new TrieNode());
        }
        fill(word, index + 1, root.map.get(word.charAt(index)));
    }

    private static boolean isPresent(TrieNode root, String word, int index) {
        if (index >= word.length()) {
            return root.isEnd;
        }
        if (!root.map.containsKey(word.charAt(index))) {
            return false;
        }
        return isPresent(root.map.get(word.charAt(index)), word, index + 1);
    }

    public static void delete(TrieNode root, String word) {
        int index = 0;
        while (index < word.length() - 1) {
            root = root.map.get(word.charAt(index++));
        }
        root.map.get(word.charAt(index)).isEnd = false;
    }
}
