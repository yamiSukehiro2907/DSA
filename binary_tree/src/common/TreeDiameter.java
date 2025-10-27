package common;

public class TreeDiameter {
    public static void main(String[] args) {
        TreeNode temp = new TreeNode(3);
        temp.left = new TreeNode(6);
        temp.left.left = new TreeNode(2);
        temp.left.right = new TreeNode(7);
        temp.left.left.left = new TreeNode(-1);
        temp.left.right.right = new TreeNode(8);
        TreeData data = getDiameter(temp);
        System.out.println("Tree Height: " + data.height);
        System.out.println("Tree Diameter: " + data.diameter);
    }

    private static TreeData getDiameter(TreeNode root) {
        if (root == null)
            return new TreeData(-1, -1);
        TreeData left = getDiameter(root.left);
        TreeData right = getDiameter(root.right);
        int height = Math.max(left.height, right.height) + 1;
        int diameter = Math.max(left.height + right.height + 2, Math.max(left.diameter, right.diameter));
        return new TreeData(height, diameter);
    }
}
