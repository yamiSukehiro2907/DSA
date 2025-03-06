import java.util.*;

public class maxsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = { 2, 0, 1, 8, -2, 5, 1 };
        int k = 4;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i]; // 2 , 0 , 1 , 8
        }
        int max = sum;
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k]; 
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}