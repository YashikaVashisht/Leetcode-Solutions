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
        ListNode temp= head;
        ListNode moving= head.next;
        int sum=0;
        while (moving != null) {
            if (moving.val == 0) {
                temp.val = sum;     
                if (moving.next != null) {
                    temp.next = moving; 
                    temp = temp.next;
                }
                sum = 0;
            } else {
                sum += moving.val;
            }
            moving = moving.next;
        }
        temp.next=null;
        return head;
    }
}