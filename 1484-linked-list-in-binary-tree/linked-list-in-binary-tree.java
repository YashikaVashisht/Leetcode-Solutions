/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean helper(TreeNode root, ListNode node){
        
        if(node==null) return true;
        if(root==null) return false;

        if(root.val== node.val){
            boolean left=helper(root.left, node.next);
            boolean right= helper(root.right, node.next);
            return left || right;
        }
        return false;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null) return false;
        return helper(root,head) || isSubPath(head, root.left) || isSubPath(head,root.right);
        // helper(root.left,head) || helper(root.right,head);
        
    }
}