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
        List<List<Integer>> res= new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> q= new LinkedList<>();
        ArrayList<Integer> ans= new ArrayList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode curr= q.poll();
            if(curr==null){
                res.add(ans);
                ans= new ArrayList<>();
                if (!q.isEmpty()) {
                    q.add(null); 
                }
            }else{
                ans.add(curr.val);
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