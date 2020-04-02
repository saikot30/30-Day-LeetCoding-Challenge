/*
 * 	Write an algorithm to determine if a number is "happy".
 *	A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares 
 *	of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 *	Those numbers for which this process ends in 1 are happy numbers.
 *
 *	Example: 
 *
 *	Input: 19
 *	Output: true
 *	Explanation: 
 *	1^2 + 9^2 = 82
 *	8^2 + 2^2 = 68
 *	6^2 + 8^2 = 100
 *	1^2 + 0^2 + 0^2 = 1
 */


class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<Integer>();
        boolean flag = true;
        int total = 0;
        
        while(n != 1) {
            int temp = n;
            while(temp > 0) {
                int number = temp % 10;
                temp /= 10;
                total += number * number;
            }
            
            if(hs.contains(total)) {
                flag = false;
                break;
            } else {
                hs.add(total);
                n = total;
                total = 0;
            }
            
        }
        
        return flag;
    }
}