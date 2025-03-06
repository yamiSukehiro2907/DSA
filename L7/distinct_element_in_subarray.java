import java.util.*;

public class distinct_element_in_subarray {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 1, 3, 5, 6, 2, 5, 5, 7 };
        int k = 4;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        list.add(map.size());
        for (int i = k; i < arr.length; i++) {
            map.put(arr[i - k], map.get(arr[i - k]) - 1);
            if (map.get(arr[i - k]) == 0) map.remove(arr[i - k]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            list.add(map.size());
        }
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
