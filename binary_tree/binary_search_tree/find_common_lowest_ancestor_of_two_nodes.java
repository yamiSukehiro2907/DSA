package binary_search_tree;
import common.TreeNode;
public class find_common_lowest_ancestor_of_two_nodes {
    public static void main(String[] args) {

    }

    private static TreeNode commonLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null)
            return null;
        boolean inleftn1 = find(root.left, node1);
        boolean inrightn1 = find(root.right, node1);
        boolean inleftn2 = find(root.left, node2);
        boolean inrightn2 = find(root.right, node2);
        if (inleftn1 && inleftn2)
            return commonLCA(root.left, node1, node2);
        if (inrightn1 && inrightn2)
            return commonLCA(root.right, node1, node2);
        return root;
    }

    private static boolean find(TreeNode root, TreeNode node) {
        if (root == node)
            return true;
        if (root == null)
            return false;
        return find(root.left, node) || find(root.right, node);
    }

    private static TreeNode findcommonLCA(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == root || root == node2)
            return root;
        TreeNode left = findcommonLCA(root.left, node1, node2);
        TreeNode right = findcommonLCA(root.right, node1, node2);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}
