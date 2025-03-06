package L15;

public class missing_number {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 2, 6 };
        int xor = 0;
        for (int i = 1; i <= arr.length + 1; i++)
            xor ^= i;
        for (int num : arr)
            xor ^= num;
        System.out.println(xor);
    }
}
