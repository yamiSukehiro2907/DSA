package L8;

public class palindrome {
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(solve(s));
    }
    private static boolean solve(String s){
        return check(0 , s.length() - 1 , s);
    }
    private static boolean check(int start , int end , String s){
        if(s.charAt(start) != s.charAt(end)) return false;
        if(start >= end) return true;
        return check(++start , --end , s);
    }
}
