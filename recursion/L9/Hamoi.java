package recursion.L9;

import java.util.*;

public class Hamoi {
    public static void main(String[] args) {
        int n = 5;
        ArrayList<Integer> src = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            src.add(i);
        }
    }

    static void solve(ArrayList<Integer> src, ArrayList<Integer> temp, ArrayList<Integer> dist, int n) {
        if (canBreak(dist, n)) return;
        // done
    }

    static boolean canBreak(ArrayList<Integer> dist, int n) {
        if (dist.size() < n)
            return false;
        for (int i = 0; i < dist.size(); i++) {
            if (dist.get(i) != (i + 1))
                return false;
        }
        return true;
    }
}
