package binary_search_tree;

import common.TreeNode;

public class delete_Node_in_binary_search_tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);
        root.left.left.left = new TreeNode(2);
        root.right = new TreeNode(16);
        root.right.left = new TreeNode(13);
        root.right.left.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        root.right.right.right = new TreeNode(21);
        print(root);
        System.out.println();
        root = delete(root, 2);
        print(root);
    }

    private static TreeNode delete(TreeNode root, int node) {
        if (root == null)
            return null;
        int rVal = root.val;
        if (rVal < node)
            root.right = delete(root.right, node);
        else if (rVal > node)
            root.left = delete(root.left, node);
        else {
            // If it has only one child then we return non-null subtree
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            // find the maximum element in the left subtree
            int max = find(root.left);
            root.val = max;
            root.left = delete(root.left, max);
        }
        return root;
    }

    private static int find(TreeNode node) {
        while (node.right != null)
            node = node.right;
        return node.val;
    }

    private static void print(TreeNode root) {
        if (root == null)
            return;
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

}
