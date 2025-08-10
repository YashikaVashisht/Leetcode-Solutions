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
    public void reorderList(ListNode head) {
        ArrayList<Integer> store= new ArrayList<>();
        ListNode slow= head;
        ListNode fast= head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;
        while(temp!=null){
            store.add(temp.val);
            temp=temp.next;
        }
        slow.next=null;

        Collections.reverse(store);
        ListNode curr=head;
      
        int i=0;
        while(curr!=null && i< store.size()){
            ListNode nayi=new ListNode(store.get(i));
            nayi.next=curr.next;
            curr.next=nayi;
            curr=curr.next.next;
            i++;
        }
        


    }
}