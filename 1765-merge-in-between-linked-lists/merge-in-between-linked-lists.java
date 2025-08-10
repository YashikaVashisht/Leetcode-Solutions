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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp=list1;
        int i=0;
        while(i<a-1){
            temp=temp.next;
            i++;
        }
        ListNode firstEnd= temp;
        while(i<b){
            temp=temp.next;
            i++;
        }
        ListNode nextStart=temp.next;
        firstEnd.next=list2;// connecting the node to list2 head;

        ListNode curr= list2;
        while(curr.next!=null){
            curr=curr.next;
        }

        curr.next=nextStart;/// connecting end of list2 to list1
        return list1;
    }

}