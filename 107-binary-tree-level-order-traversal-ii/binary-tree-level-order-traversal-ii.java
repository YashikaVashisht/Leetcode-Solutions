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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>  res= new ArrayList<>();
        if(root==null) return res;
        List<Integer> ans= new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                res.add(ans);
                ans= new ArrayList<>();
                if(!q.isEmpty()){
                    q.offer(null);
                }
                    
                
            }else{
                ans.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
        }
        Collections.reverse(res);
        return res;

    }
}