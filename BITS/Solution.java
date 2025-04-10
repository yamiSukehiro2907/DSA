package BITS;

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    private Map<Integer , Integer> map = new HashMap<>();
    public int level = 0, min = Integer.MAX_VALUE;

    public void getMin(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>(map.key   Set());
        level++;
        if (level == min) {
            level--;
            return;
        }
        if (root.left == null && root.right == null) {
            min = Math.min(level, min);
            level--;
            return;
        }
        if ((root.left != null) && (root.right == null || root.right.right != null || root.right.left != null))
            getMin(root.left);
        if (root.right != null)
            getMin(root.right);
        level--;
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        getMin(root);
        return min;
    }
}