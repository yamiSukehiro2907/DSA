package L15;

public class find2_non_repeating {
    public static void main(String[] args) {
        int arr[] = { 245, 4234, 654, 356, 4234, 245 };
        int xor = 0;
        for (int num : arr)
            xor ^= num;
        int k = xor & (-xor); // taking xor with negative of itself gives us the rightmost set bit which is
                                 // different in
                                 // both the numbers
        System.out.println(Integer.toBinaryString(xor));
        System.out.println(Integer.toBinaryString(-xor));
        System.out.println(Integer.toBinaryString(k));
        // dividing the elements in two groups
        int x = 0;
        int y = 0;
        for (int num : arr) {
            if ((num & k) == 0) // if the element contains that set bit
                x ^= num;
            else // if it does not
                y ^= num;
        }
        System.out.println(x + " " + y);
    }
}
