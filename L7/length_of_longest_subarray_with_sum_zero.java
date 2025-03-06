import java.util.*;

public class length_of_longest_subarray_with_sum_zero {
    public static void main(String[] args) {
        int arr[] = {};
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        int ans = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int prefix[] = new int[arr.length + 1];
        for(int i = 1 ; i <= arr.length ; i++){
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        for(int i = 1 ; i <= arr.length ; i++){ 
            if(!map.containsKey(prefix[i])){
                map.put(prefix[i], new ArrayList<>());
            }
            map.get(prefix[i]).add(i);
        }
        return ans - 1;
    }
}
