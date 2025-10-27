package recursion.L9;

public class q3 {
    public static void main(String[] args) {
        int A = 2;
        int B = 2;
        System.out.println(solve(A, B));
    }

    public static int solve(int A, int B) {
        if (A == 1)
            return 0;
        if (B % 2 == 0)
            return solve(A / 2, B / 2) == 1 ? 1 : 0;
        else
            return solve(A / 2, (B + 1) / 2) == 1 ? 1 : 0;
    }
}

