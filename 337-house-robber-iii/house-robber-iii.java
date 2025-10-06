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
    private int[] helper(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = helper(node.left);
        int[] right = helper(node.right);
        
        int rob = node.val + left[0] + right[0]; 
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); 
        
        return new int[]{notRob, rob};
    }
    public int rob(TreeNode root) {
        int[] res= helper(root);
        return Math.max(res[0], res[1]);
    }
}