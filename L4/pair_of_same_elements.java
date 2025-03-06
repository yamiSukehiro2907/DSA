import java.util.*;

public class pair_of_same_elements {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int arr[] = { 3, 5, 2, 3, 6, 5, 5, 2, 3 };
            int total = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                if (map.containsKey(arr[i])) {
                    total += map.get(arr[i]);
                }
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            System.out.println(total);
        }
    }
}