package revision;

import common.TreeNode;

public class build_tree_from_inorder_and_preorder {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preOrder = {1, 2, 3};
        int[] inOrder = {2, 1, 3};
        TreeNode root = solution.buildTree(preOrder, inOrder);
        root.print();
    }

    private static class Solution {

        private int preOrderIndex;
        private int inOrderIndex;
        private int[] preOrder;
        private int[] inOrder;

        public TreeNode buildTree(int[] preOrder, int[] inOrder) {
            preOrderIndex = 0;
            inOrderIndex = 0;
            this.preOrder = preOrder;
            this.inOrder = inOrder;
            return build(Integer.MAX_VALUE);
        }

        private TreeNode build(int parent) {
            if (preOrderIndex >= preOrder.length) {
                return null;
            }
            if (parent == inOrder[inOrderIndex]) {
                inOrderIndex++;
                return null;
            }
            TreeNode root = new TreeNode(preOrder[preOrderIndex++]);
            root.left = build(root.val);
            root.right = build(parent);
            return root;
        }
    }
}
