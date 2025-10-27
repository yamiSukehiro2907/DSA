package L22.LRU.Optimized;

public class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        private Node() {
        }

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] map;
    private Node MRU, LRU;
    private int capacity, size;

    public LRUCache(int capacity) {
        map = new Node[10000 + 1];
        MRU = new Node();
        LRU = new Node();
        MRU.next = LRU;
        LRU.prev = MRU;
        this.capacity = capacity;
        size = 0;
    }

    public void insert(Node target) {
        target.next = MRU.next;
        target.prev = MRU;
        MRU.next.prev = target;
        MRU.next = target;
    }

    public void delete(Node target) {
        target.prev.next = target.next;
        target.next.prev = target.prev;
    }

    public int get(int key) {
        if (map[key] != null) {
            Node target = map[key];
            delete(target);
            insert(target);
            return target.value;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map[key] == null) {
            if (size == capacity) {
                Node target = LRU.prev;
                delete(target);
                map[target.key] = null;
                target.key = key;
                target.value = value;
                insert(target);
                map[key] = target;
            } else {
                Node newNode = new Node(key, value);
                insert(newNode);
                map[key] = newNode;
                size++;
            }
        } else {
            Node target = map[key];
            target.value = value;
            delete(target);
            insert(target);
        }
    }
}
