package recursion.L8;

public class fibonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if (n <= 2)
            return 1;
        for(int i = 0 ; i < 10 ; i++) System.out.print(i + " ");
        System.out.println();
        return solve(n - 1) + solve(n - 2);
    }
}
