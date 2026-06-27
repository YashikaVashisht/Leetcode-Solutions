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
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> levelmax= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int s= q.size();
            int levelsum=0;
            for(int i=0;i<s;i++){
                TreeNode curr= q.poll();
                levelsum+=curr.val;
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            levelmax.add(levelsum);
        }

        int s= levelmax.size();
        int maxi=Integer.MIN_VALUE;;
        int ans=-1;
        for(int i=0;i<s;i++){
            if(maxi<levelmax.get(i)){
                ans=i;
                maxi=levelmax.get(i);
            }
        }
        return ans+1;
    }
}