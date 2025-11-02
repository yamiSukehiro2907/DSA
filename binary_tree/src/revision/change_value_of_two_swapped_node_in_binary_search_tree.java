package revision;

import common.TreeNode;

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

    

}
