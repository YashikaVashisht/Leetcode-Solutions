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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // List<List<Integer>> res= new ArrayList<>();
        // if(root==null) return res;
        // Queue<TreeNode> q= new LinkedList<>();
        // q.offer(root);
        // while(!q.isEmpty()){
        //     int k = q.size();
        //     ArrayList<Integer> level= new ArrayList<>();
        //     for(int i=0;i<k;i++){
        //         TreeNode curr= q.poll();
        //         level.add(curr.val);
        //         if(curr.left!=null) q.offer(curr.left);
        //         if(curr.right!= null) q.offer(curr.right);

        //     }
        //     res.add(level);
        //     level= new ArrayList<>();
        // }
        // return res;

        List<List<Integer>> res= new ArrayList<>();
        if(root==null) return res;
         Queue<TreeNode> q= new LinkedList<>();
         ArrayList<Integer> level= new ArrayList<>();
         q.offer(root);
         q.offer(null);
         while(!q.isEmpty()){
            TreeNode curr= q.poll();
            if(curr==null){
                res.add(level);
                level= new ArrayList<>();
                if(q.isEmpty()){
                    return res; 
                }else{
                    q.offer(null);
                }
            }else{
                level.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
         }
         return res;


    }
}