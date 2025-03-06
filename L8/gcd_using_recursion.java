package L8;
import java.util.*;
public class gcd_using_recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(gcd(8, 12));
    }

    private static int gcd(int a, int b) {
        if (a != 0) return gcd(b % a, a);
        return b;
    }
}
