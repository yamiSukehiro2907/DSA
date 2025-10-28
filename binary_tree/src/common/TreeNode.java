package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
        this.left = this.right = null;
    }

    public TreeNode() {
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }

    public void print() {
        TreeNode temp = this;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(((node == null) ? "Null" : node.val) + " ");
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
}
