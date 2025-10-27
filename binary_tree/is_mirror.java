import common.TreeNode;
public class is_mirror {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        print(root);
    }

    private static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }

    @SuppressWarnings("unused")
    private static boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    @SuppressWarnings("unused")
    private static boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return isMirror(root1.right, root2.left) && isMirror(root1.left, root2.right);
    }

    @SuppressWarnings("unused")
    private static TreeNode mirror(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.right;
        root.right = mirror(root.left);
        root.left = mirror(temp);
        return root;
    }

}
