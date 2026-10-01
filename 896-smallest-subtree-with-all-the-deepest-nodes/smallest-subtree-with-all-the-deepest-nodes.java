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
    class Pair{
        TreeNode node;
        int depth;
        Pair(TreeNode node , int depth){
            this.node= node;
            this.depth=depth;
        }
    }
    public Pair helper(TreeNode root){
        if(root == null) return new Pair(null, 0);

        Pair left =helper(root.left);
        Pair right =helper(root.right);

        if(left.depth == right.depth){
            return new Pair(root, left.depth + 1);
        }
        if(left.depth > right.depth){
            return new Pair(left.node, left.depth+1);
        }

        return new Pair(right.node, right.depth+1);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).node;
    }
}