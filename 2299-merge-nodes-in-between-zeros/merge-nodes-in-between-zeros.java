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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tail=dummy;
        ListNode temp= head.next; //skipiing first zero node
        int sum=0;
        while(temp!=null){
            if(temp.val==0){
                tail.next = new ListNode(sum); // creating new node 
                tail=tail.next;
                sum=0; //setting sum=0 again for next range
            }else{
                sum+=temp.val;
            }
            temp=temp.next;
        }
        return dummy.next;
    }

}