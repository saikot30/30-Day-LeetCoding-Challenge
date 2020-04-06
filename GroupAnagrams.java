/*
 *	Given an array of strings, group anagrams together.
 *	Example:
 *
 *	Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *	Output:
 *	[
 *  	["ate","eat","tea"],
 *  	["nat","tan"],
 *  	["bat"]
 *	]
 *	Note:
 *
 *	All inputs will be in lowercase.
 *	The order of your output does not matter.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i=0; i<strs.length; i++) {
            char [] temporary_array = strs[i].toCharArray();
            Arrays.sort(temporary_array);
            String temporary_string = new String(temporary_array);
            
            if(map.get(temporary_string) == null) {
                List<String> str = new ArrayList<String>();
                str.add(strs[i]);
                map.put(temporary_string,str);
            } else {
                List<String> str = map.get(temporary_string);
                str.add(strs[i]);
                map.put(temporary_string, str);
            }
        }
        
        for(String s : map.keySet()) {
            result.add(map.get(s));
        }
        
        return result;
    }
}