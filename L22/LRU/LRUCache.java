package L22.LRU;

import java.util.*;

class Node {
    Node next;
    int key;
    int val;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}

public class LRUCache {
    private Node LRU;
    private Node MRU;
    private int size;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.MRU = null;
        this.LRU = null;
        this.map = new HashMap<>();
        this.size = 0;
    }

    public int get(int key) {
        if (size == 0 || !map.containsKey(key))
            return -1;
        if (MRU.key == key)
            return MRU.val;
        int value;
        if (map.get(key) == null) {
            Node current = LRU;
            value = current.val;
            LRU = LRU.next;
            if (LRU != null) {
                map.put(LRU.key, null);
            }
        } else {
            Node prev = map.get(key);
            Node current = prev.next;
            value = current.val;
            prev.next = current.next;
            if (current.next != null) {
                map.put(current.next.key, prev);
            } else {
                MRU = prev;
            }
        }
        map.remove(key);
        addAtMRU(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (size == 0) {
            addAtMRU(key, value);
            size++;
            return;
        }

        if (map.containsKey(key)) {
            if (MRU.key == key) {
                MRU.val = value;
                return;
            }
            if (map.get(key) == null) {
                LRU = LRU.next;
                if (LRU != null) {
                    map.put(LRU.key, null);
                }
                map.remove(key);
                addAtMRU(key, value);
                return;
            }
            Node prev = map.get(key);
            Node current = prev.next;
            prev.next = current.next;
            if (current.next != null) {
                map.put(current.next.key, prev);
            } else {
                MRU = prev;
            }
            map.remove(key);
            addAtMRU(key, value);
            return;
        } else {
            addAtMRU(key, value);
            size++;
            if (size > capacity) {
                int removedKey = LRU.key;
                LRU = LRU.next;
                map.remove(removedKey);
                if (LRU != null) {
                    map.put(LRU.key, null);
                }
                size--;
            }
        }
    }

    private void addAtMRU(int key, int value) {
        Node node = new Node(key, value);
        if (LRU == null) {
            LRU = node;
            MRU = node;
            map.put(key, null);
        } else {
            MRU.next = node;
            map.put(key, MRU);
            MRU = node;
        }
    }
}