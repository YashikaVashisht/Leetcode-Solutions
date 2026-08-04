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
    int res=0;
    public int sum(TreeNode root  ){
        if(root==null) return 0;
        
        int left= sum(root.left );
        int right= sum(root.right);
        return root.val + left+ right;

    }
    public int count(TreeNode root  ){
        if(root==null) return 0;
        
        int left= count(root.left );
        int right= count(root.right);
        return 1 + left+ right;

    }
    public void helper(TreeNode root){
        if(root==null) return ;
        int s= sum(root);
        int n= count(root);

        if(root.val == (s/n)){
            res++;
        }
        helper(root.left);
        helper(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return res;
    }
}