package famous_problems;

import common.TreeNode;
import java.util.*;

public class right_view_of_binary_tree {
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
        List<Integer> ans = new ArrayList<>();
        getView(ans, root);
        for (int num : ans)
            System.out.print(num + " ");
    }

    private static void getView(List<Integer> ans, TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans.add(queue.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null)
                    queue.add(node.right);
                if (node.left != null)
                    queue.add(node.left);
            }
        }
    }

    public static class build_tree_from_prefix_and_postfix {
        public static void main(String[] args) {

        }

        private static class Solution {

            int i, j;

            private TreeNode build(int pre[], int in[], int prev) {
                if (i >= pre.length) {
                    return null;
                } else if (prev == in[j]) {
                    j++;
                    return null;
                } else {
                    TreeNode root = new TreeNode(pre[i]);
                    i++;
                    root.left = build(pre, in, root.val);
                    root.right = build(pre, in, prev);
                    return root;
                }
            }

            public TreeNode buildTree(int[] preorder, int[] inorder) {
                i = 0;
                j = 0;
                return build(preorder, inorder, Integer.MIN_VALUE);
            }
        }

    }
}
