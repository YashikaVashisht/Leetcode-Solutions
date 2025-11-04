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


    // public void dfs(TreeNode root){
    //     // if(root==null) return;
    //     // int left=0;
    //     // if(root.left!=null){
    //     //     left=Math.abs(root.val-root.left.val);
    //     // }
    //     // int right=0;
    //     // if(root.right!=null){
    //     //     right=Math.abs(root.val-root.right.val);
    //     // }
    //     // min=Math.min(min, Math.min(left,right));

    //     // dfs(root.left);
    //     // dfs(root.right);
        
    // }


    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }
}