package revision;
public class point_to_next_available_right_node {

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
        change(node);
    }

    private static void change(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = root;
        while (current != null) {
            TreeNode temp = current;
            while (temp != null && temp.left == null && temp.right == null) {
                temp = temp.next;
            }
            TreeNode nextStartPoint;
            if (temp == null) {
                return;
            } else if (temp.left != null) {
                nextStartPoint = temp.left;
            } else {
                nextStartPoint = temp.right;
            }
            temp = current;
            TreeNode node1 = null, node2 = null;
            while (temp != null) {
                if (temp.left != null && temp.right != null) {
                    if (node1 == null) {
                        node1 = temp.right;
                    } else if (node2 == null) {
                        node1.next = temp.left;
                        node1 = temp.right;
                    }
                    temp.left.next = temp.right;
                } else if (temp.left != null) {
                    if (node1 == null) {
                        node1 = temp.left;
                    } else {
                        node1.next = temp.left;
                        node1 = node1.next;
                    }
                } else if (temp.right != null) {
                    if (node1 == null) {
                        node1 = temp.right;
                    } else {
                        node1.next = temp.right;
                        node1 = node1.next;
                    }
                }
                temp = temp.next;
            }
            current = nextStartPoint;
        }
    }

    private static class TreeNode {

        @SuppressWarnings("unused")
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = this.next = null;
        }
    }

}
