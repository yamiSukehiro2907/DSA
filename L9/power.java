package L9;

public class power {
    public static void main(String[] args) {
        int n = 10;
        int a = 3;
        int k = (int) Math.sqrt(n);
        int l = n / k;
        long s = multiply(1, a, k);
        long t = multiply(1, s, l);
        int g = n - l * k;
        long j = multiply(1, a, g);
        System.out.println(j * t);
        System.out.println(Math.pow(3 , 10));
    }

    static long multiply(long l, long a, int n) {
        if (n <= 0)
            return l;
        return multiply(l * a, a, --n);
    }
}
