package L21;

import java.util.*;

class SongNode {
    String data;
    SongNode next;
    SongNode prev;

    SongNode(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Spotify {
    private SongNode head;
    private int capacity;
    private int size;
    private Set<String> set;

    Spotify(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.size = 0;
        this.set = new HashSet<>();
    }

    public void insert(String song) {
        boolean exist = set.contains(song);
        if (exist) {
            if (head.data == song)
                return;
            SongNode prev = head;
            SongNode curr = head.next;
            while (curr != null && curr.data != song) {
                curr = curr.next;
                prev = prev.next;
            }
            prev.next = curr.next;
            insertAtHead(song);
            return;
        }
        insertAtHead(song);
        set.add(song);
        size++;
        if (size > capacity) {
            SongNode temp = head;
            while (temp != null && temp.next != null && temp.next.next != null)
                temp = temp.next;
            set.remove(temp.data);
            temp.next = null;
        }
        return;
    }

    public void insertAtHead(String song) {
        SongNode newHead = new SongNode(song);
        newHead.next = head;
        head = newHead;
    }

    public int currentsize() {
        return size;
    }

    public void print() {
        SongNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void clearPlaylist() {
        head = null;
        size = 0;
        return;
    }
}

public class LRU_singly {
    public static void main(String[] args) {
        Spotify playlist = new Spotify(4);
        playlist.insert("Ae Dil Hain MushKil");
        System.out.println(playlist.currentsize());
        playlist.insert("Jogi Ji Dheere Dheere");
        System.out.println(playlist.currentsize());
        playlist.insert("Bulleya");
        System.out.println(playlist.currentsize());
        playlist.insert("Jai Jai Shiv Shankar");
        System.out.println(playlist.currentsize());
        playlist.insert("Jogi Ji Dheere Dheere");
        System.out.println(playlist.currentsize());
        playlist.print();
    }
}
