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
    public int sizef(ListNode head){
        int ret = 0;
        while(head != null){
            ret++;
            head = head.next;
            
        }
        return ret;
    }
    
    public boolean isPalindrome(ListNode head) {
        int size = sizef(head);
        int sin = size/2;
        Stack<Integer> st = new Stack<>();
        ListNode curr = head;
        boolean vis = false;
        while(curr != null){
            if(sin > 0){
                st.push(curr.val);
                sin--;
                curr = curr.next;
                continue;
            }
            if(size%2 != 0 && sin == 0 && !vis){
                vis = true;
                curr = curr.next;
                continue;
            }
            if(st.size() != 0){
                int rem = st.pop();
                if(curr.val != rem){
                    return false;
                }
            }
            curr = curr.next;
        }
        
        return true;
    }
}