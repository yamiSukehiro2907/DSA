package famous_problems;
import common.TreeNode;
import java.util.*;

public class average_of_level_in_binary_tree {
    public static void main(String[] args) {

    }

    private static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            return new AbstractList<>() {
                List<Double> temp = null;

                @Override
                public int size() {
                    if (temp == null) {
                        temp = helper(root);
                    }
                    return temp.size();
                }

                @Override
                public Double get(int ind) {
                    if (temp == null) {
                        temp = helper(root);
                    }
                    return temp.get(ind);
                }
            };
        }

        private List<Double> helper(TreeNode root) {
            List<Double> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                int n = q.size();
                long s = 0;
                for (int i = 0; i < n; i++) {
                    TreeNode curr = q.poll();
                    if (curr == null) continue;
                    s += curr.val;
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
                res.add((double) s / n);
            }
            return res;
        }
    }

    public static class leftViewofBT {
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
            getView(root, ans, 0);
            for (int num : ans)
                System.out.print(num + " ");
        }

        private static void getView(TreeNode root, List<Integer> ans, int depth) {
            if (root == null)
                return;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                ans.add(queue.peek().val);
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if(node == null) continue;
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }
        }

    }
}