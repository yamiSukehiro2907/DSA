import java.util.*;

public class freqMap {
    public static void main(String[] args) {
        int arr[] = { 1, 6, 5, 3, 2, 1, 6, 7, 6 };
        int query[] = { 6, 7, 1 };
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        int freq[] = new int[max + 1];
        for (int num : arr) {
            freq[num - 0]++;
        }
        for (int i = 0; i < query.length; i++) {
            System.out.println(freq[query[i] - 0]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (int q : query) {
            System.out.println(map.getOrDefault(q, 0));
        }
    }

}
