
import common.TreeNode;

public class height_and_diameter {

    public static void main(String[] args) {
        TreeNode temp = new TreeNode(3);
        temp.left = new TreeNode(6);
        temp.left.left = new TreeNode(2);
        temp.left.right = new TreeNode(7);
        temp.left.left.left = new TreeNode(-1);
        temp.left.right.right = new TreeNode(8);
        // post-order traversal
        System.out.println(height(temp));
        System.out.println(diameter(temp));
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_height = height(root.left);
        int right_height = height(root.right);
        return 1 + Math.max(left_height, right_height);
    }

    // In-order Traversal && the time complexity is O(N^2) as we are calculating height of each node
    private static int diameter(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int root_diameter = height(root.left) + height(root.right) + 2; // we are first processing root_node
        int left_diameter = diameter(root.left);
        int right_diameter = diameter(root.right);
        return Math.max(root_diameter, Math.max(left_diameter, right_diameter));
    }
}
