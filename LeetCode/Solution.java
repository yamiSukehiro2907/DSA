import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solve(int[] A, int B) {
        int preSum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            preSum += A[i];
            int rmv = preSum - B;
            if (map.containsKey(rmv)) {
                count += map.get(rmv);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
