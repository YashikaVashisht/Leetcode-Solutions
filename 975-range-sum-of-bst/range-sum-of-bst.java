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
    int total;
    public int helper(TreeNode root, int l, int h){
        if(root==null) return 0;
        if(root.val >= l && root.val <=h){
            total+=root.val;
        }
        int left= helper(root.left, l ,h);
        int right= helper(root.right, l ,h);
        return total;

    }
    public int rangeSumBST(TreeNode root, int l, int h) {
        total=0;
        return helper(root,l,h);
    }
}