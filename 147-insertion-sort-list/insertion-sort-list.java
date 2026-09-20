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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy= new ListNode(Integer.MIN_VALUE);
        dummy.next=head;

        int last= Integer.MIN_VALUE;
        ListNode prev= dummy;
        ListNode curr=head;

        while(curr!=null){
            if(curr.val >= last) { //if already sorted
                last=curr.val;
                prev=curr;
                curr=curr.next;
                continue;
            }

            ListNode pos= dummy;
            while(pos.next != null && curr.val >= pos.next.val){
                pos=pos.next;
            }

            prev.next=curr.next;
            curr.next=pos.next;
            pos.next=curr;
            curr =prev.next;
        }
        return dummy.next;
    }
}