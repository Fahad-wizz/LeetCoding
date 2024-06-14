//DAILY CHALLENGE You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

// Return the minimum number of moves to make every value in nums unique.

// The test cases are generated so that the answer fits in a 32-bit integer.

 

// Example 1:

// Input: nums = [1,2,2]
// Output: 1
// Explanation: After 1 move, the array could be [1, 2, 3].
// Example 2:

// Input: nums = [3,2,1,2,1,7]
// Output: 6
// Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
// It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 105
// We can sort the array and then iterate over the array and check if the current element is greater than or equal to the next element. If it is then we increment the next element by 1 and add the difference between the next element and the current element to the minInc variable. If the current element is less than the next element then we update the next element to the current element + 1. We continue this process until we reach the end of the array. Finally, we return the minInc variable which contains the minimum number of moves to make every value in nums unique.
// Time complexity: O(nlogn) where n is the length of the array nums.
// Space complexity: O(1)

import java.util.Arrays;
class MinIncrementInArray {
    public int minIncrementForUnique(int[] nums) {
        
        Arrays.sort(nums);
        int minInc = 0;
        int nxt = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            if (nxt >= nums[i]) {
                minInc += (nxt++ - nums[i]);
            } else {
                nxt = nums[i] + 1;
            }
        }
        return minInc;
    }

    public static void main(String[] args) {
        MinIncrementInArray obj = new MinIncrementInArray();
        int[] nums = {3,2,1,2,1,7};
        System.out.println(obj.minIncrementForUnique(nums));
        int[] nums1 = {1,2,2};
        System.out.println(obj.minIncrementForUnique(nums1));
        int [] nums2 = {1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
        System.out.println(obj.minIncrementForUnique(nums2));
    }
}
// Runtime 286 ms

// class Solution {

//     public int minIncrementForUnique(int[] nums) {
//         int n = nums.length;
//         int max = 0;
//         int minIncrements = 0;

//         // Find maximum value in array to determine range of frequencyCount array
//         for (int val : nums) {
//             max = Math.max(max, val);
//         }

//         // Create a frequencyCount array to store the frequency of each value in nums
//         int[] frequencyCount = new int[n + max];

//         // Populate frequencyCount array with the frequency of each value in nums
//         for (int val : nums) {
//             frequencyCount[val]++;
//         }

//         // Iterate over the frequencyCount array to make all values unique
//         for (int i = 0; i < frequencyCount.length; i++) {
//             if (frequencyCount[i] <= 1) continue;

//             // Determine excess occurrences, carry them over to the next value,
//             // ensure single occurrence for current value, and update minIncrements.
//             int duplicates = frequencyCount[i] - 1;
//             frequencyCount[i + 1] += duplicates;
//             frequencyCount[i] = 1;
//             minIncrements += duplicates;
//         }

//         return minIncrements;
//     }
// }

// Runtime 6 ms