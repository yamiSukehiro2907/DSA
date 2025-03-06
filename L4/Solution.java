import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int arr[] = { 8, 12, 16, 4, 0, 20 };
        int B = 4;
        System.out.println(solve(arr, B));
    }

    public static int solve(int[] A, int B) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i] + B) && map.get(A[i] + B) > 0) {
                count++;
                map.put(A[i] + B, map.get(A[i] + B) - 1);
            } else if (map.containsKey(A[i] - B) && map.get(A[i] - B) > 0) {
                count++;
                map.put(A[i] - B, map.get(A[i] - B) - 1);
            } else {
                if (map.containsKey(A[i])) {
                    map.put(A[i], map.get(A[i]) + 1);
                } else {
                    map.put(A[i], 1);
                }
            }
        }
        return count;
    }
}
