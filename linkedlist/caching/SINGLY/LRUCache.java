package Lecture.SINGLY;

import java.util.*;

public class LRUCache {
    private int capacity;
    private int size;
    private Node dummy;
    private Node tail;
    private Map<String, Node> prevMap;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.dummy = new Node("");
        this.tail = dummy;
        this.prevMap = new HashMap<>();
    }

    public String get(String data) {
        if (!prevMap.containsKey(data)) {
            throw new RuntimeException("Data not found: " + data);
        }
        Node prev = prevMap.get(data);
        Node node = prev.next;
        if (dummy.next != node) {
            prev.next = node.next;
            if (node.next != null) {
                prevMap.put(node.next.data, prev);
            } else {
                tail = prev;
            }
            node.next = dummy.next;
            if (dummy.next != null) {
                prevMap.put(dummy.next.data, node);
            } else {
                tail = node;
            }
            dummy.next = node;
            prevMap.put(node.data, dummy);
        }
        return node.data;
    }

    public void put(String data) {
        if (prevMap.containsKey(data)) {
            get(data);
        } else {
            Node node = new Node(data);
            node.next = dummy.next;
            if (dummy.next != null) {
                prevMap.put(dummy.next.data, node);
            } else {
                tail = node;
            }
            dummy.next = node;
            prevMap.put(node.data, dummy);
            size++;
            if (size > capacity) {
                Node prevTail = prevMap.get(tail.data);
                prevTail.next = null;
                prevMap.remove(tail.data);
                tail = prevTail;
                size--;
            }
        }
    }

    public void print() {
        Node node = dummy.next;
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
