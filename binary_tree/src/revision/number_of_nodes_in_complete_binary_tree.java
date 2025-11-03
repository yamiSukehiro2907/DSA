package revision;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class number_of_nodes_in_complete_binary_tree {

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
        System.out.println(find(node));
    }

    private static int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        nodeCount = 0;
        solve(root);
    }
    private static int nodeCount;

    private static void solve(TreeNode root) {
        int leftHeight = 0, rightHeight = 0;
        TreeNode left = root, right = root;
        while (left != null) {
            leftHeight++;
            left = left.left;
        }
        while (right != null) {
            rightHeight++;
            right = right.right;
        }
        if (leftHeight == rightHeight) {
            nodeCount += (1 << leftHeight) - 1;
            return;
        }
        nodeCount++;
        solve(root.left);
        solve(root.right);
    }

    class Solution {

        public ArrayList<Integer> safeNodes(int V, int[][] edges) {
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                list.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                list.get(edge[0]).add(edge[1]);
            }
            boolean[] terminalNodes = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (list.get(i).isEmpty()) {
                    terminalNodes[i] = true;
                }
            }
            for (int i = 0; i < V; i++) {
                if (!terminalNodes[i] && bfs(terminalNodes, i, list)) {
                    terminalNodes[i] = true;
                }
            }
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                if (terminalNodes[i]) {
                    ans.add(i);
                }
            }
            return ans;
        }

        private boolean dfs(boolean[] terminalNodes, int src, List<List<Integer>> list) {
            for (int neighbor : list.get(src)) {
                if (!terminalNodes[neighbor]) {
                    if (dfs(terminalNodes, neighbor, list)) {
                        terminalNodes[neighbor] = true; 
                    }else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
