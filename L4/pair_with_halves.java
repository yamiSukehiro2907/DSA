import java.util.*;

public class pair_with_halves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        long count = 0;
        for (int i = N - 1; i >= 0; i--) {
            int target = arr[i]/2;
            int idx = bs(arr, target);
            count += idx;
        }
        System.out.println(count);
    }

    static int bs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if(arr[mid] == target){
                while(arr[mid] == target){
                    mid++;
                }
                return mid;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
    // 2 3 4 4 7 10 
}