
import java.util.*;

public class find_max_xor_subarray {

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 12, 7, 6};
        // int[] nums2 = {1 , 2, 3, 4 , 5};
        int position = 0;
        List<Integer> indicesWithMostSignificantBit = new ArrayList<>();
        for (int i = 31; i >= 0; i--) {
            for (int j = 0; j < nums.length; j++) {
                int bit = findBit(nums[j], i);
                if (bit == 1) {
                    indicesWithMostSignificantBit.add(j);
                }
            }
            if (!indicesWithMostSignificantBit.isEmpty()) {
                position = i;
                break;
            }
        }

        int maxXOR = 0;
        for (int indice : indicesWithMostSignificantBit) {
            int top = indice;
            int bottom = indice;
            int temp = indice - 1;
            while (temp >= 0 && findBit(nums[temp], position) == 0) {
                top = temp;
                temp--;
            }
            temp = indice + 1;
            while (temp < nums.length && findBit(nums[temp], position) == 0) {
                bottom = temp;
                temp++;
            }
            int XOR = (1 << position) | findMax(indice, top, bottom, position - 1, nums);
            if (XOR > maxXOR) {
                maxXOR = XOR;
            }
        }
        System.out.println("Max XOR: " + maxXOR);
    }

    private static int findBit(int num, int position) {
        return ((num >> position) & 1);
    }

    private static int findMax(int index, int topIndex, int bottomIndex, int position, int[] nums) {
        if (position < 0) {
            return 0;
        }
        int currentBit = findBit(nums[index], position);
        if (currentBit == 1) {
            int newTop = topIndex;
            int newBottom = bottomIndex;
            for (int i = topIndex; i < index; i++) {
                if (findBit(nums[i], position) == 1) {
                    newTop = i + 1;
                }
            }
            for (int i = bottomIndex; i > index; i--) {
                if (findBit(nums[i], position) == 1) {
                    newBottom = i - 1;
                }
            }
            return (1 << position) | findMax(index, newTop, newBottom, position - 1, nums);
        } else {
            boolean found = false;
            for (int i = topIndex; i <= bottomIndex; i++) {
                if (findBit(nums[i], position) == 1) {
                    found = true;
                    break;
                }
            }
            if (found) {
                return (1 << position) | findMax(index, topIndex, bottomIndex, position - 1, nums);
            } else {
                return findMax(index, topIndex, bottomIndex, position - 1, nums);
            }
        }
    }
}
