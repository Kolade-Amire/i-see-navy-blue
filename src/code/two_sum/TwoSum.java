package code.two_sum;

/* QUESTION COPIED FROM LEETCODE (https://leetcode.com/problems/two-sum/)
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

 */



import java.util.Arrays;

class TwoSum {

    public static int[] twoSum (int [] nums, int target){
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+ nums[j] == target){
                    indices[0] = i;
                    indices[1] = j;
                }
            }

        }
    return indices;
    }

    public static void main(String[] args) {
        int[] nums = {3,3}; //{2, 7, 11, 15}, {3,3}
        int[] result = twoSum(nums, 6);
        System.out.println(Arrays.toString(result));
    }
}
