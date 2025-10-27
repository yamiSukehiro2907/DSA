package famous_problems;

import common.TreeNode;
import java.util.*;

public class pathSum2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(9);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(21);
        List<List<Integer>> ans = pathSum(root, 26);
        for(List<Integer> temp : ans) System.out.println(temp);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans, root, 0, targetSum, new ArrayList<>());
        return ans;
    }

    private static void solve(List<List<Integer>> ans, TreeNode root, int sum, int targetSum, List<Integer> temp) {
        if (root == null) return;
        sum += root.val;
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == targetSum) ans.add(temp);
            return;
        }
        solve(ans, root.left, sum, targetSum, temp);
        temp.remove(temp.size() - 1);
        solve(ans, root.right, sum, targetSum, temp);
    }
}
