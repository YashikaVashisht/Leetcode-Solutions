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
    public boolean isEvenOddTree(TreeNode root) {
        boolean res=true;
        int level=0;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int s= q.size();
            int prev = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for(int i=0;i<s;i++){
                TreeNode curr= q.poll();
                if(level%2==0){// even level

                    if(curr.val%2==0 || curr.val<=prev) {
                        return false;
                    }
                }else { // odd level
                    if (curr.val%2!=0 || curr.val>=prev) {
                        return false;
                    }
                }
                prev = curr.val;
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            level++;
        }
        if(res==false) return false;
        else return true;

    }
}