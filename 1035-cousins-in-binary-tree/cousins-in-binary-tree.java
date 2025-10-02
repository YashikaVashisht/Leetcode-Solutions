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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int level=0;

        int lx=-1;
        int ly=-1;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                TreeNode curr= q.poll();
                
                if(curr.left!=null && curr.right!=null){ // siblings case
                    if((curr.left.val==x && curr.right.val==y) 
                    || (curr.left.val==y && curr.right.val==x)){
                        return false;

                    }    
                } 


                if(curr.val==x){
                    lx=level;
                }
                if(curr.val==y){
                    ly=level;
                }

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            level++;
        }
        if(lx==ly) return true;
        else return false;
   }
}