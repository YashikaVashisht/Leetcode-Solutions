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
    long maxi = -1;
    long sum = 0;
    long M = 1000000007;
 
    public void totalSum(TreeNode root) {
        if (root == null)
            return;
        sum += root.val;
        totalSum(root.left);
        totalSum(root.right);
    }
 
    public long helper(TreeNode root) {
        if (root == null)
            return 0;
 
        long L = helper(root.left);
        long R = helper(root.right);
 
        if (root.left != null) {
            long sum1 = (sum - L) * L;  
            maxi = Math.max(maxi, sum1);
        }
 
        if (root.right != null) {
            long sum2 = (sum - R) * R;
            maxi = Math.max(maxi, sum2);
        }
 
        return L + R + root.val;
    }
 
    public int maxProduct(TreeNode root) {
        totalSum(root);
        helper(root);
        return (int) (maxi % M);  
    }
}