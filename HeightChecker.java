// Daily Problem 10 june - HEIGHT CHECKER
// A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

// You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

// Return the number of indices where heights[i] != expected[i].

 

// Example 1:

// Input: heights = [1,1,4,2,1,3]
// Output: 3
// Explanation: 
// heights:  [1,1,4,2,1,3]
// expected: [1,1,1,2,3,4]
// Indices 2, 4, and 5 do not match.
// Example 2:

// Input: heights = [5,1,2,3,4]
// Output: 5
// Explanation:
// heights:  [5,1,2,3,4]
// expected: [1,2,3,4,5]
// All indices do not match.
// Example 3:

// Input: heights = [1,2,3,4,5]
// Output: 0
// Explanation:
// heights:  [1,2,3,4,5]
// expected: [1,2,3,4,5]
// All indices match.
 

// Constraints:

// 1 <= heights.length <= 100
// 1 <= heights[i] <= 100

import java.util.Arrays;

class HeightChecker {
    public int heightChecker(int[] heights) {
        if (heights == null || heights.length < 1 || heights.length > 100) {
            throw new IllegalArgumentException("Height array must have length between 1 and 100.");
        }

        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] < 1 || heights[i] > 100) {
                throw new IllegalArgumentException("Height values must be between 1 and 100.");
            }
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }
}
//My Raw code
// class Solution {
//     public int heightChecker(int[] heights) {
//        int n = heights.length;
//        if( n >= 1 && n<=100){
//        int[] expected = Arrays.copyOf(heights,n);
//        Arrays.sort(expected);
//        int count = 0;
//        for (int i =0 ; i < n ; i++){
//             if((heights[i] != expected[i]) && heights[i] <= 100 && heights[i] >= 1){
//                 count++;
//             }
//        }
//        return count;
       
//        }else{
//         return 0;
//        }
        
//     }
// }