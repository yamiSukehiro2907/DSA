package binary_search_tree;

import common.TreeNode;

public class insert_in_binary_search_tree {

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
        root = insert(root, 22);
        root = insert(root, 10);
        root = insertUsingRecursion(root, 23);
        root = delete(root, 22);
        print(root);
    }

    private static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode temp = root;
        while (temp != null) {
            if (val > temp.val) {
                if (temp.right == null) {
                    temp.right = new TreeNode(val);
                    break;
                }
                temp = temp.right;
            } else {
                if (temp.left == null) {
                    temp.left = new TreeNode(val);
                    break;
                }
                temp = temp.left;
            }
        }
        return root;
    }

    private static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    private static TreeNode insertUsingRecursion(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        int rVal = root.val;
        if (val < rVal) {
            root.left = insertUsingRecursion(root.left, val);
        } else {
            root.right = insertUsingRecursion(root.right, val);
        }
        return root;
    }

    private static TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        int rVal = root.val;
        if (rVal == val) {

        } else if (val < rVal) {
            root.left = delete(root.left, val);
        } else {
            root.right = delete(root.right, val);
        }
        return root;
    }
}
