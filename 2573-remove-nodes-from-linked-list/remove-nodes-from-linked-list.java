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
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> l=new ArrayList<>();
        ArrayList<Integer> store=new ArrayList<>();
        ListNode temp= head;
        while(temp!=null){
            l.add(temp.val);
            temp=temp.next;
        }
        Collections.reverse(l);
        
        int maxSoFar = Integer.MIN_VALUE;
        for (int val : l) {
            if (val >= maxSoFar) {
                store.add(val);
                maxSoFar = val;
            }
        }
        Collections.reverse(store);
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        for(int val:store) {
            curr.next=new ListNode(val);
            curr=curr.next;
        }

        return dummy.next;


    }
}