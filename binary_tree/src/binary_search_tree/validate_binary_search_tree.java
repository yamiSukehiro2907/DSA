package binary_search_tree;

import common.TreeNode;

public class validate_binary_search_tree {


    public static void main(String[] args) {

    }

    private static boolean isBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean check(TreeNode root, long left, long right) {
        if (root == null)
            return true;
        if (root.val >= right || root.val <= left)
            return false;
        return check(root.left, left, root.val) && check(root.right, root.val, right);
    }
}
