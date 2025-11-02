package revision;

import common.TreeNode;

public class inorder_traversal_without_recursion_without_stack {

    public static void main(String[] args) {

    }

    public static void print(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = current; 
                }else {
                    temp.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }
}
