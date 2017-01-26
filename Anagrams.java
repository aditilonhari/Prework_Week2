/*
Problem Statement : Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. 
*/

public class Solution {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    
	    if(a.size() == 0)
	        return null;
	        
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    
	    if(a.size() == 1){
	        result.add(new ArrayList(Arrays.asList(1)));
	        return result;
	    }
	    
	    int size = a.size();
	    HashMap<String, ArrayList<Integer>> list = new HashMap<>();
	    for(int i=0; i<size; i++){
	        String original = a.get(i);
            char[] chars = original.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            ArrayList<Integer> temp = new ArrayList<>();
            
	        if(list.containsKey(sorted)){
	            temp = list.get(sorted);
	            temp.add(i+1);
	            list.put(sorted,temp);
	        }
	        else {
	            temp.add(i+1);
	            list.put(sorted,temp);
	        }
	    }
	   
        // Iterating over values only
        for (ArrayList<Integer> value : list.values()) {
            result.add(value);
        }
        
	    return result;
	}
}

