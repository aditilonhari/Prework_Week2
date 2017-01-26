/*
Problem Statement : For Given Number N find if its COLORFUL number or not. Return 0/1. 

COLORFUL number:
A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
*/

public class Solution {
	public int colorful(int a) {
	    
	    ArrayList<Integer> array = new ArrayList<>();
	    while(a>0){
	        array.add(a%10);
	        a = a/10;
	    }
	    
	    Collections.reverse(array);
	    
	    boolean duplicate = false;
	    HashSet<Integer> my_set = new HashSet<>();
	    for(int i=0; i<array.size(); i++){
	        int currentElement = array.get(i);
	        if(!my_set.contains(currentElement))
	            my_set.add(currentElement);
	        else {
	            duplicate = true;
	            break;
	        }
	        
	        int sum = currentElement;
	        for(int j=i+1; j<array.size(); j++){
	            sum = sum * array.get(j);
	            if(!my_set.contains(sum))
	                my_set.add(sum);
    	        else {
    	            duplicate = true;
    	            break;
    	        }
	        }
	    }
	    
	    if(duplicate)
	        return 0;
	        
	    return 1;
	}
}

