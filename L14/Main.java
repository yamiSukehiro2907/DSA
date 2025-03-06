package L14;

public class Main {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 3, 4, 2 };
        int xor = 0;
        for (int num : arr)
            xor ^= num;
        int k = xor & (-xor);
        System.out.println(Integer.toBinaryString(-xor));
        System.out.println(k);
        int x = 0;
        int y = 0;
        for (int num : arr) {
            if ((num & k) == 0) x ^= num;
            else y ^= num;
        }
        System.out.println(x + " " + y);
    }
}
