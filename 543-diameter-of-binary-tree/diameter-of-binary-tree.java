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
    int maxi=0 ;
    public int helper( TreeNode root){
        if(root== null) return 0;
        int lefty= helper(root.left);
        int righty= helper(root.right);
        maxi= Math.max(maxi , lefty+ righty);
        return 1+ Math.max(lefty , righty);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
         helper( root);
         return maxi;
        
    }
}