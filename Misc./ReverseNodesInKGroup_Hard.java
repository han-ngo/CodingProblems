/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;    
        } 
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        reverseKGroupUtil(dummy, k);
        return dummy.next;
    }
    
    private void reverseKGroupUtil(ListNode head, int k) {
        ListNode target = head;
        ListNode prevHead = head.next;
        for (int i = 0; i < k; i++) {
            target = target.next;
            if (target == null) {
                return;
            }
        }
    
        target = target.next;
        ListNode temp = null;
        ListNode cur = head.next;
        for (int i = 0; i < k; i++) {
            temp = cur.next;
            cur.next = target;
            target = cur;
            cur = temp;      
        }
            
        head.next = target;

        reverseKGroupUtil(prevHead, k);
    }
}