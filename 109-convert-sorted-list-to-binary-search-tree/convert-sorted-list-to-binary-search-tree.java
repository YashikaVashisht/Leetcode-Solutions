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
    public TreeNode helper(int l ,int r, ArrayList<Integer> val ){  
        if(l>r) return null;
        int mid= (l+r)/2;
        TreeNode node= new TreeNode(val.get(mid));
        node.left= helper(l,mid-1, val);
        node.right= helper(mid+1, r, val);
        
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp=head;
        // int size=1;
        ArrayList<Integer> val= new ArrayList<>();
        while(temp!=null){
            val.add(temp.val);
            // size++;
            temp=temp.next;
        }
        int l= 0;
        int r=val.size()-1;
        // int mid=(l+r)/2;
        // TreeNode root= new TreeNode(val.get(mid));
        // root.left= helper(l,mid-1, val);
        // root.right= helper(mid+1, r, val);
        return helper(l,r,val);
        
    }
}