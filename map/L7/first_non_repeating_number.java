import java.util.*;

public class first_non_repeating_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int arr[] = { 3, 1, 2, 1, 5, 6, 2, 3 };
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : arr) {
            if (set1.contains(num))
                set2.add(num);
            set1.add(num);
        }
        int ans = -1;
        for (int num : arr) {
            if (set1.contains(num) && !set2.contains(num)) {
                ans = num;
                break;
            }
        }
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        for (int num : arr) {
            if (map.get(num) == 1) {
                ans = num;
                break;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}