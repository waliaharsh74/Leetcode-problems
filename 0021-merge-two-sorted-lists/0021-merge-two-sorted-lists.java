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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode a=list1;
        ListNode b=list2;
        if(a==null)return b;
        if(b==null)return a;
        ListNode tail;
        if(a.val>b.val){
            head=b;
            tail=b;
            b=b.next;
            
        }
        else{
            head=a;
            tail=a;
            a=a.next;
            
        }
        while(a!=null && b!=null){
            if(a.val>b.val){
                tail.next= b;
                tail=b;
                b=b.next;
            }
            else{
                tail.next=a;
                tail=a;
                a=a.next;
                
            }
            
           
            
        }
        if(a==null)tail.next= b;
        if(b==null)tail.next= a;
        
        return head;
        
    }
}