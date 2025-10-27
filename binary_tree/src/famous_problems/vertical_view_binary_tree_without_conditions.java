package famous_problems;
import common.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class vertical_view_binary_tree_without_conditions {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(9);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(21);
        root.left.right.left = new TreeNode(13);
        root.right.right.left = new TreeNode(18);
        root.right.right.left.left = new TreeNode(16);
        Map<Integer, List<Integer>> map = new HashMap<>();
        getView(map, root, 0);
        List<Integer> index = new ArrayList<>(map.keySet());
        index.sort((a, b) -> a - b);
        for (int idx : index) {
            List<Integer> list = map.get(idx);
            for (int num : list)
                System.out.print(num + " ");
            System.out.println();
        }
    }

    private static void getView(Map<Integer, List<Integer>> map, TreeNode root, int index) {
        if (root == null)
            return;
        if (!map.containsKey(index)) {
            map.put(index, new ArrayList<>());
        }
        map.get(index).add(root.val);
        getView(map, root.left, index - 1);
        getView(map, root.right, index + 1);
    }
}
