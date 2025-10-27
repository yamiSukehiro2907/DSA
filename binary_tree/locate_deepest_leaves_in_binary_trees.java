import common.TreeNode;
public class locate_deepest_leaves_in_binary_trees {
    public static void main(String[] args) {

    }

    private static class Solution {

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            return dfs(root).node;
        }

        private Pair dfs(TreeNode root) {
            if (root == null) {
                return new Pair(null, 0);
            }
            Pair left = dfs(root.left);
            Pair right = dfs(root.right);
            if (left.depth > right.depth) {
                return new Pair(left.node, left.depth + 1);
            }
            if (left.depth < right.depth) {
                return new Pair(right.node, right.depth + 1);
            }
            return new Pair(root, left.depth + 1);
        }
    }

    private static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }


}
