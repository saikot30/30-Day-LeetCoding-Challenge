/*
 *	Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 *	Example 1:
 *
 *	Input: S = "ab#c", T = "ad#c"
 *	Output: true
 *	Explanation: Both S and T become "ac".
 *	
 *	Example 2:
 *
 *	Input: S = "ab##", T = "c#d#"
 *	Output: true
 *	Explanation: Both S and T become "".
 *	
 *	Example 3:
 *
 *	Input: S = "a##c", T = "#a#c"
 *	Output: true
 *	Explanation: Both S and T become "c".
 *	
 *	Example 4:
 *
 *	Input: S = "a#c", T = "b"
 *	Output: false
 *	Explanation: S becomes "c" while T becomes "b".
 *	
 *	Note:
 *
 *	1 <= S.length <= 200
 *	1 <= T.length <= 200
 *	S and T only contain lowercase letters and '#' characters.
 *	Follow up:
 *
 *	Can you solve it in O(N) time and O(1) space?
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder src = new StringBuilder();
        StringBuilder test = new StringBuilder();
        int s_count = 0, t_count = 0;
        for(int i=S.length()-1; i>=0; i--) {
            if(S.charAt(i) == '#') {
                s_count++;
            } else if(s_count != 0) {
                s_count--;
            } else {
                src.append(S.charAt(i));
            }
        }
        
        for(int i=T.length()-1; i>=0; i--) {
            if(T.charAt(i) == '#') {
                t_count++;
            } else if(t_count != 0) {
                t_count--;
            } else {
                test.append(T.charAt(i));
            }
        }
        
        return src.toString().equals(test.toString());
    }
}