//PROBLEM : CONTINUOUS SUBARRAY SUM
//  Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

// A good subarray is a subarray where:

// its length is at least two, and
// the sum of the elements of the subarray is a multiple of k.
// Note that:

// A subarray is a contiguous part of the array.
// An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 

// Example 1:

// Input: nums = [23,2,4,6,7], k = 6
// Output: true
// Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
// Example 2:

// Input: nums = [23,2,6,4,7], k = 6
// Output: true
// Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
// 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
// Example 3:

// Input: nums = [23,2,6,4,7], k = 13
// Output: false
 

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 109
// 0 <= sum(nums[i]) <= 231 - 1
// 1 <= k <= 231 - 1

// We can solve this problem using the following steps:
// Initialize a map remainderMap to store the remainder of the cumulative sum of the elements in the array.
// Initialize the cumulative sum of the elements in the array to 0.
// Initialize the remainder to 0.
// Iterate through the elements of the array:
// Calculate the cumulative sum by adding the current element to the cumulative sum.
// Calculate the remainder by taking the modulus of the cumulative sum with k.
// If the remainder is 0 and the cumulative sum is not 0, return true.
// If the remainder is present in the remainderMap, check if the segment length is at least two. If it is, return true.
// Otherwise, update the remainderMap with the remainder and its corresponding index.
// If no good subarray is found, return false.
// The time complexity of this approach is O(n), where n is the length of the input array nums.

// Let's implement the solution:


import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: Iterate Through Starting Points
        for (int start = 0; start < n - 1; start++) {
            // Step 2: Expand the Subarray
            for (int end = start + 1; end < n; end++) {
                // Step 3: Calculate the Sum
                int subarraySum = 0;
                for (int i = start; i <= end; i++) {
                    subarraySum += nums[i];
                }
                
                // Step 4: Check if the Sum is a Multiple of k
                if (subarraySum == 0 && k == 0) { // Handling special case where k is 0
                    return true;
                }
                if (k != 0 && subarraySum % k == 0) {
                    return true;
                }
            }
        }
        
        // Step 5: Return the Result
        return false;
    }

    class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> remainderMap = new HashMap<>();
        int cumulativeSum = 0;
        
        // Step 1: Initialize Remainder Map
        remainderMap.put(0, -1);
        
        // Step 2: Iterate Through the List
        for (int i = 0; i < n; i++) {
            // Step 3: Calculate Cumulative Sum
            cumulativeSum += nums[i];
            
            // Step 4: Calculate Remainder
            int remainder = k == 0 ? cumulativeSum : cumulativeSum % k;
            
            // Step 5: Update Remainder Map
            if (remainderMap.containsKey(remainder)) {
                // Check if segment length is at least two
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }
        
        // Step 6: Return the Result
        return false;
    }

    public static void main(String[] args) {
        CheckSubarraySum checkSubarraySum = new CheckSubarraySum();
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(checkSubarraySum.checkSubarraySum(nums, k));
}
}
}