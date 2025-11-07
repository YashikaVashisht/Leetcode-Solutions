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
    public void inorder(TreeNode root, ArrayList<TreeNode> l){
        if(root==null) return;
        inorder(root.left,l);
        l.add(root);
        inorder(root.right,l);
    }
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<TreeNode> l= new ArrayList<>();
        inorder(root,l);

        if (l.size() == 0) return null;
        TreeNode newRoot= l.get(0);
        TreeNode curr=newRoot;
        for(int i=1;i<l.size();i++){
            curr.left=null;
            curr.right=l.get(i);
            curr=curr.right;
        }
        
        //leaf node
        curr.left=null;
        curr.right=null;
        return newRoot;
    }
}