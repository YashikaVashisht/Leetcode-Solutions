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
class Tuple{
    int sum;
    boolean flag;
    int lmax;
    int rmin;

    Tuple(){
        sum=0;
        flag=true; // to check if BST or not
        lmax=Integer.MIN_VALUE;
        rmin=Integer.MAX_VALUE;
    }

}
class Solution {
    int max= 0;
    
    public Tuple helper(TreeNode root){
        if(root== null) return new Tuple();
        Tuple left=helper(root.left);
        Tuple right=helper(root.right);

        Tuple temp= new Tuple();
        if(left.flag== true && right.flag== true && root.val> left.lmax && root.val <right.rmin){
            temp.sum= root.val+ left.sum+right.sum;
            temp.flag= true;
            temp.lmax=Math.max(root.val, right.lmax);
            temp.rmin=Math.min(root.val, left.rmin);

            max=Math.max(max, temp.sum);

        }else{
            temp.sum=0;
            temp.flag=false;
            temp.lmax=Integer.MAX_VALUE;
            temp.rmin=Integer.MIN_VALUE;
        }
        return temp;

    }
        
    
    public int maxSumBST(TreeNode root) {
        helper(root);
        return max;
    }
}