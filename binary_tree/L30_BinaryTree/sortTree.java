package binary_tree.L30_BinaryTree;

import java.util.*;

public class sortTree {
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
        ArrayList<TreeNode> nodes = new ArrayList<>();
        sort(root, nodes);
        Collections.sort(nodes, (a, b) -> {
            return Integer.compare(a.val, b.val);
        });
        // For any node in Binary Search Tree all the left nodes have value less than
        // that nodes value and right nodes have value greqter than or equal to that
        // node value
        for (TreeNode node : nodes) {
            System.out.print(node.val + " ");
        }
        int index = nodes.size()/2;
    }

    private static void sort(TreeNode root, ArrayList<TreeNode> nodes) {
        if (root == null)
            return;
        nodes.add(root);
        sort(root.left, nodes);
        sort(root.right, nodes);
    }
}
