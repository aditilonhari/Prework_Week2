/*
Problem Statement : Reverse a linked list from position m to n. Do it in-place and in one-pass.
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
	public ListNode reverseBetween(ListNode a, int m, int n) {
	    
	    if(a == null)
	        return a;
	    
	    ListNode prevNode = null;
	    ListNode startNode = null;
	    ListNode endNode = null;
	    boolean prevSet = false;
	    
	    int index = 0;
	    ListNode currentNode = a;
	    while(currentNode != null){
	        if(index == 0 && index == (m-1)){
	            startNode = currentNode;
	            prevNode = new ListNode(-1);
	            prevNode.next = startNode;
	            prevSet = true;
	        }
	        
	        if((index+1) == (m-1)){
	            prevNode = currentNode;
	            startNode = currentNode.next;
	            prevSet = true;
	        }
	        
	        if(prevSet && index == (n-1)){
	            endNode = currentNode;
	            break;
	        }
	        
	        index++;
	        currentNode = currentNode.next;
	    }
	   
	    
	    while(startNode.val != endNode.val){
	        ListNode currentEndNext = endNode.next;
	        ListNode currentStartNext = startNode.next;
	        
	        
	        endNode.next = startNode;
	        startNode.next = currentEndNext;
	        
	        startNode = currentStartNext;
	        prevNode.next = startNode;
	    }
	    
	    if(prevNode.val == -1){
	        a = startNode;
	    }
	    
	    return a;
	}
}

