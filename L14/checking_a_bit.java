package L14;

public class checking_a_bit {
    public static void main(String[] args) {
        int n = 3;
        int i = 2;
        System.out.println(solve(n , i));
    }
    private static boolean solve(int n , int i){
        while(i-- > 0) n >>= 1;
        int k = n & 1;
        if(k == 1) return true;
        return false;
    }
}
