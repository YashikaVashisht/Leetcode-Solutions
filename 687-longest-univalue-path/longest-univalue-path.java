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
    int total = 0;
    public int helper(TreeNode root){
        if(root== null)
           return 0;
        
        int left= helper(root.left);
        int right =helper(root.right);

        int leftPath=0;
        int rightPath=0;

        if(root.left!=null && root.left.val==root.val){
            leftPath= 1+ left;
        }
        if(root.right!=null && root.right.val==root.val){
            rightPath= 1+ right;
        }

        total= Math.max(total ,leftPath + rightPath);
        return Math.max(leftPath , rightPath);
    }
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return total;
    }
}