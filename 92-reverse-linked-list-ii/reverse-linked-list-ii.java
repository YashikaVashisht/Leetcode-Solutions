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

    public ListNode reverse(ListNode start, ListNode end){
        ListNode curr=start;
        ListNode prev=null;
        ListNode stop=end.next;
        while(curr!=stop){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;

    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy= new ListNode(0);
        dummy.next=head;
        
        ListNode prevEnd=dummy;
        int i=1;
        while(i<left){
            prevEnd=prevEnd.next;
            i++;
        }
        
        ListNode newEnd=prevEnd.next;
        ListNode end= newEnd;
        while(i<right){
            end=end.next;
            i++;
        }

        ListNode  nextStart=end.next;
        ListNode newHead=reverse(newEnd, end);
        
        prevEnd.next=newHead;
        newEnd.next=nextStart;

        return dummy.next;

    }
}