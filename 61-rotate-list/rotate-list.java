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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode temp=head;
        int len=1;
        while(temp.next!=null){
            temp=temp.next;
            len++;
        }

        k=k%len;
        if(k==0) return head;
        int nth= len-k-1;

        int i=0;
        temp.next=head; //make it circular ll
        ListNode curr= head;
        while(i<nth){
            curr=curr.next;
            i++;
        }
        ListNode newHead=curr.next;
        curr.next=null;
       
       return newHead;
    }
}