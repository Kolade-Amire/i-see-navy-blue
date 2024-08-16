package code;

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

{1 4 9 8 4 3 2 7 2 4 8 9 2}

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
import java.util.stream.IntStream;

class TwoSum {

    public static int[] twoSumBrute(int[] nums, int target) {
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                }
            }

        }
        return indices;
    }

    // 2.

    /**
     * So, if we fix one of the numbers, say x, we have to scan the entire array to find the next number y which is value - x where value is the input parameter. Can we change our array somehow so that this search becomes faster?
     */

    public static int[] twoSumSort(int[] nums, int target) {
        int[] indices = new int[2];
        int[] tempArray = nums.clone();
        int temp;
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = i + 1; j < tempArray.length; j++) {
                if (tempArray[i] > tempArray[j]) {
                    temp = tempArray[i];
                    tempArray[i] = tempArray[j];
                    tempArray[j] = temp;
                }
            }
        }

        int left = 0;
        int right = tempArray.length-1;
        while(left < right) {
            int sum = tempArray[left] + tempArray[right];
            if (sum == target){
                indices[0] = -1;
                indices[1] = -1;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == tempArray[left] && indices[0] == -1){
                        indices[0] = i;
                    } else if (nums[i] == tempArray[right] && indices[1] == -1) {
                        indices[1] = i;
                    }
                    if (indices[0] != -1 && indices[1] != -1) {
                        break;
                    }
                }
                return indices;
            } else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return null;
    }


    public static void main(String[] args) {
        int[] nums = {3,3}; //{2, 7, 11, 15}, {3,3}, {3,2,4}, {25,6,23,45,92,3,1,9,21,3}


//        IntStream result = Arrays.stream(nums).sorted();

//        System.out.println("sorted array 1: " + Arrays.toString(result.toArray()));
        System.out.println("indices: " + Arrays.toString(twoSumSort(nums, 6)));

    }
}
