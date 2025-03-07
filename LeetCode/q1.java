public class q1 {
    public static void main(String[] args) {
        System.out.println(solve(4));
    }

    private static int solve(int n) {
        return find(n, true);
    }

    private static int find(int a, int b, int d, boolean left, int n) {
        if (n == 1)
            return a;
        boolean even = n % 2 == 0;
        if (!left)
            return find(a + d, even ? b - d : b, 2 * d, !left, n / 2);
        return find(even ? a + d : a, b - d, 2 * d, !left, n / 2);
    }

    private static int find(int n, boolean left) {
        if (n == 1)
            return 1;
        return 0;
    }
}
