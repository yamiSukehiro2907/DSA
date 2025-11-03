package revision;

import common.TreeNode;
import java.util.ArrayList;

public class inorder_traversal_without_recursion_without_stack {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(11);
        node.left = new TreeNode(6);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(9);
        node.left.right.left = new TreeNode(8);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(12);
        node.right.right = new TreeNode(21);
        node.right.right.left = new TreeNode(18);
        node.right.right.left.left = new TreeNode(16);
        print(node);
        System.out.println(solve(node));
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
                    current = current.left;
                } else {
                    temp.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }

    public static ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                list.add(current.val);
                current = current.right;
            } else {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = current;
                    current = current.left;
                } else {
                    temp.right = null;
                    list.add(current.val);
                    current = current.right;
                }
            }
        }
        return list;
    }
}
