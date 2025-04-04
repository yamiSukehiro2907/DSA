package L30_BinaryTree;

public class searchInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(9);
        root.left.left.left = new TreeNode(2);
        root.right = new TreeNode(16);
        root.right.left = new TreeNode(13);
        root.right.left.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        root.right.right.right = new TreeNode(21);
        System.out.println(find(root, 18));
        print(root);
    }

    private static boolean find(TreeNode root, int target) {
        if (root == null)
            return false;
        if (root.val == target)
            return true;
        if (target < root.val)
            return find(root.left, target);
        else
            return find(root.right, target);
    }
    private static void print(TreeNode root){
        if(root == null) return;
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }
}
