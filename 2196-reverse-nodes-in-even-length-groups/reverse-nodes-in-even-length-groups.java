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

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy= new ListNode(0);
        dummy.next=head; // 0->head
        ListNode curr= head;
        ListNode prev=dummy;

        int groupSize=1;
        while(curr!= null){
            ListNode start=curr;
            int count=0;
            while(count<groupSize && curr!=null){
                curr=curr.next;
                count++;
            }

            if(count%2==0){
                ListNode temp=start;
                for(int i=1;i<count;i++){
                    temp=temp.next;
                }
                ListNode nextHead= temp.next;
                temp.next=null;
                ListNode newHead= reverse(start);
                prev.next=newHead;
                start.next= nextHead;
                prev=start;            
                curr=nextHead; 

            }else{
                for(int i=0;i<count; i++){
                    prev=prev.next;
                }
            }
            
            groupSize++;
        }
        return dummy.next;
    }
}