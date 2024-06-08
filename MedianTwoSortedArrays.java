// 4. Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

 

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

// Constraints:

// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106

// we have used two pointer approach to merge the two sorted arrays. We start by initializing two pointers i and j to 0. We compare the elements at the ith and jth index of the two arrays. We add the smaller element to the merged array and increment the corresponding pointer. We continue this process until we reach the middle of the merged array. If the total number of elements in the merged array is odd, we return the middle element. If the total number of elements in the merged array is even, we return the average of the middle two elements.

// We have used the following approach to find the median of two sorted arrays:
// We initialize two pointers i and j to 0.
// We compare the elements at the ith and jth index of the two arrays.
// We add the smaller element to the merged array and increment the corresponding pointer.
// We continue this process until we reach the middle of the merged array.
// If the total number of elements in the merged array is odd, we return the middle element.
// If the total number of elements in the merged array is even, we return the average of the middle two elements.
// The time complexity of this approach is O(m+n), where m and n are the lengths of the two input arrays.


class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0, m1 = 0, m2 = 0;

        // Find median.
        for (int count = 0; count <= (n + m) / 2; count++) {
            m2 = m1;
            if (i != n && j != m) {
                if (nums1[i] > nums2[j]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return (double) m1;
        } else {
            double ans = (double) m1 + (double) m2;
            return ans / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianTwoSortedArrays mtsa = new MedianTwoSortedArrays();
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        System.out.println(mtsa.findMedianSortedArrays(nums1, nums2));
    }
}