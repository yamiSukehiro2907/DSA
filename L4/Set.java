import java.util.*;

public class Set {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = { 1, 2, 7, 9, 1, 2 };
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }
}