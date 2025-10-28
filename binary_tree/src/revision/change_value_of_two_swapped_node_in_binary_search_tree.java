package revision;

import common.TreeNode;
import java.util.Stack;

public class change_value_of_two_swapped_node_in_binary_search_tree {

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
        // node.print();
        Solution solution = new Solution();
        solution.solve(node);
        // node.print();
        Solution2 solution2 = new Solution2();
        System.out.println("In-order traversal");
        solution2.inOrderTraverse(node);
        solution2.printInOrder(node);
        System.out.println();
        System.out.println("PreOrder Traversal");
        solution2.printPreOrder(node);
        System.out.println();
        solution2.traverseInPreOrder(node);
        System.out.println();
        System.out.println("PostOrder Traversal");
        solution2.printPostOrder(node);
        System.out.println();
        solution2.traversePostOrder(node);
    }

    private static class Solution {

        private TreeNode prev;
        private TreeNode node1;
        private TreeNode node2;

        public void solve(TreeNode root) {
            fix(root);
            if (node1 != null && node2 != null) {
                int temp = node1.val;
                node1.val = node2.val;
                node2.val = temp;
            }
        }

        private void fix(TreeNode root) {
            if (root == null) {
                return;
            }
            fix(root.left);
            if (prev != null) {
                if (root.val < prev.val) {
                    if (node1 == null) {
                        node1 = prev;
                        node2 = root;
                    } else {
                        node2 = root;
                    }
                }
            }
            prev = root;
            fix(root.right);
        }
    }

    private static class Solution2 {

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
                }else{
                    System.out.print(stack.pop().val + " ");
                    lastVisited = top;
                }
            }
        }
    }

}
