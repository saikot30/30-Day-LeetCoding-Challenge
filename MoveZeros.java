/*
 *	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 *	Example:
 *	Input: [0,1,0,3,12]
 *	Output: [1,3,12,0,0]
 *	
 *	Note:
 *	You must do this in-place without making a copy of the array.
 *	Minimize the total number of operations.
 */



class Solution {
    public void moveZeroes(int[] nums) {
        int zero_index = 0;
        int i = 0;
        if(nums.length == 1 && nums[0] != 0) return;
        while(i < nums.length) {
            
            if(nums[i] != 0 && nums[zero_index] == 0) {
                swap(nums, i, zero_index);
                //zero_index++;
            }
            if(nums[zero_index] != 0) zero_index++;
            i++;
        }
    }
    
    public static void swap(int [] nums, int i, int zero_index) {
        int temp = nums[i];
        nums[i] = nums[zero_index];
        nums[zero_index] = temp;
    }
}