// You are given an integer array bloomDay, an integer m and an integer k.

// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

 

// Example 1:

// Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
// Output: 3
// Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
// We need 3 bouquets each should contain 1 flower.
// After day 1: [x, _, _, _, _]   // we can only make one bouquet.
// After day 2: [x, _, _, _, x]   // we can only make two bouquets.
// After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
// Example 2:

// Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
// Output: -1
// Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
// Example 3:

// Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
// Output: 12
// Explanation: We need 2 bouquets each should have 3 flowers.
// Here is the garden after the 7 and 12 days:
// After day 7: [x, x, x, x, _, x, x]
// We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
// After day 12: [x, x, x, x, x, x, x]
// It is obvious that we can make two bouquets in different ways.
 

// Constraints:

// bloomDay.length == n
// 1 <= n <= 105
// 1 <= bloomDay[i] <= 109
// 1 <= m <= 106
// 1 <= k <= n

//We have to find the minimum number of days to make m bouquets with k flowers each
//We can use binary search to find the minimum number of days
//We can start from the minimum day and go till the maximum day
//For each day we can check if we can make m bouquets with k flowers each
//If we can make m bouquets with k flowers each then we can return the day
//Else we can return -1
//Time complexity is O(nlogn) where n is the length of the bloomDay array
//Space complexity is O(1)

// public class Solution {
//     public int minDays(int[] bloomDay, int m, int k) {
//         if (m * k > bloomDay.length) {
//             return -1;
//         }
        
//         int left = 1, right = Arrays.stream(bloomDay).max().getAsInt();
        
//         while (left < right) {
//             int mid = left + (right - left) / 2;
//             if (canMakeBouquets(bloomDay, m, k, mid)) {
//                 right = mid;
//             } else {
//                 left = mid + 1;
//             }
//         }
        
//         return left;
//     }

//     private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
//         int bouquets = 0;
//         int flowers = 0;

//         for (int bloom : bloomDay) {
//             if (bloom <= days) {
//                 flowers++;
//                 if (flowers == k) {
//                     bouquets++;
//                     flowers = 0;
//                 }
//             } else {
//                 flowers = 0;
//             }
//         }

//         return bouquets >= m;
//     }

//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
//         int m = 2, k = 3;
//         System.out.println(sol.minDays(bloomDay, m, k)); // Output should be 12
//     }
// }

 
//Brute Force Approach :
//We can start from the minimum day and go till the maximum day
//For each day we can check if we can make m bouquets with k flowers each
//If we can make m bouquets with k flowers each then we can return the day
//Else we can return -1
//Time complexity is O(n^2) where n is the length of the bloomDay array

import java.util.Arrays;
class MinNumberofWaysToMakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
         int maxDay = Arrays.stream(bloomDay).max().getAsInt();
        int minDay = Arrays.stream(bloomDay).min().getAsInt();

        for (int day = minDay; day <= maxDay; day++) {
            if (canMakeBouquets(bloomDay, m, k, day)) {
                return day;
            }
        }
        return -1;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int currentDay) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= currentDay) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
        
    }

    public static void main(String[] args) {
        MinNumberofWaysToMakeBouquets obj = new MinNumberofWaysToMakeBouquets();
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(obj.minDays(bloomDay, m, k));
    }

}