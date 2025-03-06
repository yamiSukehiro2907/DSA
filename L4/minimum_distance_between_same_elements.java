import java.util.*;

public class minimum_distance_between_same_elements {
    public static void main(String[] args) {
        int arr[] = { 3, 5, 2, 3, 6, 5, 5, 2, 3 };
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                min = Math.min(i - map.get(arr[i]), min);
            }
            map.put(arr[i], i);
        }
        System.out.println(min);
    }
}
