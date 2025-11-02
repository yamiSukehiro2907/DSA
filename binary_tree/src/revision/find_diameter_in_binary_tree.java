package revision;

import common.TreeData;
import common.TreeNode;

public class find_diameter_in_binary_tree {

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
        System.out.println(find_diameter(node));
    }

    private static int find_diameter(TreeNode root) {
        return find(root).diameter - 1;
    }

    private static TreeData find(TreeNode root) {
        if (root == null) {
            return new TreeData(0, -1);
        }
        TreeData left = find(root.left);
        TreeData right = find(root.right);
        int height = Math.max(left.height, right.height) + 1;
        int diameter = Math.max(left.diameter, Math.max(right.diameter, left.height + right.height + 1));
        return new TreeData(height, diameter);
    }
}
