package Lecture.SINGLY;

public class Main {
    public static void main(String[] args) {
        LRUCache spotify = new LRUCache(4);
        spotify.put("Ae Dil Hai MushKil");
        spotify.put("Dil Chahta Hai");
        spotify.put("Kabhi Khushi Kabhie Gham");
        spotify.put("Dil Chahta Hai");
        spotify.print();
        System.out.println(spotify.get("Dil Chahta Hai"));
        System.out.println(spotify.get("Ae Dil Hai MushKil"));
    }
}
