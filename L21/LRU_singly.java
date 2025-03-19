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
    private int size;
    private Map<String, SongNode> map;

    Spotify() {
        this.LRU = null;
        this.MRU = null;
        this.size = 0;
        this.map = new HashMap<>();
    }

    public void insert(String song) {
        if (size == 0) {
            insertAtMRU(song);
            LRU = MRU;
            size++;
            map.put(song, null);
            return;
        }
        boolean exist = map.containsKey(song);
        if (exist) {
            if (MRU.data.equals(song))
                return;
            if (LRU.data.equals(song)) {
                LRU = LRU.next;
            } else {
                SongNode previous = map.get(song);
                if (previous != null && previous.next != null) {
                    previous.next = previous.next.next;
                }
            }
            insertAtMRU(song);
            return;
        }
        insertAtMRU(song);
        size++;
    }

    private void insertAtMRU(String song) {
        SongNode newHead = new SongNode(song);
        if (MRU == null) {
            MRU = newHead;
            LRU = newHead;
        } else {
            map.put(song, MRU);
            MRU.next = newHead;
            MRU = newHead;
        }
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
        Spotify playlist = new Spotify();
        playlist.insert("Ae Dil Hain MushKil");
        playlist.insert("Jogi Ji Dheere Dheere");
        playlist.insert("Bulleya");
        playlist.insert("Jai Jai Shiv Shankar");
        playlist.insert("Jogi Ji Dheere Dheere");
        playlist.print();
    }
}
