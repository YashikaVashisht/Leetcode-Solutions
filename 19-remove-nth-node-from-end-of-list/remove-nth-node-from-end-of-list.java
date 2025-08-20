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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp= head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        if(len==n){
            head=head.next;
            return head;
        }
        int index=len-n;
        int i=0;
        ListNode prev=head;
        while(i+1<index){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;

        return head;

    }
}