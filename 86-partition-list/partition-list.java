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
    public ListNode partition(ListNode head, int x) {
        ListNode curr=head;
        ArrayList<Integer> small= new ArrayList<>();
        ArrayList<Integer> large= new ArrayList<>();
        while(curr!=null){
            if(curr.val>=x){
                large.add(curr.val);
            }else{
                small.add(curr.val);
            }
            curr=curr.next;
        }

        curr=head;
        int i=0;
        while(curr!=null && i< small.size()){
            curr.val=small.get(i);
            i++;
            curr=curr.next;
        }
        i=0;
        while(curr!=null && i< large.size()){
            curr.val=large.get(i);
            i++;
            curr=curr.next;
        }
        return head;
    }
}