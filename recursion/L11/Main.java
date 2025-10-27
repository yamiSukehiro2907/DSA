public class Main {
    public static void main(String[] args) {
        int a = 41;
        int b = 45;
        System.out.println(gcd(a, b));
    }

    private static int gcd(int a, int b) {
        if (a != 0)
            return gcd(b % a, a);
        return b;
    }
}
