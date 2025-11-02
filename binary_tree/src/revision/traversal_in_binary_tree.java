package revision;

import common.TreeNode;
import java.util.Stack;

public class traversal_in_binary_tree {

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
        Solution solution = new Solution();
        System.out.println("In-order traversal");
        solution.inOrderTraverse(node);
        solution.printInOrder(node);
        System.out.println();
        System.out.println("PreOrder Traversal");
        solution.printPreOrder(node);
        System.out.println();
        solution.traverseInPreOrder(node);
        System.out.println();
        System.out.println("PostOrder Traversal");
        solution.printPostOrder(node);
        System.out.println();
        solution.traversePostOrder(node);
    }

    private static class Solution {

        private Stack<TreeNode> stack;

        private void inOrderTraverse(TreeNode root) {
            this.stack = new Stack<>();
            TreeNode current = root;
            while (!stack.isEmpty() || current != null) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                System.out.print(current.val + " ");
                current = current.right;
            }
            System.out.println();
        }

        private void printInOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }

        private void traverseInPreOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.val + " ");
            traverseInPreOrder(root.left);
            traverseInPreOrder(root.right);
        }

        private void printPreOrder(TreeNode root) {
            TreeNode current = root;
            while (!stack.isEmpty() || current != null) {
                while (current != null) {
                    System.out.print(current.val + " ");
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                current = current.right;
            }
        }

        private void printPostOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.val + " ");
        }

        private void traversePostOrder(TreeNode root) {
            TreeNode current = root;
            TreeNode lastVisited = null;
            while (!stack.isEmpty() || current != null) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                TreeNode top = stack.peek();
                if (top.right != null && lastVisited != top.right) {
                    current = top.right;
                } else {
                    System.out.print(stack.pop().val + " ");
                    lastVisited = top;
                }
            }
        }
    }
}
