package recursion.L9;

public class sir_power {
    public static void main(String[] args) {
        int n = 33;
        int a = 2;
        long ans = solve(a, n);
        System.out.println(ans);
        System.out.println(-1 % 20);
    }

    static long solve(int a, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return a;
        long x = solve(a, n / 2);
        if (n % 2 == 0)
            return x * x;
        else
            return x * x * a;
    }
}
