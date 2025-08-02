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
 
    public static int dfs(TreeNode root, int d){
        if(root==null) {
            return Integer.MAX_VALUE;
        }   

        if(root.left==null && root.right==null){
            return d;
        }

        int left=dfs(root.left,d+1);
        int right= dfs(root.right,d+1);
        return Math.min(left,right);

    }
    public int minDepth(TreeNode root) {
        if(root== null) return 0;
        int d=1;
        return dfs(root,d);
    }
}