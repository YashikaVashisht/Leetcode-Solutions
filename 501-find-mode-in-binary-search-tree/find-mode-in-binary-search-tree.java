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
    public void inorder( TreeNode root, HashMap<Integer, Integer> hm ){
        if(root==null) return;

        inorder(root.left, hm);
        hm.put(root.val , hm.getOrDefault(root.val,0)+1);
        inorder(root.right, hm);
    }
    public int[] findMode(TreeNode root) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        inorder(root, hm);

        int max = 0;
        for(int freq : hm.values()){
            max = Math.max(max, freq);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int key : hm.keySet()){
            if(hm.get(key) == max){
                list.add(key);
            }
        }

        int[] ans = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            ans[i]=list.get(i);
        }

        return ans;
    }
}