package revision;

import common.TreeData;
import common.TreeNode;

public class find_diameter_in_binary_tree {

    public static void main(String[] args) {

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
