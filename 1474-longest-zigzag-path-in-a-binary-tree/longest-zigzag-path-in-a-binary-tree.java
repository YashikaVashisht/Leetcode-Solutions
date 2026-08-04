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
    int ans =0;
    public void helper(TreeNode root, boolean fromLeft, int len){
        if(root==null) return;
        ans=  Math.max(ans, len);

        if(fromLeft){ //if came from left then 
            helper(root.right, false, len+1); // it should go to right with +1

            //or restrt from the left
            helper(root.left, true, 1);
        }else{
            helper( root.left, true, len+1);// add on
            helper(root.right, false, 1); //restrt 
        }
    }
    public int longestZigZag(TreeNode root) {
        if(root==null) return 0;

        helper(root.left, true, 1);
        helper(root.right, false, 1);

        return ans;
    }
}