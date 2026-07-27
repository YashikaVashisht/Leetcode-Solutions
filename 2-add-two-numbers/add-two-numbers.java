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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy= new ListNode(-1);
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode curr= dummy;
        int carry=0;
        while(temp1!=null || temp2!=null){
            int sum=carry;
            if(temp1!=null && temp2!=null){ //if both list exists
                sum += temp1.val+temp2.val;
                temp1=temp1.next;
                temp2=temp2.next;
            }else if(temp1==null && temp2!=null){ //if l2 is long 
                sum+=temp2.val;
                temp2=temp2.next;
            }else if(temp1!=null && temp2==null){//if l1 is long 
                sum+=temp1.val;
                temp1=temp1.next;
            }
                

            if(sum<10){
                curr.next=new ListNode(sum); 
                carry=0; //setting carry to 0
            }
            else{
                curr.next=new ListNode(sum%10);
                carry=sum/10;
            }
            curr=curr.next;
            
        }
        if(carry!=0){
            curr.next=new ListNode(carry);
        }

        return dummy.next;

    }
}