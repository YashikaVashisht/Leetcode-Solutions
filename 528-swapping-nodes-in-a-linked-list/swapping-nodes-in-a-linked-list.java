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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode forsize=head;
        int len=0;
        while(forsize!=null){
            forsize=forsize.next;
            len++;
        }

        ListNode first=head;
        for(int i=1; i<k;i++) {  
            first=first.next;
        }

      
        ListNode second=head;
        int endPos=len-k+1;
        for (int i=1; i<endPos;i++) { 
            second=second.next;
        }

        int tempVal=first.val;
        first.val=second.val;
        second.val=tempVal;

        return head;

        



    }
}