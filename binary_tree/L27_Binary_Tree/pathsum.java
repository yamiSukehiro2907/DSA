package L27_Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pathsum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(9);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(21);
        // root.left.right.left = new TreeNode(13);
        // root.right.right.left = new TreeNode(18);
        // root.right.right.left.left = new TreeNode(16);
        List<List<Integer>> ans = new ArrayList<>();
        getTree(ans, root);
        for (List<Integer> list : ans) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println(hasPathSum(root, 36));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return solve(root, 0, targetSum);
    }

    private static boolean solve(TreeNode root, int sum, int target) {
        if (root == null)
            return sum == target;
        sum += root.val;
        System.out.print(sum + " ");
        if (root.left == null && root.right == null)
            return sum == target;
        return solve(root.left, sum, target) || solve(root.right, sum, target);
    }

    private static void getTree(List<List<Integer>> ans, TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodes = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nodes; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(temp);
        }
    }
}