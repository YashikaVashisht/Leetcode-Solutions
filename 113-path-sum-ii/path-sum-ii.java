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
    public void dfs( TreeNode root, List<List<Integer>> ans, int tar , List<Integer> temp){

        if(root==null) return;

        temp.add(root.val);  

        if (root.left == null && root.right == null && tar==root.val) {
            ans.add(new ArrayList<>(temp)); 
        }

        dfs(root.left,ans,tar-root.val, temp);
        dfs(root.right,ans,tar-root.val, temp);

        temp.remove(temp.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        dfs(root,ans,target, temp);
        return ans;
    }
}