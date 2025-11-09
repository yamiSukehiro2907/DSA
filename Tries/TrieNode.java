
import java.util.*;

public class TrieNode {

    public Map<Character, TrieNode> map;
    public boolean isEnd;

    public TrieNode() {
        this.map = new HashMap<>();
        this.isEnd = false;
    }
}
