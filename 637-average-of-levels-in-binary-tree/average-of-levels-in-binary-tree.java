/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<Double> res= new ArrayList<>();
        q.add(root);
        q.add(null);
        long sum=0;
        int count=0;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                res.add((double) sum / count);  
                sum = 0;
                count = 0;
                if(q.isEmpty()) {
                    return res;   
                }else {
                    q.add(null);  
                }
            }else{
                sum+=curr.val;
                count++;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return res;
    }
}