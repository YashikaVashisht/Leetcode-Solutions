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
    public TreeNode helper(TreeNode root, int val){
        TreeNode temp = new TreeNode(val);
        if(root == null) return temp;

        if(val > root.val){
            root.right= helper(root.right, val);
        }else{
           root.left= helper(root.left, val); 
        }
        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return helper(root, val);
    }
}