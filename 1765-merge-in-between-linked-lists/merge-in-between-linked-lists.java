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
        ListNode temp= list1;
        ListNode prev_a=null;
        ListNode next_b= null;
        int i=1;
        while(temp!=null){
            if(i==a){
                prev_a=temp;
            }
            if(i==b+2 && temp!=null){
                next_b=temp;
            }
            i++;
            temp=temp.next;
        }

        temp= list2; // finding the last node of list2
        while(temp.next!=null){
            temp=temp.next;
        }
        prev_a.next=list2;
        temp.next=next_b;

        return list1;

    }
}