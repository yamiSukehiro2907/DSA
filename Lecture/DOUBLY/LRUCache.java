package Lecture.DOUBLY;

import java.util.*;

public class LRUCache {
    private int capacity;
    private int size;
    private Node head, tail;
    private Map<String, Node> map;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.map = new HashMap<>();
    }

    public String get(String data) {
        if (!map.containsKey(data)) {
            throw new RuntimeException("Data not found: " + data);
        }
        Node node = map.get(data);
        if (node != head) {
            remove(node);
            addAtHead(node);
        }
        return node.data;
    }

    public void put(String data) {
        if (map.containsKey(data)) {
            Node node = map.get(data);
            remove(node);
            addAtHead(node);
        } else {
            Node node = new Node(data);
            if (size == capacity) {
                map.remove(tail.data);
                remove(tail);
            }
            addAtHead(node);
        }
    }

    private void addAtHead(Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
        map.put(node.data, node);
        size++;
    }

    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        size--;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}
