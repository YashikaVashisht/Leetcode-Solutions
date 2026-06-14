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
class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode findmid(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null &&fast.next!=null){
            slow=slow.next; 
            fast=fast.next.next;
        }
        return slow;
    }
    public int pairSum(ListNode head) {
        ListNode temp=head;
        ListNode mid=findmid(temp); //will get the mid 
        ListNode reversedhead= reverse(mid); //reverse the right half 

        int max= 0;
        while(temp!=mid){
            int sum= temp.val+ reversedhead.val;
            max=Math.max(max, sum);
            temp=temp.next;
            reversedhead=reversedhead.next;
        }
        return max;
    }
}