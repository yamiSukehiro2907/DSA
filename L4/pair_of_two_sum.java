import java.util.*;

public class pair_of_two_sum {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 7, 5, 4, 5, 6, 8, 6, 5, 7 };
        int K = 10;
        int total = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(K - num)) {
                total += map.get(K - num);
            }
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        System.out.println(total);
        // String str = "aa";
        // System.out.println(str.hashCode());
        // int h = 0;
        // for(int i = 0  ; i < str.length() ; i++) h = h * 31 + str.charAt(i); // converting to hash code 
        // System.out.println(h);
    }

}