package L14;

public class setting_a_bit{
    public static void main(String[] args) {
        int n = 8;
        int i = 1;
        int ans = solve(n , i);
        System.out.println(ans);
    }
    private static int solve(int n , int i){
        int k = 1;
        while(i-- > 0) k >>= 1;
        return k | n;
    }
}
