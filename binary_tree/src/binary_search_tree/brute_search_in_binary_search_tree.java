package binary_search_tree;

import common.TreeNode;

public class brute_search_in_binary_search_tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(9);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(21);
        root.left.right.left = new TreeNode(13);
        root.right.right.left = new TreeNode(18);
        root.right.right.left.left = new TreeNode(16);
        boolean exist = find(root, 9);
        System.out.println(exist);
    }

    private static boolean find(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        return find(root.left, target) || find(root.right, target);
    }
}
