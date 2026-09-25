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
    public TreeNode helper(int l , int r, int[] nums){
        if(l>r) return null;

        int max=l;
        for(int i=l ;i<=r;i++){
            if(nums[i]>nums[max]){
                max =i; // index 
            }
        }

        TreeNode root= new TreeNode(nums[max]);
        root.left= helper(l,max-1, nums );
        root.right= helper(max+1, r, nums);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(0,nums.length-1, nums);
    }
}