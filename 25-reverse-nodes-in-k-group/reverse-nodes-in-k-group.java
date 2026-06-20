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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr= head;
        ListNode prev=dummy;
        
        while(curr!=null){
            ListNode start=curr;
            int count=0;
            while(count<k && curr!=null){
                count++;
                curr=curr.next;
            }
            if(count < k){ // if remaining nodes lest than K 
                prev.next = start;
                break;
            }
            
            ListNode temp=start;
            //ListNode prevEnd= prev;
            for(int i=1;i<k;i++){
                temp=temp.next;
            }
            //unlinking and relinking
            ListNode nextHead= temp.next;
            temp.next=null;
            ListNode newHead= reverse(start);
            prev.next= newHead;
            start.next= nextHead;

            prev=start;// NEW kth groyp
            curr=nextHead;

                
            
        }
        return dummy.next;
    }
}