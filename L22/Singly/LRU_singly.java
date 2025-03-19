package L22.Singly;

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
