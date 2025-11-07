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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len=0;
        ListNode curr=head;
        ListNode[] res = new ListNode[k];
        while(curr!=null){
            len++;
            curr=curr.next;
        }

        int split_size= len/k;
        int extra= len%k;

        int i=0;
        curr=head;
        while(i<k&&curr!=null){
            res[i]=curr;
            int addon=split_size;
            if(extra>0) {
                addon++;
                extra--;
            }   
            for(int j=1;j<addon && curr!=null ;j++){
                curr=curr.next;
            }
            if(curr!=null) {
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
            i++;
        }
        return res;
    }
}