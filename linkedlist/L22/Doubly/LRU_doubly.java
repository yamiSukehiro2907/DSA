package L22.Doubly;

import java.util.HashMap;

class SongNode {
    String data;
    SongNode prev;
    SongNode next;

    SongNode(String song) {
        this.data = song;
        this.prev = null;
        this.next = null;
    }
}

class Spotify {
    private SongNode LRU;
    private SongNode MRU;
    private int capacity;
    private int size;
    private HashMap<String, SongNode> map;

    Spotify(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public void insert(String song) {
        if (size == 0) {
            SongNode head = new SongNode(song);
            LRU = head;
            MRU = head;
            size++;
            return;
        }
        boolean exist = map.containsKey(song);
        if (exist) {
            SongNode previous = map.get(song);

        }
    }

    public void print() {
        SongNode temp = MRU;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.prev != null)
                System.out.print(" -> ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

public class LRU_doubly {
    public static void main(String[] args) {
        Spotify playlist = new Spotify(4);
        playlist.insert("Ae Dil Hai MushKil");
    }
}
