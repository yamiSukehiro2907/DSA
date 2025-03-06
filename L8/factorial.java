package L8;

public class factorial {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(find(n));
        System.out.println(sum(n));
    }

    private static int find(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * find(n - 1);
    }

    private static int sum(int n) {
        if (n <= 0)
            return 0;
        return n + sum(n - 1);
    }
}
