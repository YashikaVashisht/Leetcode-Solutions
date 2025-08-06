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
    public static int euclid_gcd(int a ,int b){
        if(b==0) return a;
        else{
            return euclid_gcd(b,a%b);
        }
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp=head;
        ListNode later=temp.next;
        while(later!=null){
            int val=euclid_gcd(temp.val, later.val);
            ListNode gcd= new ListNode(val);
            gcd.next=later;
            temp.next=gcd;

            ListNode baad= later.next;
            temp=later;
            later=baad;
        }
        return head;

        
    }
}