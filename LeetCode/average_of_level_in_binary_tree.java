import java.util.*;
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new AbstractList<>(){
            List<Double> temp = null;

            @Override
            public int size(){
                if(temp==null){
                    temp =  helper(root);
                }
                return temp.size();
            }

            @Override
            public Double get(int ind){
                if(temp == null){
                    temp = helper(root);
                }
                return temp.get(ind);
            }
        };
        return res;
    }

    private List<Double> helper(TreeNode root){
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            long s=0;
            for(int i=0;i<n;i++){
                TreeNode curr = q.poll();
                s += curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            res.add((double) s/n);
        }
        return res;
    }
}