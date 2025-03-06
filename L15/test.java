package L15;

public class test {
    public static void main(String[] args) {
        int n = 16;
        int k = 1;
        for (int i = 0; i < 32; i++) {
            k <<= 1;
            System.out.println(k);
            if (i % 2 == 1) {
                if ((k ^ n) == 0) {
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
}
