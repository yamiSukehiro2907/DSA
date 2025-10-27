package binary_tree.L29_BinaryTree;

import java.util.*;

public class Solution {
    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        if (!isLeaf(root))
            result.add(root.val);
        addLeftBoundary(root.left, result);
        addLeaves(root, result);
        addRightBoundary(root.right, result);
        return result;
    }

    private boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    private void addLeftBoundary(TreeNode node, ArrayList<Integer> result) {
        while (node != null) {
            if (!isLeaf(node))
                result.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private void addLeaves(TreeNode node, ArrayList<Integer> result) {
        if (node == null)
            return;
        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private void addRightBoundary(TreeNode node, ArrayList<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node))
                stack.push(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }
}
