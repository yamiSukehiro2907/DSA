package recursion.L9;

public class sum_of_digits {
    public static void main(String[] args) {
        int n = -2851;
        int sum = solve(0, Math.abs(n));
        System.out.println(sum);
    }

    static int solve(int sum, int n) {
        if (n == 0)
            return sum;
        return solve(sum + n % 10, n / 10);
    }
}