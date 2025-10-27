package recursion.famous_recursion_problems;

import java.util.*;

public class Graycode {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> ans = solve(n);
        for (String s : ans) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> solve(int n) {
        if (n == 1) {
            ArrayList<String> base = new ArrayList<>();
            base.add("0");
            base.add("1");
            return base;
        }
        ArrayList<String> prev = solve(n - 1);
        ArrayList<String> ans = new ArrayList<>();
        for (String s : prev)
            ans.add("0" + s);
        for (int i = prev.size() - 1; i >= 0; i--)
            ans.add("1" + prev.get(i));
        return ans;
    }
}
