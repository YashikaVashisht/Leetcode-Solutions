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
    int size=0;
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;
        while(curr!=null){
            next= curr.next;
            curr.next=prev;
            prev= curr;
            curr= next;
            size++;
        }
        return prev;

    }
    public int[] nextLargerNodes(ListNode head) {
        ListNode newhead= reverse(head);
        Stack<Integer> st= new Stack<>();
        int[] ans= new int[size];
        int index= size-1;
        while(newhead != null){
            while (!st.isEmpty() && st.peek() <= newhead.val) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[index] = st.peek(); 
            } else {
                ans[index] = 0; 
            }

            st.push(newhead.val);
            newhead = newhead.next;
            index--;
        }
        return ans;

    }
}