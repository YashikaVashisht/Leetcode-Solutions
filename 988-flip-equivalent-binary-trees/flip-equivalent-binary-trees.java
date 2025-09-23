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
    public void flip(TreeNode root){
        TreeNode temp=root.left;
        root.left= root.right;
        root.right=temp;

    }
    public boolean helper(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        if (helper(root1.left, root2.left) && helper(root1.right, root2.right)) {
            return true;
        }

        
        flip(root1);
        boolean result = helper(root1.left, root2.left) && helper(root1.right, root2.right);
        flip(root1);

        return result;

        
        
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return helper(root1,root2);
    }
}