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
    ListNode before_tail=null;
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        head.next=partition(head.next,x);
        if(before_tail==null){
            if(head.val<x) before_tail=head;
            return head;
        }else{
            if(head.val>=x){
                ListNode next=head.next;
                head.next=before_tail.next;
                head.next=before_tail.next;
                before_tail.next=head;
                return next;
            }else return head;
        }
    }
}