package binary_search_tree;

import java.util.*;

import common.TreeNode;

public class mode_in_binary_search_tree {

    public static void main(String[] args) {

    }

    private static ArrayList<Integer> list = new ArrayList<>();

    private static ArrayList<Integer> findMode(TreeNode root) {
        solve(root);
        return list;
    }

    private static int max_freq = 0;
    private static int curr_freq = 0;
    private static Integer prev = null;

    private static void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        solve(root.left);
        if (prev != null && prev == root.val) {
            curr_freq++; 
        }else {
            curr_freq = 1;
        }
        if (curr_freq > max_freq) {
            max_freq = curr_freq;
            list.clear();
            list.add(root.val);
        } else if (curr_freq == max_freq) {
            list.add(root.val);
        }
        prev = root.val;
        solve(root.right);
    }
}
