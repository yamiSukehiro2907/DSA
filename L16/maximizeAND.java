package L16;

public class maximizeAND {
    public static void main(String[] args) {
        int arr[] = { 27, 18, 20 };
        int k = 2;
        int ans = 0;
        boolean visited[] = new boolean[arr.length];
        for(int i = 0 ; i < arr.length ; i++) visited[i] = true;
        for (int i = 31; i >= 0; i--) {
            int count = bitCount(arr, i);
            while (count >= k) {
                ans = setBit(ans, i);
                change(visited, arr, i);
            }
        }
        System.out.println(ans);
    }

    private static int bitCount(int[] arr, int i) {
        int count = 0;
        for (int num : arr) if(checkbit(num, i) == 1) count++;
        return count;
    }

    private static int checkbit(int n, int i) {
        return (1 & (n >> i)) == 1 ? 1 : 0;
    }

    private static int setBit(int ans, int i) {
        return (ans | (1 << i));
    }

    private static void change(boolean[] visited, int[] arr, int i) {
        for(int j = 0 ; j < arr.length ; j++){
            if(checkbit(arr[j], i) != 1) visited[i] = false;
        }
    }
}
