package recursion.famous_recursion_problems;

public class Main {
    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    private static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int left = fib(n - 1);
        int right = fib(n - 2);
        return left + right;
    }
}
