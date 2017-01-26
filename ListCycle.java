/*
Problem Statement : Given a linked list, return the node where the cycle begins. If there is no cycle, return null. Try solving it using constant additional space.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode a) {
	    
	    if(a == null || a.next == null)
	        return a;
	        
	    ListNode slow = a;
	    ListNode fast = a.next.next;
	    
	    while(slow != fast && fast != null){
	        
	        slow = slow.next;
	        fast = fast.next;
	        if(fast != null)
	            fast = fast.next;
	    }
	    
	    if(fast == null)
	        return null;
	    
	    
	    if(slow == fast){
	        int k =1;
	        while(slow.next != fast){
	            slow = slow.next;
	            k++;
	        }
 
            // Fix one pointer to head
            fast = a;
     
            // And the other pointer to k nodes after head
            slow = a;
            for (int i = 0; i < k; i++) {
                slow = slow.next;
            }
     
            /*  Move both pointers at the same pace,
             they will meet at loop starting node */
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
      
    	     return slow;
	        
	    }
	    
	    return null;
	}
}

