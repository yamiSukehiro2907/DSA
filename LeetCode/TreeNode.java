class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    int i, j;

    private TreeNode build(int pre[], int in[], int prev) {
        if (i >= pre.length)
            return null;
        else if (prev == in[j]) {
            j++;
            return null;
        } else {
            TreeNode root = new TreeNode(pre[i]);
            i++;
            root.left = build(pre, in, root.val);
            root.right = build(pre, in, prev);
            return root;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i = 0;
        j = 0;
        return build(preorder, inorder, Integer.MIN_VALUE);
    }
}
