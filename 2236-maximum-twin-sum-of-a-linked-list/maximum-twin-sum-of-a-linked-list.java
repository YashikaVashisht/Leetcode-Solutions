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
    public ListNode reverse(ListNode node){
        ListNode curr= node;
        ListNode prev= null;
        ListNode next;
        while(curr!= null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr= next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        while(fast!= null &&fast.next!= null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead= reverse(slow);
        slow=head;

        int max=Integer.MIN_VALUE;
        while(newHead!= null){
            int sum= newHead.val+slow.val;
            max= Math.max(max, sum);
            slow=slow.next;
            newHead=newHead.next;
        }

        return max;

    }
}