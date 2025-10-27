public class longest_common_prefix{
    public static void main(String[] args) {

    }
    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            int minlength = Integer.MAX_VALUE;
            for (int i = 0; i < strs.length; i++) {
                minlength = Math.min(minlength, strs[i].length());
            }
            StringBuilder sb = new StringBuilder();
            int k = 0;
            while (k < minlength) {
                char ch = strs[0].charAt(k);
                boolean present = true;
                for (int i = 0; i < strs.length; i++) {
                    if (strs[i].charAt(k) != ch) {
                        present = false;
                        break;
                    }
                }
                if (present) {
                    sb.append(ch);
                }
                k++;
            }
            return sb.toString();
        }
    }
}