package L21;

import java.util.*;

class SongNode {
    String data;
    SongNode next;

    SongNode(String data) {
        this.data = data;
        this.next = null;
    }
}

class Spotify {
    private SongNode LRU;
    private SongNode MRU;
    private int capacity;
    private int size;
    private Map<String, SongNode> map;

    Spotify(int capacity) {
        this.capacity = capacity;
        this.LRU = null;
        this.MRU = null;
        this.size = 0;
        this.map = new HashMap<>();
    }

    public void insert(String song) {
        if (size == 0) {
            SongNode newHead = new SongNode(song);
            newHead.next = LRU;
            map.put(song, null);
            LRU = newHead;
            MRU = newHead;
            return;
        }
        boolean exist = map.containsKey(song);
        if (exist) {
            if (size < capacity) {
                if (MRU.data == song)
                    return;
                if (LRU.data == song) {
                    LRU = LRU.next;
                    insertAtMRU(song);
                    return;
                }
                SongNode previous = map.get(song);
                SongNode next = previous.next.next;
                previous.next = next;
                insertAtMRU(song);
            }
        }
        if (size < capacity) {
            map.put(song, MRU);
            insertAtMRU(song);
            size++;
            return;
        }
    }

    private void insertAtMRU(String song) {
        SongNode newHead = new SongNode(song);
        MRU.next = newHead;
        MRU = MRU.next;
    }

    public void print() {
        SongNode temp = LRU;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

public class LRU_singly {
    public static void main(String[] args) {
        Spotify playlist = new Spotify(4);
        playlist.insert("Ae Dil Hain MushKil");
        playlist.insert("Jogi Ji Dheere Dheere");
        playlist.insert("Bulleya");
        playlist.insert("Jai Jai Shiv Shankar");
        playlist.insert("Jogi Ji Dheere Dheere");
        playlist.print();
    }
}
